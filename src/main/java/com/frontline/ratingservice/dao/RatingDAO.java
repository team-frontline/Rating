package com.frontline.ratingservice.dao;

import com.frontline.ratingservice.entity.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingDAO extends CrudRepository<Rating, Integer> {

    List<Rating> findByProductId(String productId);
}
