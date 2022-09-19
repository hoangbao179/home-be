package com.local.home.service.impl;

import com.local.home.entity.Product;
import com.local.home.error.NotFoundException;
import com.local.home.repository.ProductRepository;
import com.local.home.service.IProductService;
import com.local.home.service.dto.ProductDto;
import com.local.home.service.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public Product create(ProductDto dto) {
        Product domain = productMapper.toEntity(dto);
        setDefaultCreate(domain);
        return productRepository.save(domain);
    }

    @Override
    public Product update(ProductDto dto){
        Product domain = productRepository.findById(dto.getId()).orElseThrow(()-> new NotFoundException("Entity not found"));
        productMapper.partialUpdate(domain, dto);
        setDefaultUpdate(domain);
        return productRepository.save(domain);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new NotFoundException("Entity not found"));
    }

    private void setDefaultCreate(Product domain) {
        domain.setUserCreate("admin");
        domain.setDateCreate(new Date());
    }

    private void setDefaultUpdate(Product domain) {
        domain.setUserUpdate("admin");
        domain.setDateUpdate(new Date());
    }
}