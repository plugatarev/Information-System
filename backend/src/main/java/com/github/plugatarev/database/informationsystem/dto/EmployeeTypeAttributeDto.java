package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeTypeAttributeDto extends AbstractDto {
    private String attributeName;
    private EmployeeCategoryTypeDto employeeCategoryType;
}
