package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.EmployeeCategoryDto;
import com.github.plugatarev.database.informationsystem.entity.EmployeeCategory;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeCategoryMapper extends IMapper<EmployeeCategory, EmployeeCategoryDto> {
    @Override
    EmployeeCategoryDto toDto(EmployeeCategory employeeCategory);

    @Override
    EmployeeCategory toEntity(EmployeeCategoryDto employeeCategoryDto);
}
