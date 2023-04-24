package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.ProductCategoryTypeDto;
import com.github.plugatarev.database.informationsystem.entity.ProductCategoryType;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.ProductCategoryTypeMapper;
import com.github.plugatarev.database.informationsystem.repository.ProductCategoryTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductCategoryTypeService extends AbstractService<ProductCategoryType, ProductCategoryTypeDto> {

    private final ProductCategoryTypeRepository productCategoryTypeRepository;
    private final ProductCategoryTypeMapper productCategoryMapper;

    @Override
    protected JpaRepository<ProductCategoryType, Long> getRepository() {
        return productCategoryTypeRepository;
    }

    @Override
    protected IMapper<ProductCategoryType, ProductCategoryTypeDto> getMapper() {
        return productCategoryMapper;
    }
}
