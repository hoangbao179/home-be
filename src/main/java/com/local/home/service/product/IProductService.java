package com.local.home.service.product;

import com.local.home.dto.product.ProductDto;
import com.local.home.entity.Product;

import java.util.List;

public interface IProductService {
    List<ProductDto> findAll();

    Product create(ProductDto dto) ;

    Product update(ProductDto dto);

    Product getById(Long id) ;
}
