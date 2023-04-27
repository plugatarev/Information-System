package com.github.plugatarev.database.informationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends AbstractDto {
    private ProductCategoryTypeDto categoryType;
    private DepartmentDto manufacturerDepartment;
    private String customer;
}
