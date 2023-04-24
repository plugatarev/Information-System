package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.EmployeeCategoryTypeDto;
import com.github.plugatarev.database.informationsystem.entity.EmployeeCategoryType;
import com.github.plugatarev.database.informationsystem.mapper.EmployeeCategoryTypeMapper;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.repository.EmployeeCategoryTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeCategoryTypeService extends AbstractService<EmployeeCategoryType, EmployeeCategoryTypeDto> {

    private final EmployeeCategoryTypeRepository employeeCategoryTypeRepository;
    private final EmployeeCategoryTypeMapper employeeCategoryTypeMapper;

    @Override
    protected JpaRepository<EmployeeCategoryType, Long> getRepository() {
        return employeeCategoryTypeRepository;
    }

    @Override
    protected IMapper<EmployeeCategoryType, EmployeeCategoryTypeDto> getMapper() {
        return employeeCategoryTypeMapper;
    }
}
