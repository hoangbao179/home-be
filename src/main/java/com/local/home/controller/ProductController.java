package com.local.home.controller;

import com.local.home.service.IProductService;
import com.local.home.service.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    private IProductService productService;

    public ProductController(IProductService _productService) {
        productService = _productService;
    }

    /**
     * Get all product
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll() {
        List<ProductDto> data = productService.findAll();
        return ResponseEntity.ok().body(data);
    }
}
