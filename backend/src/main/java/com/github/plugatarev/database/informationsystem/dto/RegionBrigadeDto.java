package com.github.plugatarev.database.informationsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionBrigadeDto extends AbstractDto {
    private DepartmentRegionDto region;
    private BrigadeDto brigade;
}
