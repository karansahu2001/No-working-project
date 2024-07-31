package com.Noworking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "BOOKING_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private int user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductDetails productDetails;

    @Column(nullable = false)
    private LocalDateTime bookingStartDateTime;

    @Column(nullable = false)
    private LocalDateTime bookingEndDateTime;

    @Column(nullable = false)
    private int status;

}
