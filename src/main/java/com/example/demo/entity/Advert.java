package com.example.demo.entity;

import com.example.demo.enums.ECategory;
import com.example.demo.enums.EStatus;
import com.example.demo.visitors.AdvertVisitor;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("standartAdvert")
@Data
public class Advert {
    @Id
    @GeneratedValue
    private long id;

    private String title;
    private String description;
    private ECategory category;
    private EStatus status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public void accept(AdvertVisitor advertVisitor) {
        advertVisitor.visit(this);
    }
}
