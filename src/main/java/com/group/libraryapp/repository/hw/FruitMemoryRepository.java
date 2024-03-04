package com.group.libraryapp.repository.hw;

import com.group.libraryapp.domain.Fruit;
import com.group.libraryapp.dto.hw.FruitResponse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FruitMemoryRepository{
    private final List<Fruit> fruits = new ArrayList<>();

    public void saveFruit(Fruit fruit) {
        fruits.add(fruit);
    }


    public void sellFruit(long id) {
//        Fruit fruit = fruits.get(id);
//        if(fruit!= null){
//            fruit.setSold(1);
//        }
    }


    public FruitResponse calcPrice(String name) {

        long num1 = fruits.stream().filter(f -> f.getName().equals(name) && f.isSold()).mapToLong(Fruit::getPrice).sum();
        long num2 = fruits.stream().filter(f -> f.getName().equals(name) && !f.isSold()).mapToLong(Fruit::getPrice).sum();

        return new FruitResponse(num1,num2);

    }
}
