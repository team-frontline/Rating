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
    public List<RatingDTO> getAllRatings() {
        List<RatingDTO> allRatingsList = ratingService.getAllRatings();
        return allRatingsList;
    }

    @ResponseBody
    @RequestMapping(value = "/get/{productId}", method = RequestMethod.GET)
    public RatingDTO getRatingByProductId(@PathVariable("productId") String productId) {
        RatingDTO matchingRatingDTO = ratingService.getRatingByProductId(productId);
        return matchingRatingDTO;
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RatingDTO saveRating(@RequestBody RatingDTO ratingDTO) {
        return ratingService.saveRating(ratingDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RatingDTO updateRating(@RequestBody RatingDTO ratingDTO) {
        RatingDTO updatedRatingDTO = ratingService.updateRating(ratingDTO);
        if (updatedRatingDTO != null) {
            return updatedRatingDTO;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.DELETE)
    public RatingDTO deleteRating(@PathVariable String productId) {
        RatingDTO deletedRating = ratingService.deleteRating(productId);
        return deletedRating;
    }

}
