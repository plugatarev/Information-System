package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.DepartmentRegionChiefDto;
import com.github.plugatarev.database.informationsystem.entity.DepartmentRegionChief;
import com.github.plugatarev.database.informationsystem.mapper.DepartmentRegionChiefMapper;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.repository.DepartmentRegionChiefRepository;
import com.github.plugatarev.database.informationsystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentRegionChiefService extends AbstractService<DepartmentRegionChief, DepartmentRegionChiefDto> {

    private final DepartmentRegionChiefRepository departmentRegionChiefRepository;
    private final DepartmentRegionChiefMapper departmentRegionChiefMapper;

    @Override
    protected JpaRepository<DepartmentRegionChief, Long> getRepository() {
        return departmentRegionChiefRepository;
    }

    @Override
    protected IMapper<DepartmentRegionChief, DepartmentRegionChiefDto> getMapper() {
        return departmentRegionChiefMapper;
    }
}
