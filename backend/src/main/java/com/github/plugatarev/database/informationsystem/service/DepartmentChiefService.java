package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.DepartmentChiefDto;
import com.github.plugatarev.database.informationsystem.entity.DepartmentChief;
import com.github.plugatarev.database.informationsystem.entity.Employee;
import com.github.plugatarev.database.informationsystem.mapper.DepartmentChiefMapper;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.repository.DepartmentChiefRepository;
import com.github.plugatarev.database.informationsystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentChiefService extends AbstractService<DepartmentChief, DepartmentChiefDto> {

    private final DepartmentChiefRepository departmentChiefRepository;
    private final DepartmentChiefMapper departmentChiefMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    protected JpaRepository<DepartmentChief, Long> getRepository() {
        return departmentChiefRepository;
    }

    @Override
    protected IMapper<DepartmentChief, DepartmentChiefDto> getMapper() {
        return departmentChiefMapper;
    }

    @Override
    public DepartmentChiefDto create(DepartmentChiefDto dto) {
        var entity = employeeRepository.findById(dto.getId()).get();
        DepartmentChief departmentChief = employeeToDepartmentChief(entity);
        departmentChief = departmentChiefRepository.save(departmentChief);
        return departmentChiefMapper.toDto(departmentChief);
    }


    private DepartmentChief employeeToDepartmentChief(Employee employee) {
        DepartmentChief departmentChief = new DepartmentChief();
        departmentChief.setId(employee.getId());
        departmentChief.setFirstName(employee.getFirstName());
        departmentChief.setSecondName(employee.getSecondName());
        departmentChief.setPassport(employee.getPassport());
        departmentChief.setEmploymentDate(employee.getEmploymentDate());
        departmentChief.setDismissalDate(employee.getDismissalDate());
        departmentChief.setEmployeeCategoryType(employee.getEmployeeCategoryType());
        return departmentChief;
    }
}

