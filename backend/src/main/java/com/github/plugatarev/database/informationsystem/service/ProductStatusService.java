package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.ProductStatusDto;
import com.github.plugatarev.database.informationsystem.entity.ProductStatus;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.ProductStatusMapper;
import com.github.plugatarev.database.informationsystem.repository.ProductStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductStatusService extends AbstractService<ProductStatus, ProductStatusDto> {

    private final ProductStatusRepository productStatusRepository;
    private final ProductStatusMapper productStatusMapper;

    @Override
    protected JpaRepository<ProductStatus, Long> getRepository() {
        return productStatusRepository;
    }

    @Override
    protected IMapper<ProductStatus, ProductStatusDto> getMapper() {
        return productStatusMapper;
    }
}
