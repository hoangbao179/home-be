package com.local.home.service;

import com.local.home.service.dto.ProductDto;
import java.util.List;

public interface IProductService {
    List<ProductDto> findAll();
}
