package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.entity.Employee;
import com.github.plugatarev.database.informationsystem.service.EmployeeService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee get(@NotNull @PathVariable("id") Long id) {
        return employeeService.getById(id);
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@NotNull @PathVariable("id") Long id, @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@NotNull @PathVariable("id") Long id) {
        employeeService.delete(id);
    }

    @GetMapping
    public List<Employee> getDepartmentChiefs() {
        return employeeService.getAll();
    }
}
