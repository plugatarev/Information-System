package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.EmployeeDto;
import com.github.plugatarev.database.informationsystem.service.EmployeeService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employee")
@AllArgsConstructor
public class EmployeeController extends AbstractController<EmployeeDto> {

    private final EmployeeService employeeService;

    @Override
    protected Service<EmployeeDto> getService() {
        return employeeService;
    }
}
