package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.MasterDto;
import com.github.plugatarev.database.informationsystem.entity.Master;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MasterMapper extends IMapper<Master, MasterDto> {
    @Override
    MasterDto toDto(Master master);

    @Override
    Master toEntity(MasterDto masterDto);
}
