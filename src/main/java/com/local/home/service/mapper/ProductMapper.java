package com.local.home.service.mapper;

import com.local.home.entity.Product;
import com.local.home.service.EntityMapper;
import com.local.home.service.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDto, Product> { }
