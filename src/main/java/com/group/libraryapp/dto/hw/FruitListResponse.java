package com.group.libraryapp.dto.hw;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class FruitListResponse {
    private String name;
    private long price;
    private LocalDate warehousingDate;

    public FruitListResponse(String name, long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
    }
}
