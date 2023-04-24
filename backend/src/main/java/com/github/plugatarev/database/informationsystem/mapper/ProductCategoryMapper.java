package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.ProductCategoryDto;
import com.github.plugatarev.database.informationsystem.entity.ProductCategory;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductCategoryMapper {
    ProductCategoryDto productCategoryToProductCategoryDto(ProductCategory productCategory);

    ProductCategory productCategoryDtoToProductCategory(ProductCategoryDto productCategoryDto);
}
