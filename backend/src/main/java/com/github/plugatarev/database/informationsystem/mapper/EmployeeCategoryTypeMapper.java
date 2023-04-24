package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.EmployeeCategoryTypeDto;
import com.github.plugatarev.database.informationsystem.entity.EmployeeCategoryType;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeCategoryTypeMapper extends IMapper<EmployeeCategoryType, EmployeeCategoryTypeDto> {
    @Override
    EmployeeCategoryTypeDto toDto(EmployeeCategoryType employeeCategoryType);

    @Override
    EmployeeCategoryType toEntity(EmployeeCategoryTypeDto employeeCategoryTypeDto);
}
