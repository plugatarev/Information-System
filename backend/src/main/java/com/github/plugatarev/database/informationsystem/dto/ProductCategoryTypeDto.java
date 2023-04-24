package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCategoryTypeDto extends AbstractDto {
    private String name;
    private ProductCategoryDto category;
}
