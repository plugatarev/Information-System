package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.ProductTypeAttributeDto;
import com.github.plugatarev.database.informationsystem.entity.ProductTypeAttribute;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductTypeAttributeMapper {
    ProductTypeAttributeDto productTypeAttributeToProductTypeAttributeDto(ProductTypeAttribute productTypeAttribute);

    ProductTypeAttribute productTypeAttributeDtoToProductTypeAttribute(ProductTypeAttributeDto productTypeAttributeDto);
}