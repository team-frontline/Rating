package com.frontline.ratingservice.dao;

import com.frontline.ratingservice.entity.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingDAO extends CrudRepository<Rating, Integer> {
}
