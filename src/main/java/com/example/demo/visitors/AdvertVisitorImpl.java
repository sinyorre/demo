package com.example.demo.visitors;

import com.example.demo.entity.Advert;
import com.example.demo.utils.AdvertUtil;

public class AdvertVisitorImpl implements AdvertVisitor {
    @Override
    public void visit(Advert advert) {
        AdvertUtil.setAdvertStatus(advert);
        AdvertUtil.setAdvertDates(advert);
    }
}
