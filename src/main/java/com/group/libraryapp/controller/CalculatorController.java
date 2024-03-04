package com.group.libraryapp.controller;

import com.group.libraryapp.dto.calculator.request.*;
import com.group.libraryapp.dto.calculator.response.CalculatorResponse;
import com.group.libraryapp.dto.calculator.response.DayResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddRequest request){
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply")
    public int multiplyTwonNumbers(@RequestBody CalculatorMultiplyRequest request){
        return request.getNumber1()* request.getNumber2();
    }

    @GetMapping("/api/v1/calc")
    public CalculatorResponse calculator(CalculatorRequest request){
        return new CalculatorResponse(request);
    }
    @GetMapping("/api/v1/day-of-the-week")
    public DayResponse dayOfTheWeek(DayRequest request){
        return new DayResponse(request);
    }

    @PostMapping("/api/v1/sum")
    public int listSum(@RequestBody SumRequest request){

        int sum = request.getNumbers().stream().mapToInt(Integer::intValue).sum();
        return sum;
    }
}
