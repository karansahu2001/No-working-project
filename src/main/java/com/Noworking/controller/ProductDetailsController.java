package com.Noworking.controller;

import com.Noworking.dto.ProductDetailsDTO;
import com.Noworking.services.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductDetailsController {

    @Autowired
    private ProductDetailService productDetailService;

    @PostMapping
    public ResponseEntity<ProductDetailsDTO> saveProduct(@RequestBody ProductDetailsDTO productDetailsDTO) {

        ProductDetailsDTO savedProduct = productDetailService.save(productDetailsDTO);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDetailsDTO> updateProduct(
            @PathVariable("id") long productDetailsID,
            @RequestBody ProductDetailsDTO productDetailsDTO) {
        ProductDetailsDTO updatedProduct = productDetailService.update(productDetailsDTO, productDetailsID);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") long id) {
        productDetailService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<ProductDetailsDTO>> getAllProducts() {
        List<ProductDetailsDTO> products = productDetailService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductDetailsDTO> getProductByProductId(@PathVariable("productId") long productId) {
        ProductDetailsDTO product = productDetailService.findByProductId(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ProductDetailsDTO> getProductByUserId(@PathVariable("userId") long userId) {
        ProductDetailsDTO product = productDetailService.findByUserId(userId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/filter")
    public ResponseEntity<List<ProductDetailsDTO>> getProductsByFilter(@RequestBody ProductDetailsDTO filter) {
        List<ProductDetailsDTO> products = productDetailService.findByFilter(filter);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
