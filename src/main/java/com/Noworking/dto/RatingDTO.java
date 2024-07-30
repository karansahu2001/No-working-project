package com.Noworking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RatingDTO {
    private long id;
    private long userId;
    private long productDetails;
    private int rating;
    private String comment;

}
