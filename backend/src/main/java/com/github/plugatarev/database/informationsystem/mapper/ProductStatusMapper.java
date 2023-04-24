package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.ProductStatusDto;
import com.github.plugatarev.database.informationsystem.entity.ProductStatus;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductStatusMapper {
    ProductStatusDto productStatusToProductStatusDto(ProductStatus productStatus);

    ProductStatus productStatusDtoToProductStatus(ProductStatusDto productStatusDto);
}
