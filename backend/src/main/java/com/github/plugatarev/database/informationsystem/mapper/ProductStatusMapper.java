package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.ProductStatusDto;
import com.github.plugatarev.database.informationsystem.entity.ProductStatus;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductStatusMapper extends IMapper<ProductStatus, ProductStatusDto> {
    @Override
    ProductStatusDto toDto(ProductStatus productStatus);

    @Override
    ProductStatus toEntity(ProductStatusDto productStatusDto);
}
