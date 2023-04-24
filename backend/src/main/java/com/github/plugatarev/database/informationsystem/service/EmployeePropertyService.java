package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.EmployeePropertyDto;
import com.github.plugatarev.database.informationsystem.entity.EmployeeProperty;
import com.github.plugatarev.database.informationsystem.mapper.EmployeePropertyMapper;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.repository.EmployeePropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeePropertyService extends AbstractService<EmployeeProperty, EmployeePropertyDto> {

    private final EmployeePropertyRepository employeePropertyRepository;
    private final EmployeePropertyMapper employeePropertyMapper;

    @Override
    protected JpaRepository<EmployeeProperty, Long> getRepository() {
        return employeePropertyRepository;
    }

    @Override
    protected IMapper<EmployeeProperty, EmployeePropertyDto> getMapper() {
        return employeePropertyMapper;
    }
}
