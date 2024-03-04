package com.group.libraryapp.dto.hw;

import lombok.Getter;
import org.springframework.jdbc.core.JdbcTemplate;

@Getter
public class FruitResponse {

    private long salesAmount;
    private long notSalesAmount;

    public FruitResponse(long salesAmount,long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }






}
