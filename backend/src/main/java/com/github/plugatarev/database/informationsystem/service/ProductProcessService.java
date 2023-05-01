package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.ProductProcessDto;
import com.github.plugatarev.database.informationsystem.entity.ProductProcess;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.ProductProcessMapper;
import com.github.plugatarev.database.informationsystem.repository.ProductProcessRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductProcessService extends AbstractService<ProductProcess, ProductProcessDto> {

    private final ProductProcessRepository productProcessRepository;
    private final ProductProcessMapper productProcessMapper;

    @Override
    protected JpaRepository<ProductProcess, Long> getRepository() {
        return productProcessRepository;
    }

    @Override
    protected IMapper<ProductProcess, ProductProcessDto> getMapper() {
        return productProcessMapper;
    }

    public Page<ProductProcessDto> getProductProcessByProduct(Long productId, Pageable pageable) {
        return productProcessRepository
                .findAllByProductId(productId, pageable)
                .map(productProcessMapper::toDto);
    }
}
