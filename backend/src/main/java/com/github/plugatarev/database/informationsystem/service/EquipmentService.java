package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.EquipmentDto;
import com.github.plugatarev.database.informationsystem.entity.Equipment;
import com.github.plugatarev.database.informationsystem.mapper.EquipmentMapper;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.repository.EquipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EquipmentService extends AbstractService<Equipment, EquipmentDto> {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;

    @Override
    protected JpaRepository<Equipment, Long> getRepository() {
        return equipmentRepository;
    }

    @Override
    protected IMapper<Equipment, EquipmentDto> getMapper() {
        return equipmentMapper;
    }
}
