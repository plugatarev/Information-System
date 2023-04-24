package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.EmployeeCategoryDto;
import com.github.plugatarev.database.informationsystem.entity.EmployeeCategory;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeCategoryMapper {
    EmployeeCategoryDto employeeCategoryToEmployeeCategoryDto(EmployeeCategory employeeCategory);

    EmployeeCategory employeeCategoryDtoToEmployeeCategory(EmployeeCategoryDto employeeCategoryDto);
}
