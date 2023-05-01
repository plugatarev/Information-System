package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.EmployeeDto;
import com.github.plugatarev.database.informationsystem.entity.Employee;
import com.github.plugatarev.database.informationsystem.mapper.EmployeeMapper;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService extends AbstractService<Employee, EmployeeDto> {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    @Override
    protected JpaRepository<Employee, Long> getRepository() {
        return employeeRepository;
    }

    @Override
    protected IMapper<Employee, EmployeeDto> getMapper() {
        return employeeMapper;
    }

    public Page<EmployeeDto> getDepartmentEmployees(Long departmentId, Pageable pageable) {
        return employeeRepository.findEmployeesByDepartment(departmentId, pageable).map(employeeMapper::toDto);
    }

    public Page<EmployeeDto> getDepartmentRegionEmployees(Long departmentRegionId, Pageable pageable) {
        return employeeRepository.findEmployeesByDepartmentRegion(departmentRegionId, pageable).map(employeeMapper::toDto);
    }
}
