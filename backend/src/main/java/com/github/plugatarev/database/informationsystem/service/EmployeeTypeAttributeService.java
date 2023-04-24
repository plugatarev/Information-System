package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.EmployeeTypeAttributeDto;
import com.github.plugatarev.database.informationsystem.entity.EmployeeTypeAttribute;
import com.github.plugatarev.database.informationsystem.mapper.EmployeeTypeAttributeMapper;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.repository.EmployeeTypeAttributeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeTypeAttributeService extends AbstractService<EmployeeTypeAttribute, EmployeeTypeAttributeDto> {

    private final EmployeeTypeAttributeRepository employeeTypeAttributeRepository;
    private final EmployeeTypeAttributeMapper employeeTypeAttributeMapper;

    @Override
    protected JpaRepository<EmployeeTypeAttribute, Long> getRepository() {
        return employeeTypeAttributeRepository;
    }

    @Override
    protected IMapper<EmployeeTypeAttribute, EmployeeTypeAttributeDto> getMapper() {
        return employeeTypeAttributeMapper;
    }
}
