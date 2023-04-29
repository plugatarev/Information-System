package com.github.plugatarev.database.informationsystem.dto;

import lombok.*;

@Getter
@Setter
public class BrigadeDto extends AbstractDto {
    private String brigadeName;
    private BrigadierDto brigadier;
    private DepartmentRegionDto departmentRegion;
}
