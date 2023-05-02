package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MasterDto extends EmployeeDto {
    private DepartmentRegionChiefDto departmentRegionChief;
}
