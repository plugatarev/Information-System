package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.ProductDto;
import com.github.plugatarev.database.informationsystem.entity.Product;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.ProductMapper;
import com.github.plugatarev.database.informationsystem.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService extends AbstractService<Product, ProductDto> {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    protected JpaRepository<Product, Long> getRepository() {
        return productRepository;
    }

    @Override
    protected IMapper<Product, ProductDto> getMapper() {
        return productMapper;
    }
}
