package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.entity.Department;
import com.github.plugatarev.database.informationsystem.service.DepartmentService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/department")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/{id}")
    public Department get(@NotNull @PathVariable("id") Long id) {
        return departmentService.getById(id);
    }

    @PostMapping
    public Department save(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @PutMapping("/{id}")
    public Department update(@NotNull @PathVariable("id") Long id, @RequestBody Department department) {
        return departmentService.update(id, department);
    }

    @DeleteMapping("/{id}")
    public void delete(@NotNull @PathVariable("id") Long id) {
        departmentService.delete(id);
    }

    @GetMapping
    public List<Department> getDepartments() {
        return departmentService.getAll();
    }
}
