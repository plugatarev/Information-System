package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.ProductCategoryTypeDto;
import com.github.plugatarev.database.informationsystem.entity.ProductCategoryType;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductCategoryTypeMapper {
    ProductCategoryTypeDto productCategoryTypeToProductCategoryTypeDto(ProductCategoryType productCategoryType);

    ProductCategoryType productCategoryTypeDtoToProductCategoryType(ProductCategoryTypeDto productCategoryTypeDto);
}
