package com.group.libraryapp.dto.calculator.response;

import com.group.libraryapp.dto.calculator.request.DayRequest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Locale;

public class DayResponse {

    private String dayOfTheWeek;

    public DayResponse(DayRequest request) {
        LocalDate today = request.getDate();
        this.dayOfTheWeek = today.getDayOfWeek()
                                 .getDisplayName(TextStyle.SHORT, Locale.US)
                                 .toUpperCase();
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }
}
