package com.Noworking.repositories;

import com.Noworking.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

//    // Custom method using method naming convention
//    List<Rating> findByUserId(long userId);
//
//    // Custom method using @Query annotation
//    @Query("SELECT r FROM Rating r WHERE r.productDetails.id = ?1")
//    List<Rating> findByProductDetailsId(long productDetailsId);
}
