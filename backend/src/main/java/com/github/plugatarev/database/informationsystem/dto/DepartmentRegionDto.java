package com.github.plugatarev.database.informationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRegionDto extends AbstractDto {
    private String regionName;
    private DepartmentDto department;
    private BrigadeDto collectingBrigade;
    private DepartmentRegionChiefDto chief;
}
