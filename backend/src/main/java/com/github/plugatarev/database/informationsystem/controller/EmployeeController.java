package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.EmployeeDto;
import com.github.plugatarev.database.informationsystem.filter.EmployeeFilter;
import com.github.plugatarev.database.informationsystem.service.EmployeeService;
import com.github.plugatarev.database.informationsystem.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/departmentRegion/{departmentRegionId}/brigadeWorkers")
    public Page<EmployeeDto> getDepartmentRegionBrigadeWorkers(@PathVariable("departmentRegionId") Long departmentRegionId, Pageable pageable) {
        return employeeService.getDepartmentRegionBrigadeWorkers(departmentRegionId, pageable);
    }

    @GetMapping("/department/{departmentId}/brigadeWorkers")
    public Page<EmployeeDto> getDepartmentBrigadeWorkers(@PathVariable("departmentId") Long departmentId, Pageable pageable) {
        return employeeService.getDepartmentBrigadeWorkers(departmentId, pageable);
    }

    @PostMapping("/search")
    public ResponseEntity<Page<EmployeeDto>> search(@RequestBody EmployeeFilter filter, Pageable pageable) {
        return ResponseEntity.ok(employeeService.searchByFilter(filter, pageable));
    }
}
