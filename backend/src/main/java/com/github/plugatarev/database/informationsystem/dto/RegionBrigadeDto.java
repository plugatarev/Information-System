package com.github.plugatarev.database.informationsystem.dto;

import com.github.plugatarev.database.informationsystem.entity.Brigade;
import com.github.plugatarev.database.informationsystem.entity.DepartmentRegion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionBrigadeDto extends AbstractDto {
    private DepartmentRegion region;
    private Brigade brigade;
}
