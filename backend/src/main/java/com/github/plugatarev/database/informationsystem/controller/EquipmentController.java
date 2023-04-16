package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.entity.Equipment;
import com.github.plugatarev.database.informationsystem.service.EquipmentService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/equipment")
@AllArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping
    public Equipment save(@RequestBody Equipment equipment) {
        return equipmentService.save(equipment);
    }

    @PutMapping("/{id}")
    public Equipment update(@NotNull @PathVariable("id") Long id, @RequestBody Equipment equipment) {
        return equipmentService.update(id, equipment);
    }

    @DeleteMapping("/{id}")
    public void delete(@NotNull @PathVariable("id") Long id) {
        equipmentService.delete(id);
    }

    @GetMapping
    public List<Equipment> getEquipment() {
        return equipmentService.getAll();
    }
}
