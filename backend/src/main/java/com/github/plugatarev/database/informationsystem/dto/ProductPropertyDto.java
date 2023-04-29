package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPropertyDto extends AbstractDto {
    private ProductDto product;
    private ProductTypeAttributeDto attribute;
    private String value;
}

