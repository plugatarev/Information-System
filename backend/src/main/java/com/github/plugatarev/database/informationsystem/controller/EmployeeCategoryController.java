package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.entity.EmployeeCategory;
import com.github.plugatarev.database.informationsystem.service.EmployeeCategoryService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/employeeCategory")
@AllArgsConstructor
public class EmployeeCategoryController {

    private final EmployeeCategoryService employeeCategoryService;

    @GetMapping("/{id}")
    public EmployeeCategory get(@NotNull @PathVariable Long id) {
        return employeeCategoryService.getById(id);
    }

    @GetMapping
    public List<EmployeeCategory> getCategories() {
        return employeeCategoryService.getAll();
    }
}
