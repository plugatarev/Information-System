package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.BrigadierDto;
import com.github.plugatarev.database.informationsystem.entity.Brigadier;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BrigadierMapper extends IMapper<Brigadier, BrigadierDto> {
    @Override
    BrigadierDto toDto(Brigadier brigadier);

    @Override
    Brigadier toEntity(BrigadierDto brigadierDto);
}
