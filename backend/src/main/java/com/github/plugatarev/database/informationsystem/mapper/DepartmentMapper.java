package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.DepartmentDto;
import com.github.plugatarev.database.informationsystem.entity.Department;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper extends IMapper<Department, DepartmentDto> {
    @Override
    DepartmentDto toDto(Department department);

    @Override
    Department toEntity(DepartmentDto departmentDto);
}
