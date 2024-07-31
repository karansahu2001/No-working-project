package com.Noworking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDetailsDTO {
    private long id;
    private long userId;
    private long productId;
    private LocalDateTime bookingStartDateTime;
    private LocalDateTime bookingEndDateTime;
    private int status;
}
