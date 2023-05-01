package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.EmployeeDto;
import com.github.plugatarev.database.informationsystem.service.EmployeeService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/departmentRegion/{departmentRegionId}/employees")
    public Page<EmployeeDto> getDepartmentRegionEmployees(@PathVariable("departmentRegionId") Long departmentRegionId, Pageable pageable) {
        return employeeService.getDepartmentRegionEmployees(departmentRegionId, pageable);
    }

    @GetMapping("/department/{departmentId}/employees")
    public Page<EmployeeDto> getDepartmentEmployees(@PathVariable("departmentId") Long departmentId, Pageable pageable) {
        return employeeService.getDepartmentEmployees(departmentId, pageable);
    }
}
