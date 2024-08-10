package com.Noworking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PRODUCT_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_id", unique=true, nullable=false)
    private Long userID;

    @Column(nullable=false)
    private int price;

    @Column(nullable=false)
    private int status;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;  // Changed from 'create' to 'created_at'

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @Column(nullable=false)
    private long phone;

    @Column(nullable=false)
    private String email;

    @OneToMany(mappedBy = "productDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WorkingTime> workingTime = new ArrayList<>();

    @OneToMany(mappedBy = "productDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rating> ratings;

    @OneToMany(mappedBy = "productDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookingDetails> bookingDetails = new ArrayList<>();
}
