package com.Noworking.services.impl;

import com.Noworking.dto.WorkingTimeDTO;
import com.Noworking.entities.ProductDetails;
import com.Noworking.entities.WorkingTime;
import com.Noworking.repositories.ProductDetailsRepository;
import com.Noworking.repositories.WorkingTimeRepository;
import com.Noworking.services.WorkingTimeService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class WorkingTimeServiceImpl implements WorkingTimeService {

    private WorkingTimeRepository workingTimeRepository;
    private ModelMapper modelMapper;
    private ProductDetailsRepository productDetailsRepository;

    public WorkingTimeServiceImpl(WorkingTimeRepository workingTimeRepository, ModelMapper modelMapper, ProductDetailsRepository productDetailsRepository) {
        this.workingTimeRepository = workingTimeRepository;
        this.modelMapper = modelMapper;
        this.productDetailsRepository = productDetailsRepository;
    }

    @Override
    public WorkingTimeDTO save(WorkingTimeDTO workingTimeDTO) {
        long productDetailsId = workingTimeDTO.getProductDetailsId();
        ProductDetails ProductDetail = productDetailsRepository.findByProductDetailID(productDetailsId).orElseThrow(() -> new RuntimeException("Product Details time not found with id: " + productDetailsId));
        WorkingTime workingTime = modelMapper.map(workingTimeDTO, WorkingTime.class);
        workingTime.setProductDetails(ProductDetail);
        WorkingTime save = workingTimeRepository.save(workingTime);
        return modelMapper.map(save, WorkingTimeDTO.class);

    }

    @Override
    public List<WorkingTimeDTO> findAll() {
        List<WorkingTime> workingTimes = workingTimeRepository.findAll();
        return workingTimes.stream().map(e -> modelMapper.map(e, WorkingTimeDTO.class)).collect(Collectors.toList());

    }

    @Override
    public WorkingTimeDTO findOne(long id) {
        WorkingTime workingTime = this.workingTimeRepository.findById(id).orElseThrow(() -> new RuntimeException("Working time not found with id: " + id));
        return modelMapper.map(workingTime, WorkingTimeDTO.class);

    }

    @Override
    public void delete(long id) {
        WorkingTime workingTime = this.workingTimeRepository.findById(id).orElseThrow(() -> new RuntimeException("Working time not found with id: " + id));
       this.workingTimeRepository.delete(workingTime);

    }

    @Override
    public List<WorkingTimeDTO> findByProductId(long productId) {
        List<WorkingTime> workingTimes = workingTimeRepository.findByProductDetailsId(productId);
        return workingTimes.stream().map(e -> modelMapper.map(e, WorkingTimeDTO.class)).collect(Collectors.toList());

    }

    @Override
    public List<WorkingTimeDTO> findByUserId(long userId) {
        return List.of();
    }

    @Override
    public List<WorkingTimeDTO> findByDate(String startDate, String endDate) {
        return List.of();
    }
}
