package com.example.demo.controller;

import com.example.demo.entity.Advert;
import com.example.demo.model.DeactiveRequest;
import com.example.demo.model.UpdateRequest;
import com.example.demo.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdvertController {

    private final AdvertService advertService;

    @GetMapping("/hello")
    private String hello() {
        return "hello";
    }

    @PostMapping("/save")
    private ResponseEntity<Boolean> saveAdvert(@RequestBody Advert advert) {
        advertService.save(advert);
        return ResponseEntity.ok(true);
    }

    @PostMapping("/findAll")
    private ResponseEntity<List<Advert>> findAll() {
        List<Advert> all = advertService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }

    @PostMapping("/approve")
    private ResponseEntity<Boolean> approve(@RequestBody UpdateRequest updateRequest){
        long id = updateRequest.getId();
        advertService.approve(id);
        return ResponseEntity.ok().body(true);
    }

    @PostMapping("/deactive")
    private ResponseEntity<Boolean> deactive(@RequestBody DeactiveRequest deactiveRequest){
        long id = deactiveRequest.getId();
        advertService.deactive(id);
        return ResponseEntity.ok().body(true);
    }
}
