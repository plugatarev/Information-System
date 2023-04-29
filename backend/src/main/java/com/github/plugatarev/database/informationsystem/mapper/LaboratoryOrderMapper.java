package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.LaboratoryOrderDto;
import com.github.plugatarev.database.informationsystem.entity.LaboratoryOrder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LaboratoryOrderMapper extends IMapper<LaboratoryOrder, LaboratoryOrderDto> {
    @Override
    LaboratoryOrderDto toDto(LaboratoryOrder laboratoryOrder);

    @Override
    LaboratoryOrder toEntity(LaboratoryOrderDto laboratoryOrderDto);
}
