package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.entity.DepartmentRegionChief;
import com.github.plugatarev.database.informationsystem.entity.Employee;
import com.github.plugatarev.database.informationsystem.service.DepartmentRegionChiefService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/departmentRegionChief")
@AllArgsConstructor
public class DepartmentRegionChiefController {

    private final DepartmentRegionChiefService departmentRegionChiefService;

    @GetMapping("/{id}")
    public DepartmentRegionChief get(@NotNull @PathVariable("id") Long id) {
        return departmentRegionChiefService.getById(id);
    }

    @PostMapping
    public DepartmentRegionChief save(@RequestBody Employee departmentRegionChief) {
        return departmentRegionChiefService.save(departmentRegionChief);
    }

    @PutMapping("/{id}")
    public DepartmentRegionChief update(@NotNull @PathVariable("id") Long id, @RequestBody Employee departmentRegionChief) {
        return departmentRegionChiefService.update(id, departmentRegionChief);
    }

    @DeleteMapping("/{id}")
    public void delete(@NotNull @PathVariable("id") Long id) {
        departmentRegionChiefService.delete(id);
    }

    @GetMapping
    public List<DepartmentRegionChief> getDepartments() {
        return departmentRegionChiefService.getAll();
    }
}
