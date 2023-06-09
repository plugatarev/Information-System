package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.DepartmentChiefDto;
import com.github.plugatarev.database.informationsystem.entity.DepartmentChief;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentChiefMapper extends IMapper<DepartmentChief, DepartmentChiefDto> {
    @Override
    DepartmentChiefDto toDto(DepartmentChief departmentChief);

    @Override
    DepartmentChief toEntity(DepartmentChiefDto departmentChiefDto);
}
