package com.Noworking.repositories;

import com.Noworking.entities.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {

    // Custom method using method naming convention
    List<ProductDetails> findByUserID(String userID);

    // Custom method using @Query annotation
    @Query("SELECT p FROM ProductDetails p WHERE p.id = ?1 AND p.status=1")
    Optional<ProductDetails> findByProductDetailID(long id);
}
