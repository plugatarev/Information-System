package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.DepartmentChiefDto;
import com.github.plugatarev.database.informationsystem.entity.DepartmentChief;
import com.github.plugatarev.database.informationsystem.mapper.DepartmentChiefMapper;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.repository.DepartmentChiefRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentChiefService extends AbstractService<DepartmentChief, DepartmentChiefDto> {

    private final DepartmentChiefRepository departmentChiefRepository;
    private final DepartmentChiefMapper departmentChiefMapper;

    @Override
    protected JpaRepository<DepartmentChief, Long> getRepository() {
        return departmentChiefRepository;
    }

    @Override
    protected IMapper<DepartmentChief, DepartmentChiefDto> getMapper() {
        return departmentChiefMapper;
    }
}

