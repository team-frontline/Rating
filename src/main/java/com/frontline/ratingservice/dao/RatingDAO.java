package com.frontline.ratingservice.dao;

import com.frontline.ratingservice.entity.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingDAO extends CrudRepository<Rating, Integer> {

    @Query("SELECT rating FROM Rating rating WHERE rating.productId = ?1")
    List<Rating> getRatingByProductId(String productId);
}
