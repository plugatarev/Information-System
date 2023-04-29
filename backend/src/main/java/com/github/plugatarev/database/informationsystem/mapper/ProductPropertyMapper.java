package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.ProductPropertyDto;
import com.github.plugatarev.database.informationsystem.entity.ProductProperty;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductPropertyMapper extends IMapper<ProductProperty, ProductPropertyDto> {
    @Override
    ProductPropertyDto toDto(ProductProperty productProperty);

    @Override
    ProductProperty toEntity(ProductPropertyDto productPropertyDto);
}
