package com.frontline.ratingservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rating {
    @Id
    @GeneratedValue
    private Integer ratingId;
    private String productId;
    private Integer rating;

    public Integer getRatingId() {
        return ratingId;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
