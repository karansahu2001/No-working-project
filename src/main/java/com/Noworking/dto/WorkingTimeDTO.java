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
    private AvailabilityType availabilityType;
    private LocalDate specificDate;
    private Integer dayOfWeek;
    private Integer dayOfMonth;
    private LocalTime startTime;
    private LocalTime endTime;
    private long productDetailsId;
    public enum AvailabilityType {
        WEEKLY,
        MONTHLY,
        SPECIFIC_DATE,
        EVERY_DAY,
        WEEKEND,
        WEEKDAY
    }
}
