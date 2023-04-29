package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.DepartmentRegionChiefDto;
import com.github.plugatarev.database.informationsystem.entity.DepartmentRegionChief;
import com.github.plugatarev.database.informationsystem.entity.Employee;
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
    private final EmployeeRepository employeeRepository;

    @Override
    protected JpaRepository<DepartmentRegionChief, Long> getRepository() {
        return departmentRegionChiefRepository;
    }

    @Override
    protected IMapper<DepartmentRegionChief, DepartmentRegionChiefDto> getMapper() {
        return departmentRegionChiefMapper;
    }

    @Override
    public DepartmentRegionChiefDto create(DepartmentRegionChiefDto dto) {
        var entity = employeeRepository.findById(dto.getId()).get();
        DepartmentRegionChief departmentRegionChief = employeeToDepartmentRegionChief(entity);
        departmentRegionChief = departmentRegionChiefRepository.save(departmentRegionChief);
        return departmentRegionChiefMapper.toDto(departmentRegionChief);
    }


    private DepartmentRegionChief employeeToDepartmentRegionChief(Employee employee) {
        DepartmentRegionChief departmentRegionChief = new DepartmentRegionChief();
        departmentRegionChief.setId(employee.getId());
        departmentRegionChief.setFirstName(employee.getFirstName());
        departmentRegionChief.setSecondName(employee.getSecondName());
        departmentRegionChief.setPassport(employee.getPassport());
        departmentRegionChief.setEmploymentDate(employee.getEmploymentDate());
        departmentRegionChief.setDismissalDate(employee.getDismissalDate());
        departmentRegionChief.setEmployeeCategoryType(employee.getEmployeeCategoryType());
        return departmentRegionChief;
    }
}
