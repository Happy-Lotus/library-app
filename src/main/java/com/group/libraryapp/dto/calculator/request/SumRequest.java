package com.group.libraryapp.dto.calculator.request;

import java.util.List;

public class SumRequest {

    private List<Integer> numbers;

    public SumRequest(){

    }

    public SumRequest(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
