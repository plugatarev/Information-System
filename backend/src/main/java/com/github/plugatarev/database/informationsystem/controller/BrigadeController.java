package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.entity.Brigade;
import com.github.plugatarev.database.informationsystem.service.BrigadeService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/brigade")
@AllArgsConstructor
public class BrigadeController {

    private final BrigadeService brigadeService;

    @GetMapping("/{id}")
    public Brigade get(@NotNull @PathVariable("id") Long id) {
        return brigadeService.getById(id);
    }

    @PostMapping
    public Brigade save(@RequestBody Brigade brigade) {
        return brigadeService.save(brigade);
    }

    @PutMapping("/{id}")
    public Brigade update(@NotNull @PathVariable("id") Long id, @RequestBody Brigade brigade) {
        return brigadeService.update(id, brigade);
    }

    @DeleteMapping("/{id}")
    public void delete(@NotNull @PathVariable("id") Long id) {
        brigadeService.delete(id);
    }

    @GetMapping
    public List<Brigade> getDepartmentChiefs() {
        return brigadeService.getAll();
    }
}
