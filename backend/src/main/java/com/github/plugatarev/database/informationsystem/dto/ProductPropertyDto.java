package com.github.plugatarev.database.informationsystem.dto;

import com.github.plugatarev.database.informationsystem.entity.ProductTypeAttribute;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPropertyDto extends AbstractDto {
    private ProductDto product;
    private ProductTypeAttribute attribute;
    private String value;
}

