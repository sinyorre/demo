package com.example.demo.repository;

import com.example.demo.entity.Advert;
import com.example.demo.enums.ECategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Long> {
    boolean existsByTitleAndDescriptionAndCategory(String title, String description, ECategory category);
}
