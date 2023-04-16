package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.entity.Laboratory;
import com.github.plugatarev.database.informationsystem.service.LaboratoryService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/laboratory")
@AllArgsConstructor
public class LaboratoryController {
    private final LaboratoryService laboratoryService;

    @GetMapping
    public Laboratory save(@RequestBody Laboratory laboratory) {
        return laboratoryService.save(laboratory);
    }

    @PutMapping("/{id}")
    public Laboratory update(@NotNull @PathVariable("id") Long id, @RequestBody Laboratory laboratory) {
        return laboratoryService.update(id, laboratory);
    }

    @DeleteMapping("/{id}")
    public void delete(@NotNull @PathVariable("id") Long id) {
        laboratoryService.delete(id);
    }

    @GetMapping
    public List<Laboratory> getEquipment() {
        return laboratoryService.getAll();
    }
}
