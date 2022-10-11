package com.local.home.service.product;

import com.local.home.dto.product.ProductDto;
import com.local.home.entity.Product;
import com.local.home.error.NotFoundException;
import com.local.home.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Autowired
    private final ModelMapper mapper;

    public ProductService(ProductRepository _productRepository,
                          ModelMapper _mapper) {
        productRepository = _productRepository;
        mapper = _mapper;
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(x-> mapper.map(x, ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public Product create(ProductDto dto) {
        Product product = mapper.map(dto, Product.class);
        setDefaultCreate(product);
        return productRepository.save(product);
    }

    @Override
    public Product update(ProductDto dto){
        Product domain = productRepository.findById(dto.getId()).orElseThrow(()-> new NotFoundException("Entity not found"));
        Product product = mapper.map(dto, Product.class);
        setDefaultUpdate(product);
        return productRepository.save(product);
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