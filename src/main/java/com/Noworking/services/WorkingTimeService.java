package com.Noworking.services;

import com.Noworking.dto.WorkingTimeDTO;

import java.util.List;


public interface WorkingTimeService {
    WorkingTimeDTO save(WorkingTimeDTO workingTimeDTO);
    List<WorkingTimeDTO> findAll();
    WorkingTimeDTO findOne(long id);
    void delete(long id);
    List<WorkingTimeDTO> findByProductId(long productId);
    List<WorkingTimeDTO> findByUserId(long userId);
    List<WorkingTimeDTO> findByDate(String startDate, String endDate);
}
