package com.group.libraryapp.repository.hw;

import com.group.libraryapp.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit,Long> {
    List<Fruit> findByNameAndIsSold(String name,boolean isSold);
    List<Fruit> findAllByName(String name);
    List<Fruit> findAllByPriceGreaterThanEqualAndIsSold(long price,boolean isSold);
    List<Fruit> findAllByPriceLessThanEqualAndIsSold(long price,boolean isSold);

}
