package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.ProductProcessDto;
import com.github.plugatarev.database.informationsystem.entity.ProductProcess;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductProcessMapper extends IMapper<ProductProcess, ProductProcessDto> {
    @Override
    ProductProcessDto toDto(ProductProcess productProcess);

    @Override
    ProductProcess toEntity(ProductProcessDto productProcessDto);
}