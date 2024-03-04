package com.group.libraryapp.dto.hw;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class FruitCreateRequest {

    private String name;
    private LocalDate warehousingDate;
    private long price;

    public FruitCreateRequest(String name, LocalDate warehousingDate, long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }
}
