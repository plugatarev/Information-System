package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.entity.Equipment;
import com.github.plugatarev.database.informationsystem.exception.NotFoundEntityException;
import com.github.plugatarev.database.informationsystem.exception.NotUniqueEntityException;
import com.github.plugatarev.database.informationsystem.repository.EquipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public Equipment save(Equipment equipment) {
        String equipmentSerialNumber = equipment.getSerialNumber();
        if (equipmentRepository.existBySerialNumber(equipmentSerialNumber)) {
            throw new NotUniqueEntityException("Equipment entity with serial number " + equipmentSerialNumber + " already exists!");
        }
        return equipmentRepository.save(equipment);
    }

    public void delete(Long id) {
        equipmentRepository.deleteById(id);
    }

    public Equipment update(Long id, Equipment equipment) {
        Equipment updateEquipment = equipmentRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("Equipment entity with id " + id + " not found")
        );
        updateEquipment.setSerialNumber(equipment.getSerialNumber());
        return equipmentRepository.save(updateEquipment);
    }

    public Equipment getById(Long id) {
        return equipmentRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("Equipment entity with id " + id + " not found")
        );

    }

    public List<Equipment> getAll() {
        return equipmentRepository.findAll();
    }
}
