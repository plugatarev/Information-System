package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.ProductDto;
import com.github.plugatarev.database.informationsystem.entity.Product;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.ProductMapper;
import com.github.plugatarev.database.informationsystem.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<ProductDto> getDepartmentRegionProducts(Long departmentRegionId, Pageable pageable) {
        return productRepository.findProductsByDepartmentRegion(departmentRegionId, pageable).map(productMapper::toDto);
    }

    public Page<ProductDto> getDepartmentProducts(Long departmentId, Pageable pageable) {
        return productRepository.findProductsByDepartment(departmentId, pageable).map(productMapper::toDto);
    }
}
