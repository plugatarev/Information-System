package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeePropertyDto extends AbstractDto {
    private EmployeeDto employee;
    private EmployeeTypeAttributeDto attribute;
    private String value;
}
