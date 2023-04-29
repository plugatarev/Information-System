package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.ProductCategoryDto;
import com.github.plugatarev.database.informationsystem.entity.ProductCategory;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductCategoryMapper extends IMapper<ProductCategory, ProductCategoryDto> {
    @Override
    ProductCategoryDto toDto(ProductCategory productCategory);

    @Override
    ProductCategory toEntity(ProductCategoryDto productCategoryDto);
}
