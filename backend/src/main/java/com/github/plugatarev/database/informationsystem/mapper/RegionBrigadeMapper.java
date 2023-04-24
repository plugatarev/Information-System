package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.RegionBrigadeDto;
import com.github.plugatarev.database.informationsystem.entity.RegionBrigade;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RegionBrigadeMapper {
    RegionBrigadeDto regionBrigadeToRegionBrigadeDto(RegionBrigade regionBrigade);

    RegionBrigade regionBrigadeDtoToRegionBrigade(RegionBrigadeDto regionBrigadeDto);
}