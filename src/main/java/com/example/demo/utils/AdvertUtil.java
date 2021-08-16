package com.example.demo.utils;

import com.example.demo.entity.Advert;
import com.example.demo.enums.ECategory;
import com.example.demo.enums.EStatus;

import java.time.LocalDateTime;

public class AdvertUtil {

    public static void setAdvertStatus(Advert advert) {
        ECategory category = advert.getCategory();
        if (category == ECategory.SHOPPING) advert.setStatus(EStatus.ACTIVE);
        else advert.setStatus(EStatus.WAITING);
    }

    public static void setAdvertDates(Advert advert){
        LocalDateTime now = LocalDateTime.now();
        ECategory category = advert.getCategory();
        advert.setStartTime(now);
        if (category == ECategory.REAL_ESTATE){
            advert.setEndTime(now.plusWeeks(4));
        } else if (category == ECategory.VEHICLE) {
            advert.setEndTime(now.plusWeeks(3));
        } else {
            advert.setEndTime(now.plusWeeks(8));
        }
    }
}
