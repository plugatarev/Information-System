package com.github.plugatarev.database.informationsystem.dto;

import com.github.plugatarev.database.informationsystem.entity.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MasterDto extends EmployeeDto {
    private Employee chief;
}
