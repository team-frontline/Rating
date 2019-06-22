package com.frontline.ratingservice.service;

import com.frontline.ratingservice.dao.RatingDAO;
import com.frontline.ratingservice.dto.RatingDTO;
import com.frontline.ratingservice.entity.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    RatingDAO ratingDAO;

    public List<RatingDTO> getAllRatings() {
        List<RatingDTO> ratingDTOList = new ArrayList<>();
        ratingDAO.findAll().forEach(rating -> ratingDTOList.add(new RatingDTO(rating)));
        return ratingDTOList;
    }

    public RatingDTO getRatingByProductId(String productId) {
        Optional<Rating> ratingMatch = ratingDAO.findByProductId(productId).stream().findAny();
        return ratingMatch.map(RatingDTO::new).orElse(null);
    }

    public RatingDTO saveRating(RatingDTO ratingDTO) {
        Rating savedRating = ratingDAO.save(new Rating(ratingDTO));
        return new RatingDTO(savedRating);
    }

    public RatingDTO updateRating(RatingDTO ratingDTO) {
        Optional<Rating> ratingMatch = ratingDAO.findByProductId(ratingDTO.getProductId()).stream().findAny();

        if (ratingMatch.isPresent()) {
            Rating ratingToUpdate = ratingMatch.get();
            int raterRating = ratingToUpdate.getRating() * ratingToUpdate.getNumberOfRaters();
            ratingToUpdate.setNumberOfRaters(ratingToUpdate.getNumberOfRaters() + 1);
            float newRating = (raterRating + ratingDTO.getRating()) / ratingToUpdate.getNumberOfRaters();
            ratingToUpdate.setRating(Math.round(newRating));

            ratingDAO.save(ratingToUpdate);
            return new RatingDTO(ratingToUpdate);
        }
        return null;
    }
}
