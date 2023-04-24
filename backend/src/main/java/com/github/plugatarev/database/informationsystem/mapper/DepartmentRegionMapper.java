package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.DepartmentRegionDto;
import com.github.plugatarev.database.informationsystem.entity.DepartmentRegion;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentRegionMapper {
    DepartmentRegionDto departmentRegionToDepartmentRegionDto(DepartmentRegion departmentRegion);

    DepartmentRegion departmentRegionDtoToDepartmentRegion(DepartmentRegionDto departmentRegionDto);
}
