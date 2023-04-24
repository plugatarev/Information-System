package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.EmployeeTypeAttributeDto;
import com.github.plugatarev.database.informationsystem.service.EmployeeTypeAttributeService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employeeTypeAttribute")
@AllArgsConstructor
public class EmployeeTypeAttributeController extends AbstractController<EmployeeTypeAttributeDto> {
    private final EmployeeTypeAttributeService employeePropertyService;

    @Override
    protected Service<EmployeeTypeAttributeDto> getService() {
        return employeePropertyService;
    }
}