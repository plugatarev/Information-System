package com.github.plugatarev.database.informationsystem.dto;

import com.github.plugatarev.database.informationsystem.entity.Employee;
import com.github.plugatarev.database.informationsystem.entity.EmployeeTypeAttribute;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeePropertyDto extends AbstractDto {
    private Employee employee;
    private EmployeeTypeAttribute attribute;
    private String value;
}
