package com.frontline.ratingservice.controller;


import com.frontline.ratingservice.dto.RatingDTO;
import com.frontline.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RatingsController {

    @Autowired
    private RatingService ratingService;

    @ResponseBody
    @RequestMapping("/")
    public String getAllRatings() {
        List<RatingDTO> allRatingsList = ratingService.getAllRatings();
        StringBuilder sb = new StringBuilder();
        for (RatingDTO ratingDTO: allRatingsList
             ) {
            sb.append(ratingDTO.toString()).append("\n");
        }
        return sb.toString();
    }
}
