package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.entity.DepartmentRegion;
import com.github.plugatarev.database.informationsystem.service.DepartmentRegionService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/departmentRegion")
@AllArgsConstructor
public class DepartmentRegionController {

    private final DepartmentRegionService departmentRegionService;

    @GetMapping("/{id}")
    public DepartmentRegion get(@NotNull @PathVariable("id") Long id) {
        return departmentRegionService.getById(id);
    }

    @PostMapping
    public DepartmentRegion save(@RequestBody DepartmentRegion departmentRegion) {
        return departmentRegionService.save(departmentRegion);
    }

    @PutMapping("/{id}")
    public DepartmentRegion update(@NotNull @PathVariable("id") Long id, @RequestBody DepartmentRegion departmentRegion) {
        return departmentRegionService.update(id, departmentRegion);
    }

    @DeleteMapping("/{id}")
    public void delete(@NotNull @PathVariable("id") Long id) {
        departmentRegionService.delete(id);
    }

    @GetMapping
    public List<DepartmentRegion> getDepartments() {
        return departmentRegionService.getAll();
    }
}
