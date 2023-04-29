package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.DepartmentRegionDto;
import com.github.plugatarev.database.informationsystem.entity.DepartmentRegion;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentRegionMapper extends IMapper<DepartmentRegion, DepartmentRegionDto> {
    @Override
    DepartmentRegionDto toDto(DepartmentRegion departmentRegion);

    @Override
    DepartmentRegion toEntity(DepartmentRegionDto departmentRegionDto);
}
