package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.EmployeeCategoryTypeDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeCategoryType {
    EmployeeCategoryTypeDto employeeCategoryTypeToEmployeeCategoryTypeDto(EmployeeCategoryType employeeCategoryType);

    EmployeeCategoryType employeeCategoryTypeDtoToEmployeeCategoryType(EmployeeCategoryTypeDto employeeCategoryTypeDto);
}
