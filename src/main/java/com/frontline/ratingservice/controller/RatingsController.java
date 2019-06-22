package com.frontline.ratingservice.controller;


import com.frontline.ratingservice.dto.RatingDTO;
import com.frontline.ratingservice.entity.Rating;
import com.frontline.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @ResponseBody
    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public String getRatingByProductId(@PathVariable("productId") String productId){
        RatingDTO matchingRatingDTO = ratingService.getRatingByProductId(productId);
        if(matchingRatingDTO != null){
            return matchingRatingDTO.toString();
        }
        else return "No rating found for product id: "+productId;
    }
}
