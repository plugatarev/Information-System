package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductTypeAttributeDto extends AbstractDto {
    private String attributeName;
    private ProductCategoryDto category;
}
