package com.frontline.ratingservice.controller;


import com.frontline.ratingservice.dto.RatingDTO;
import com.frontline.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        for (RatingDTO ratingDTO : allRatingsList
        ) {
            sb.append(ratingDTO.toString()).append("\n");
        }
        return sb.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/get/{productId}", method = RequestMethod.GET)
    public String getRatingByProductId(@PathVariable("productId") String productId) {
        RatingDTO matchingRatingDTO = ratingService.getRatingByProductId(productId);
        if (matchingRatingDTO != null) {
            return matchingRatingDTO.toString();
        } else return "No rating found for product id: " + productId;
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRating(@RequestBody RatingDTO ratingDTO) {
        return ratingService.saveRating(ratingDTO).toString();
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateRating(@RequestBody RatingDTO ratingDTO) {
        RatingDTO updatedRatingDTO = ratingService.updateRating(ratingDTO);
        if (updatedRatingDTO != null) {
            return updatedRatingDTO.toString();
        }
        return "no matching record to update";
    }

}
