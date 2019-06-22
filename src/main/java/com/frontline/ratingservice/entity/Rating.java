package com.frontline.ratingservice.entity;

import com.frontline.ratingservice.dto.RatingDTO;

import javax.persistence.*;

@Entity
@Table(name = "RATING")
public class Rating {
    @Id
    @GeneratedValue
    private Integer ratingId;

    @Column
    private String productId;

    @Column
    private Integer numberOfRaters = 1;

    @Column
    private Integer rating;

    public Rating() {
    }

    public Rating(RatingDTO ratingDTO) {
        this.productId = ratingDTO.getProductId();
        this.rating = ratingDTO.getRating();
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

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setNumberOfRaters(Integer numberOfRaters) {
        this.numberOfRaters = numberOfRaters;
    }
}
