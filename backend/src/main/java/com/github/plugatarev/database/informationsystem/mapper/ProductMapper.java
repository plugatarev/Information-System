package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.ProductDto;
import com.github.plugatarev.database.informationsystem.entity.Product;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper extends IMapper<Product, ProductDto> {
    @Override
    ProductDto toDto(Product product);

    @Override
    Product toEntity(ProductDto productDto);
}
