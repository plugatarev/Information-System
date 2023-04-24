package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.EmployeeCategoryTypeDto;
import com.github.plugatarev.database.informationsystem.service.EmployeeCategoryTypeService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employeeCategoryType")
@AllArgsConstructor
public class EmployeeCategoryTypeController extends AbstractController<EmployeeCategoryTypeDto> {

    private final EmployeeCategoryTypeService employeeCategoryTypeService;

    @Override
    protected Service<EmployeeCategoryTypeDto> getService() {
        return employeeCategoryTypeService;
    }
}