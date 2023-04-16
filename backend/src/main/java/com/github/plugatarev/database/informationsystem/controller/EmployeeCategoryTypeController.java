package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.entity.EmployeeCategoryType;
import com.github.plugatarev.database.informationsystem.service.EmployeeCategoryTypeService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/employeeCategoryType")
@AllArgsConstructor
public class EmployeeCategoryTypeController {

    private final EmployeeCategoryTypeService employeeCategoryTypeService;

    @GetMapping("/{id}")
    public EmployeeCategoryType get(@NotNull @PathVariable Long id) {
        return employeeCategoryTypeService.getById(id);
    }

    @GetMapping
    public List<EmployeeCategoryType> getCategoryTypes() {
        return employeeCategoryTypeService.getAll();
    }
}