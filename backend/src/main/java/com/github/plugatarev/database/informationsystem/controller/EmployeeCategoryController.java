package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.EmployeeCategoryDto;
import com.github.plugatarev.database.informationsystem.service.EmployeeCategoryService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employeeCategory")
@AllArgsConstructor
public class EmployeeCategoryController extends AbstractController<EmployeeCategoryDto> {

    private final EmployeeCategoryService employeeCategoryService;

    @Override
    protected Service<EmployeeCategoryDto> getService() {
        return employeeCategoryService;
    }
}
