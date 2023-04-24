package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.EmployeePropertyDto;
import com.github.plugatarev.database.informationsystem.service.EmployeePropertyService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employeeProperty")
@AllArgsConstructor
public class EmployeePropertyController extends AbstractController<EmployeePropertyDto> {
    private final EmployeePropertyService employeePropertyService;

    @Override
    protected Service<EmployeePropertyDto> getService() {
        return employeePropertyService;
    }
}
