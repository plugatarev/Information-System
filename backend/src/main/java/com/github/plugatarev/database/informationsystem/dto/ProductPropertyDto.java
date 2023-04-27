package com.github.plugatarev.database.informationsystem.dto;

import com.github.plugatarev.database.informationsystem.entity.ProductTypeAttribute;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPropertyDto extends AbstractDto {
    private ProductDto product;
    private ProductTypeAttribute attribute;
    private String value;
}

