package com.group.libraryapp.service.hw;

import com.group.libraryapp.domain.Fruit;
import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.dto.hw.FruitCountResponse;
import com.group.libraryapp.dto.hw.FruitCreateRequest;
import com.group.libraryapp.dto.hw.FruitListResponse;
import com.group.libraryapp.dto.hw.FruitResponse;
import com.group.libraryapp.repository.hw.FruitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruit(FruitCreateRequest request){
        fruitRepository.save(new Fruit(request.getName(),request.getWarehousingDate(),request.getPrice()));
    }

    public void sellFruit(long id){
        String sql = "UPDATE fruit SET isSold=1 WHERE id=?";
        Fruit fruit = fruitRepository.findById(id)
                        .orElseThrow();
        fruit.updateIsSold();
        fruitRepository.save(fruit);
    }

    public FruitResponse calcPrice(String name){

        long salesAmount = fruitRepository.findByNameAndIsSold(name,true)
                .stream().mapToLong(fruit->fruit.getPrice()).sum();
        long notSalesAmount = fruitRepository.findByNameAndIsSold(name,false)
                .stream().mapToLong(fruit->fruit.getPrice()).sum();

        return new FruitResponse(salesAmount,notSalesAmount);
    }

    public FruitCountResponse countFruit(String name){
        long count = fruitRepository.findAllByName(name).stream().count();
        return new FruitCountResponse(count);
    }

    public List<FruitListResponse> returnFruitList(String option, long price){

        if(option.equals("GTE")){
            return fruitRepository.findAllByPriceGreaterThanEqualAndIsSold(price,false)
                    .stream().map(fruit-> new FruitListResponse(fruit.getName(),fruit.getPrice(),fruit.getWarehousingDate()))
                    .collect(Collectors.toList());

        }else{
            return fruitRepository.findAllByPriceLessThanEqualAndIsSold(price,false)
                    .stream().map(fruit-> new FruitListResponse(fruit.getName(),fruit.getPrice(),fruit.getWarehousingDate()))
                    .collect(Collectors.toList());
        }
    }
}
