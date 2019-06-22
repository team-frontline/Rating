package com.frontline.ratingservice.service;

import com.frontline.ratingservice.dao.RatingDAO;
import com.frontline.ratingservice.dto.RatingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {

    @Autowired
    RatingDAO ratingDAO;

    public List<RatingDTO> getAllRatings() {
        List<RatingDTO> ratingDTOList = new ArrayList<>();
        ratingDAO.findAll().forEach(rating -> ratingDTOList.add(new RatingDTO(rating)));
        return ratingDTOList;
    }
}
