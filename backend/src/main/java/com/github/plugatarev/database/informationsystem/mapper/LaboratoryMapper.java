package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.LaboratoryDto;
import com.github.plugatarev.database.informationsystem.entity.Laboratory;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LaboratoryMapper extends IMapper<Laboratory, LaboratoryDto> {
    @Override
    LaboratoryDto toDto(Laboratory laboratory);

    @Override
    Laboratory toEntity(LaboratoryDto laboratoryDto);
}
