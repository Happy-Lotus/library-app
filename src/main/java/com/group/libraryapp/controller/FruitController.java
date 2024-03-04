package com.group.libraryapp.controller;

import com.group.libraryapp.domain.Fruit;
import com.group.libraryapp.dto.hw.FruitCountResponse;
import com.group.libraryapp.dto.hw.FruitCreateRequest;
import com.group.libraryapp.dto.hw.FruitListResponse;
import com.group.libraryapp.dto.hw.FruitResponse;
import com.group.libraryapp.service.hw.FruitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class FruitController {
    private final FruitService fruitService;
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }
    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request){
        fruitService.saveFruit(request);
    }

    @PutMapping("/api/v1/fruit")
    public void sellFruit(@RequestBody Map<String,Long> body){
        fruitService.sellFruit(body.get("id"));
    }

    @GetMapping("/api/v1/fruit")
    public FruitResponse calcPrice(@RequestParam String name){
        return fruitService.calcPrice(name);
    }

    @GetMapping("/api/v1/fruit/count")
    public FruitCountResponse countFruit(@RequestParam String name){
        return fruitService.countFruit(name);
    }

    @GetMapping("/api/v1/fruit/list")
    public List<FruitListResponse> returnFruitList(@RequestParam String option, long price){
        return fruitService.returnFruitList(option,price);
    }
}
