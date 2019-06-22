package com.frontline.ratingservice.dto;

import com.frontline.ratingservice.entity.Rating;

import java.io.Serializable;

public class RatingDTO implements Serializable {

    private Integer ratingId;
    private String productId;
    private Integer numberOfRaters;
    private Integer rating;

    public RatingDTO() {
    }

    public RatingDTO(Rating rating) {
        this.ratingId = rating.getRatingId();
        this.productId = rating.getProductId();
        this.numberOfRaters = rating.getNumberOfRaters();
        this.rating = rating.getRating();
    }

    public Integer getRatingId() {
        return ratingId;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getNumberOfRaters() {
        return numberOfRaters;
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

    public void setNumberOfRaters(Integer numberOfRaters) {
        this.numberOfRaters = numberOfRaters;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "RatingDTO{" +
                "ratingId=" + ratingId +
                ", productId='" + productId + '\'' +
                ", numberOfRaters=" + numberOfRaters +
                ", rating=" + rating +
                '}';
    }
}
