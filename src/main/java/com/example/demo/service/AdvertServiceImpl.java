package com.example.demo.service;

import com.example.demo.entity.Advert;
import com.example.demo.enums.ECategory;
import com.example.demo.enums.EStatus;
import com.example.demo.repository.AdvertRepository;
import com.example.demo.visitors.AdvertVisitorImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository advertRepository;

    public void save(Advert advert) {
        // TODO uzun oldu kanka biraz
        boolean exists = advertRepository.exists(Example.of(advert));
        String title = advert.getTitle();
        String description = advert.getDescription();
        ECategory category = advert.getCategory();
        boolean existsByTitleAndDescriptionAndCategory = advertRepository.existsByTitleAndDescriptionAndCategory(title, description, category);
        if (!exists) {
            AdvertVisitorImpl advertVisitor = new AdvertVisitorImpl();
            advert.accept(advertVisitor);
        }
        if (existsByTitleAndDescriptionAndCategory) advert.setStatus(EStatus.REPETITIVE);
        advertRepository.save(advert);
    }

    public List<Advert> findAll() {
        return advertRepository.findAll();
    }

    @Override
    public void approve(long id) {
        Optional<Advert> advert = advertRepository.findById(id);
        advert.ifPresent(value -> {
            value.setStatus(EStatus.ACTIVE);
            advertRepository.save(value);
        });
    }

    @Override
    public void deactive(long id) {
        Optional<Advert> advert = advertRepository.findById(id);
        advert.ifPresent(value -> {
            value.setStatus(EStatus.DEACTIVE);
            advertRepository.save(value);
        });
    }
}
