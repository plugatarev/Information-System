package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.BrigadeDto;
import com.github.plugatarev.database.informationsystem.entity.Brigade;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BrigadeMapper {
    BrigadeDto brigadeToBrigadeDto(Brigade brigade);

    Brigade brigadeDtoToBrigade(BrigadeDto brigadeDto);
}