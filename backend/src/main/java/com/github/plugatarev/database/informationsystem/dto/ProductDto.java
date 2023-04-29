package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto extends AbstractDto {
    private ProductCategoryTypeDto categoryType;
    private DepartmentDto manufacturerDepartment;
    private String customer;
}
