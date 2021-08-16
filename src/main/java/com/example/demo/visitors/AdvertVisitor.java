package com.example.demo.visitors;

import com.example.demo.entity.Advert;

public interface AdvertVisitor {
    void visit(Advert advert);
}
