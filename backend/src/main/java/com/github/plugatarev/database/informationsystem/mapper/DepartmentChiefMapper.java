package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.DepartmentChiefDto;
import com.github.plugatarev.database.informationsystem.entity.DepartmentChief;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentChiefMapper {
    DepartmentChiefDto departmentChiefToDepartmentChiefDto(DepartmentChief departmentChief);

    DepartmentChief departmentChiefDtoToDepartmentChief(DepartmentChiefDto departmentChiefDto);
}
