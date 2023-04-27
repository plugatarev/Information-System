package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.BrigadeDto;
import com.github.plugatarev.database.informationsystem.entity.Brigade;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BrigadeMapper extends IMapper<Brigade, BrigadeDto> {
    @Override
    BrigadeDto toDto(Brigade brigade);

    @Override
    Brigade toEntity(BrigadeDto brigadeDto);
}