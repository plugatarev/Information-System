package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentRegionDto extends AbstractDto {
    private String regionName;
    private DepartmentDto department;
    private DepartmentRegionChiefDto departmentRegionChief;
}
