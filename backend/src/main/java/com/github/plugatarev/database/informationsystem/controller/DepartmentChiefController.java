package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.entity.DepartmentChief;
import com.github.plugatarev.database.informationsystem.entity.Employee;
import com.github.plugatarev.database.informationsystem.service.DepartmentChiefService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/departmentChief")
@AllArgsConstructor
public class DepartmentChiefController {

    private final DepartmentChiefService departmentChiefService;

    @GetMapping("/{id}")
    public DepartmentChief get(@NotNull @PathVariable("id") Long id) {
        return departmentChiefService.getById(id);
    }

    @PostMapping
    public DepartmentChief save(@RequestBody Employee departmentChief) {
        return departmentChiefService.save(departmentChief);
    }

    @PutMapping("/{id}")
    public DepartmentChief update(@NotNull @PathVariable("id") Long id, @RequestBody Employee department) {
        return departmentChiefService.update(id, department);
    }

    @DeleteMapping("/{id}")
    public void delete(@NotNull @PathVariable("id") Long id) {
        departmentChiefService.delete(id);
    }

    @GetMapping
    public List<DepartmentChief> getDepartmentChiefs() {
        return departmentChiefService.getAll();
    }
}