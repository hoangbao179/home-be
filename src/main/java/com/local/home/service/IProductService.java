package com.local.home.service;

import com.local.home.entity.Product;
import com.local.home.service.dto.ProductDto;

import java.util.List;

public interface IProductService {
    List<ProductDto> findAll();

    Product create(ProductDto dto) ;

    Product update(ProductDto dto);

    Product getById(Long id) ;
}
