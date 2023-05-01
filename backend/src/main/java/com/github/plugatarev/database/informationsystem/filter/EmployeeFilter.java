package com.github.plugatarev.database.informationsystem.filter;

import com.github.plugatarev.database.informationsystem.filter.type.EmployeeTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeFilter {
    private EmployeeTypeEnum employeeCategory;
}
