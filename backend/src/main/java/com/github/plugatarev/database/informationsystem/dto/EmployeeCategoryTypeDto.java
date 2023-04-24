package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeCategoryTypeDto extends AbstractDto {
    private String name;
    private EmployeeCategoryDto employeeCategory;
}
