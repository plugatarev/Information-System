package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.EquipmentDto;
import com.github.plugatarev.database.informationsystem.filter.EquipmentFilter;
import com.github.plugatarev.database.informationsystem.service.EquipmentService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/search")
    public ResponseEntity<Page<EquipmentDto>> search(@RequestBody EquipmentFilter filter, Pageable pageable) {
        return ResponseEntity.ok(equipmentService.searchByFilter(filter, pageable));
    }
}
