package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.EquipmentDto;
import com.github.plugatarev.database.informationsystem.entity.Equipment;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EquipmentMapper extends IMapper<Equipment, EquipmentDto> {
    @Override
    EquipmentDto toDto(Equipment equipment);

    @Override
    Equipment toEntity(EquipmentDto equipmentDto);
}
