package com.Noworking.repositories;

import com.Noworking.entities.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkingTimeRepository extends JpaRepository<WorkingTime, Long> {

    // Custom method using method naming convention
    List<WorkingTime> findByProductDetailsId(long productDetailsId);

    // Custom method using @Query annotation
    @Query("SELECT w FROM WorkingTime w WHERE w.availabilityType = ?1")
    List<WorkingTime> findByAvailabilityType(WorkingTime.AvailabilityType availabilityType);
}
