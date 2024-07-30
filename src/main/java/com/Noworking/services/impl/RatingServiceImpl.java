package com.Noworking.services.impl;

import com.Noworking.dto.RatingDTO;
import com.Noworking.entities.Rating;
import com.Noworking.exceptions.DataNotFoundException;
import com.Noworking.repositories.RatingRepository;
import com.Noworking.services.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RatingDTO> getAllRatings() {
        return ratingRepository.findAll().stream()
                .map(rating -> modelMapper.map(rating, RatingDTO.class))
                .collect(Collectors.toList());
    }

//    @Override
//    public List<RatingDTO> getRatingsByUserId(long userId) {
//        return ratingRepository.findByUserId(userId).stream()
//                .map(rating -> modelMapper.map(rating, RatingDTO.class))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<RatingDTO> getRatingsByProductDetailsId(long productDetailsId) {
//        return ratingRepository.findByProductDetailsId(productDetailsId).stream()
//                .map(rating -> modelMapper.map(rating, RatingDTO.class))
//                .collect(Collectors.toList());
//    }

    @Override
    public RatingDTO saveRating(RatingDTO ratingDTO) {
        Rating rating = modelMapper.map(ratingDTO, Rating.class);
        return modelMapper.map(ratingRepository.save(rating), RatingDTO.class);
    }

    @Override
    public RatingDTO getRatingById(long id) {
        Rating rating = ratingRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Rating not found with id: " + id));
        return modelMapper.map(rating, RatingDTO.class);
    }

    @Override
    public void deleteRating(long id) {
        if (!ratingRepository.existsById(id)) {
            throw new DataNotFoundException("Rating not found with id: " + id);
        }
        ratingRepository.deleteById(id);
    }
}
