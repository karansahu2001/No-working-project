package com.Noworking.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "WORKING_TIME")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkingTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private AvailabilityType availabilityType;

    private LocalDate specificDate;
    private Integer dayOfWeek;  // 1=Monday, 7=Sunday
    private Integer dayOfMonth; // 1 to 31

    private LocalTime startTime;
    private LocalTime endTime;

    // Getters and Setters

    public enum AvailabilityType {
        WEEKLY,
        MONTHLY,
        SPECIFIC_DATE
    }

    @ManyToOne
    @JoinColumn(name = "product_details_id")
    private ProductDetails productDetails;
}
