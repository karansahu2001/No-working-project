package com.Noworking.services;

import com.Noworking.dto.RatingDTO;

import java.util.List;

public interface RatingService {
    List<RatingDTO> getAllRatings();

//    List<RatingDTO> getRatingsByUserId(long userId);
//
//    List<RatingDTO> getRatingsByProductDetailsId(long productDetailsId);

    RatingDTO saveRating(RatingDTO ratingDTO);

    RatingDTO getRatingById(long id);

    void deleteRating(long id);
}
