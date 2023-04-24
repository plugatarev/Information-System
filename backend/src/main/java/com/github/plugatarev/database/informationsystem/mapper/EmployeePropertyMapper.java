package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.EmployeePropertyDto;
import com.github.plugatarev.database.informationsystem.entity.EmployeeProperty;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeePropertyMapper {
    EmployeePropertyDto employeePropertyToEmployeePropertyDto(EmployeeProperty employeeProperty);

    EmployeeProperty employeePropertyDtoToEmployeeProperty(EmployeePropertyDto employeePropertyDto);
}
