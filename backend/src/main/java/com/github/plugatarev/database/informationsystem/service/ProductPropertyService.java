package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.ProductPropertyDto;
import com.github.plugatarev.database.informationsystem.entity.ProductProperty;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.ProductPropertyMapper;
import com.github.plugatarev.database.informationsystem.repository.ProductPropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductPropertyService extends AbstractService<ProductProperty, ProductPropertyDto> {

    private final ProductPropertyRepository productPropertyRepository;
    private final ProductPropertyMapper productPropertyMapper;

    @Override
    protected JpaRepository<ProductProperty, Long> getRepository() {
        return productPropertyRepository;
    }

    @Override
    protected IMapper<ProductProperty, ProductPropertyDto> getMapper() {
        return productPropertyMapper;
    }
}
