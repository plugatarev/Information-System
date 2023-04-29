package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDto extends AbstractDto {
    private String departmentName;
    private DepartmentChiefDto departmentChief;
}
