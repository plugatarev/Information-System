package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.DepartmentRegionChiefDto;
import com.github.plugatarev.database.informationsystem.entity.DepartmentRegionChief;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentRegionChiefMapper {
    DepartmentRegionChiefDto departmentRegionChiefToDepartmentRegionChiefDto(DepartmentRegionChief departmentRegion);

    DepartmentRegionChief departmentRegionChiefDtoToDepartmentChiefRegion(DepartmentRegionChiefDto departmentRegionDto);
}