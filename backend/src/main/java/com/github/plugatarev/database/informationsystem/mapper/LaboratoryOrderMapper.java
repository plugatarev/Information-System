package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.LaboratoryOrderDto;
import com.github.plugatarev.database.informationsystem.entity.LaboratoryOrder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LaboratoryOrderMapper {
    LaboratoryOrderDto laboratoryOrderToLaboratoryOrderDto(LaboratoryOrder laboratoryOrder);

    LaboratoryOrder laboratoryOrderDtoToLaboratoryOrder(LaboratoryOrderDto laboratoryOrderDto);
}
