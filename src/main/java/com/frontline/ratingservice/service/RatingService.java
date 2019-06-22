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

    public RatingDTO getRatingByProductId(String productId){
        Optional<Rating> ratingMatch = ratingDAO.getRatingByProductId(productId).stream().findAny();
        return ratingMatch.map(RatingDTO::new).orElse(null);
    }
}
