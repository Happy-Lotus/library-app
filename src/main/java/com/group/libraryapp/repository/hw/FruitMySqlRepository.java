package com.group.libraryapp.repository.hw;

import com.group.libraryapp.domain.Fruit;
import com.group.libraryapp.dto.hw.FruitResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class FruitMySqlRepository{

    private final JdbcTemplate jdbcTemplate;

    public FruitMySqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFruit(Fruit fruit){
        String sql = "INSERT INTO fruit (name,warehousingDate,price) VALUES (?,?,?)";
        jdbcTemplate.update(sql,fruit.getName(),fruit.getWarehousingDate(),fruit.getPrice());
    }

    public void sellFruit(long id){
        String sql = "UPDATE fruit SET isSold=1 WHERE id=?";
        jdbcTemplate.update(sql,id);
    }

    public FruitResponse calcPrice(String name){
        String sql1 = "SELECT SUM(price) FROM fruit WHERE name=? AND isSold=?";
        String sql2 = "SELECT SUM(price) FROM fruit WHERE name=? AND isSold=?";

        long salesAmount = jdbcTemplate.queryForObject(sql1,Long.class,name,1);
        long notSalesAmount = jdbcTemplate.queryForObject(sql2,Long.class,name,0);

        return new FruitResponse(salesAmount,notSalesAmount);
    }
}
