package com.example.demo.service;

import com.example.demo.entity.Advert;

import java.util.List;

public interface AdvertService {
    void save(Advert advert);

    List<Advert> findAll();

    void approve(long id);

    void deactive(long id);
}
