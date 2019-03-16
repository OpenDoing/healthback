package com.wanyi.health.controller;

import com.wanyi.health.entity.Article;
import com.wanyi.health.entity.Food;
import com.wanyi.health.repository.FoodRepo;
import com.wanyi.health.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RestController
@CrossOrigin
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FoodRepo foodRepo;

    @GetMapping("/net")
    public String get(@RequestParam String food, @RequestParam Integer page){
        String url = "http://www.xjihe.com/api/cook/foodrelation?food=" + food + "&page=" + page;
        HttpHeaders headers = new HttpHeaders();
        headers.add("apikey", "6vpaNCsbaev4z0oMowAM2NguyMfQcyH7");
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        return response.getBody();
    }
    //243497a2beb7f4f5a93f4fdad19c56234

    @PostMapping("/add")
    public Object addFood(@RequestBody Food food) {
        foodRepo.save(food);
        return ResponseUtil.ok();
    }

    @PostMapping("/update")
    public Object updateFood(@RequestParam String food1, @RequestParam String food2,
                             @RequestParam String advice, @RequestParam String reason,
                             @RequestParam Integer id) {
        foodRepo.updateFood(food1, food2, advice, reason, id);
        return ResponseUtil.ok();
    }

    @GetMapping("/get")
    public Object getFood(@RequestParam Integer id) {
        return ResponseUtil.ok(foodRepo.findById(id));
    }

    @DeleteMapping("/del")
    public Object delFood(@RequestParam Integer id) {
        foodRepo.deleteById(id);
        return ResponseUtil.ok();
    }

    @GetMapping("/all")
    public Object getAllFood() {
        return ResponseUtil.ok(foodRepo.findAll());
    }

}
