package com.Noworking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDetailsDTO {
    private long id;
    private long userID;
    private int price;
    private int status;
    private Date updatedAt;  // Changed from 'update' to 'updatedAt'
    private Date update;
    private long phone;
    private String email;
    private List<WorkingTimeDTO> workingTime;
    private List<RatingDTO> ratings;

    // Getters and Setters
}
