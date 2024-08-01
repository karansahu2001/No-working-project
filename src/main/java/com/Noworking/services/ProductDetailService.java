package com.Noworking.services;

import com.Noworking.dto.ProductDetailsDTO;

import java.util.List;

public interface ProductDetailService {
    ProductDetailsDTO save(ProductDetailsDTO productDetailsDTO);
    ProductDetailsDTO update(ProductDetailsDTO productDetailsDTO, long productDetailsID);
    void delete(long id);
    List<ProductDetailsDTO> findAll();
    ProductDetailsDTO findByProductId(long productId);
    ProductDetailsDTO findByUserId(long productId);
    List<ProductDetailsDTO> findByFilter(ProductDetailsDTO filter);

}
