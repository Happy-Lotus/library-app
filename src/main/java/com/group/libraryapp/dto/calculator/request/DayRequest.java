package com.group.libraryapp.dto.calculator.request;

import java.time.LocalDate;

public class DayRequest {

    LocalDate date;

    public DayRequest(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}
