package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.ProductCategoryDto;
import com.github.plugatarev.database.informationsystem.entity.ProductCategory;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.ProductCategoryMapper;
import com.github.plugatarev.database.informationsystem.repository.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductCategoryService extends AbstractService<ProductCategory, ProductCategoryDto> {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryMapper productCategoryMapper;

    @Override
    protected JpaRepository<ProductCategory, Long> getRepository() {
        return productCategoryRepository;
    }

    @Override
    protected IMapper<ProductCategory, ProductCategoryDto> getMapper() {
        return productCategoryMapper;
    }
}
