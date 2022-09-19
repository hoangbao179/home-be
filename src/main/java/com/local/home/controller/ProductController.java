package com.local.home.controller;

import com.local.home.entity.Product;
import com.local.home.service.IProductService;
import com.local.home.service.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Get product by Id
     *
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Product data = productService.getById(id);
        return ResponseEntity.ok().body(data);
    }

    /**
     * Create product
     *
     * @return
     */
    @PostMapping
    public ResponseEntity<Product> create(ProductDto dto) {
        Product data = productService.create(dto);
        return ResponseEntity.ok().body(data);
    }

    /**
     * Update product
     *
     * @return
     */
    @PutMapping
    public ResponseEntity<Product> update(ProductDto dto) {
        Product data = productService.update(dto);
        return ResponseEntity.ok().body(data);
    }
}
