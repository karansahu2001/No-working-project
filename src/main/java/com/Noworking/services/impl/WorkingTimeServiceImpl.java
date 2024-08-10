package com.Noworking.services.impl;

import com.Noworking.dto.WorkingTimeDTO;
import com.Noworking.entities.ProductDetails;
import com.Noworking.entities.WorkingTime;
import com.Noworking.exceptions.DataNotFoundException;
import com.Noworking.repositories.ProductDetailsRepository;
import com.Noworking.repositories.WorkingTimeRepository;
import com.Noworking.services.WorkingTimeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkingTimeServiceImpl implements WorkingTimeService {

    private final WorkingTimeRepository workingTimeRepository;
    private final ModelMapper modelMapper;
    private final ProductDetailsRepository productDetailsRepository;

    @Autowired
    public WorkingTimeServiceImpl(WorkingTimeRepository workingTimeRepository, ModelMapper modelMapper, ProductDetailsRepository productDetailsRepository) {
        this.workingTimeRepository = workingTimeRepository;
        this.modelMapper = modelMapper;
        this.productDetailsRepository = productDetailsRepository;
    }

    @Override
    public WorkingTimeDTO save(WorkingTimeDTO workingTimeDTO) {
        long productDetailsId = workingTimeDTO.getProductDetailsId();
        ProductDetails productDetail = productDetailsRepository.findByProductDetailID(productDetailsId)
                .orElseThrow(() -> new RuntimeException("Product Details not found with id: " + productDetailsId));
        WorkingTime workingTime = modelMapper.map(workingTimeDTO, WorkingTime.class);
        workingTime.setProductDetails(productDetail);
        WorkingTime saved = workingTimeRepository.save(workingTime);
        return modelMapper.map(saved, WorkingTimeDTO.class);
    }

    @Override
    public List<WorkingTimeDTO> findAll() {
        List<WorkingTime> workingTimes = workingTimeRepository.findAll();
        return workingTimes.stream()
                .map(e -> modelMapper.map(e, WorkingTimeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public WorkingTimeDTO findOne(long id) {
        WorkingTime workingTime = workingTimeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Working time not found with id: " + id));
        return modelMapper.map(workingTime, WorkingTimeDTO.class);
    }

    @Override
    public void delete(long id) {
        WorkingTime workingTime = workingTimeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Working time not found with id: " + id));
        workingTimeRepository.delete(workingTime);
    }

    @Override
    public List<WorkingTimeDTO> findByProductId(long productId) {
        List<WorkingTime> workingTimes = workingTimeRepository.findByProductDetailsId(productId);
        return workingTimes.stream()
                .map(e -> modelMapper.map(e, WorkingTimeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<WorkingTimeDTO> findByUserId(long userId) {
        // Implement method or remove if not needed
        return List.of();
    }

    @Override
    public List<WorkingTimeDTO> findByDate(String startDate, String endDate) {
        // Implement method or remove if not needed
        return List.of();
    }

    @Override
    public List<WorkingTimeDTO> save(List<WorkingTimeDTO> workingTimeDTOList, long productId) {
        ProductDetails productDetail = productDetailsRepository.findByProductDetailID(productId)
                .orElseThrow(() -> new DataNotFoundException("Product Details not found with id: " + productId));
        List<WorkingTime> workingTimeList = workingTimeDTOList.stream()
                .map(e -> {
                    WorkingTime workingTime = modelMapper.map(e, WorkingTime.class);
                    workingTime.setProductDetails(productDetail);
                    return workingTime;
                })
                .collect(Collectors.toList());
        List<WorkingTime> savedWorkingTimes = workingTimeRepository.saveAll(workingTimeList);
        return savedWorkingTimes.stream()
                .map(e -> modelMapper.map(e, WorkingTimeDTO.class))
                .collect(Collectors.toList());
    }
}
