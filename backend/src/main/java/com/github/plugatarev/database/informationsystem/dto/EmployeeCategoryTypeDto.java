package com.github.plugatarev.database.informationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCategoryTypeDto extends AbstractDto {
    private String name;
    private EmployeeCategoryDto employeeCategory;
}
