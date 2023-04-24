package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.EquipmentDto;
import com.github.plugatarev.database.informationsystem.service.EquipmentService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/equipment")
@AllArgsConstructor
public class EquipmentController extends AbstractController<EquipmentDto> {

    private final EquipmentService equipmentService;

    @Override
    protected Service<EquipmentDto> getService() {
        return equipmentService;
    }
}
