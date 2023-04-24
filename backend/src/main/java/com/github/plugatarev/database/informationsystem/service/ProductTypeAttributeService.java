package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.ProductTypeAttributeDto;
import com.github.plugatarev.database.informationsystem.entity.ProductTypeAttribute;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.ProductTypeAttributeMapper;
import com.github.plugatarev.database.informationsystem.repository.ProductTypeAttributeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductTypeAttributeService extends AbstractService<ProductTypeAttribute, ProductTypeAttributeDto> {

    private final ProductTypeAttributeRepository productTypeAttributeRepository;
    private final ProductTypeAttributeMapper productTypeAttributeMapper;

    @Override
    protected JpaRepository<ProductTypeAttribute, Long> getRepository() {
        return productTypeAttributeRepository;
    }

    @Override
    protected IMapper<ProductTypeAttribute, ProductTypeAttributeDto> getMapper() {
        return productTypeAttributeMapper;
    }
}
