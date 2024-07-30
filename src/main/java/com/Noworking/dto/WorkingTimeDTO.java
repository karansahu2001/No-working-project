package com.Noworking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkingTimeDTO {
    private long id;
    private String availabilityType;
    private LocalDate specificDate;
    private Integer dayOfWeek;
    private Integer dayOfMonth;
    private LocalTime startTime;
    private LocalTime endTime;
    private long productDetailsId;


}
