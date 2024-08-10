package com.Noworking.services.impl;

import com.Noworking.constants.RoleConstants;
import com.Noworking.dto.ProductDetailsDTO;
import com.Noworking.dto.WorkingTimeDTO;
import com.Noworking.entities.ProductDetails;
import com.Noworking.entities.Role;
import com.Noworking.entities.User;
import com.Noworking.repositories.ProductDetailsRepository;
import com.Noworking.repositories.RoleRepository;
import com.Noworking.repositories.UserRepository;
import com.Noworking.services.ProductDetailService;
import com.Noworking.services.WorkingTimeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    //STATUS : - 0 active, 1 waiting for verification , 2 Delete
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private ProductDetailsRepository productDetailsRepository;
    private WorkingTimeService workingTimeService;


    public ProductDetailServiceImpl( UserRepository userRepository, ModelMapper modelMapper, ProductDetailsRepository productDetailsRepository, WorkingTimeService workingTimeService) {

        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.productDetailsRepository = productDetailsRepository;
        this.workingTimeService = workingTimeService;
    }

    @Override
    public ProductDetailsDTO save(ProductDetailsDTO productDetailsDTO) {
        long userID = productDetailsDTO.getUserID();
        User user = userRepository.findById(userID).orElseThrow(() -> new RuntimeException("User Not Found"));
        List<WorkingTimeDTO> workingTimes = productDetailsDTO.getWorkingTime();
        productDetailsDTO.setWorkingTime(null);
        ProductDetails productDetails = modelMapper.map(productDetailsDTO, ProductDetails.class);
        productDetails.setStatus(1);
        productDetails.setCreatedAt(new Date());
        productDetails.setUpdatedAt(new Date());
        ProductDetails save = productDetailsRepository.save(productDetails);
        List<WorkingTimeDTO> workingTimeDTOS = workingTimeService.save(workingTimes, save.getId());
        ProductDetailsDTO detailsDTO = modelMapper.map(save, ProductDetailsDTO.class);
        detailsDTO.setWorkingTime(workingTimeDTOS);
        return detailsDTO;
    }

    @Override
    public ProductDetailsDTO update(ProductDetailsDTO productDetailsDTO, long productDetailsID) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<ProductDetailsDTO> findAll() {
        return List.of();
    }

    @Override
    public ProductDetailsDTO findByProductId(long productId) {
        return null;
    }

    @Override
    public ProductDetailsDTO findByUserId(long productId) {
        return null;
    }

    @Override
    public List<ProductDetailsDTO> findByFilter(ProductDetailsDTO filter) {
        return List.of();
    }
}
