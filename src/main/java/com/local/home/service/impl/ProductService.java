package com.local.home.service.impl;

import com.local.home.repository.ProductRepository;
import com.local.home.service.IProductService;
import com.local.home.service.dto.ProductDto;
import com.local.home.service.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductService(ProductRepository _productRepository,
                          ProductMapper _productMapper) {
        productRepository = _productRepository;
        productMapper = _productMapper;
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll()
                .stream().map(productMapper::toDto).collect(Collectors.toList());
    }
}