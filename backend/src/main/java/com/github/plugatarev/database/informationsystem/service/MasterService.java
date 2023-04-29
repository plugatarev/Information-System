package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.MasterDto;
import com.github.plugatarev.database.informationsystem.entity.Employee;
import com.github.plugatarev.database.informationsystem.entity.Master;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.MasterMapper;
import com.github.plugatarev.database.informationsystem.repository.EmployeeRepository;
import com.github.plugatarev.database.informationsystem.repository.MasterRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MasterService extends AbstractService<Master, MasterDto> {

    private final MasterRepository masterRepository;
    private final MasterMapper masterMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    protected JpaRepository<Master, Long> getRepository() {
        return masterRepository;
    }

    @Override
    protected IMapper<Master, MasterDto> getMapper() {
        return masterMapper;
    }

    @Override
    public MasterDto create(MasterDto dto) {
        var entity = employeeRepository.findById(dto.getId()).get();
        Master master = employeeToMaster(entity);
        master = masterRepository.save(master);
        return masterMapper.toDto(master);
    }


    private Master employeeToMaster(Employee employee) {
        Master master = new Master();
        master.setId(employee.getId());
        master.setFirstName(employee.getFirstName());
        master.setSecondName(employee.getSecondName());
        master.setPassport(employee.getPassport());
        master.setEmploymentDate(employee.getEmploymentDate());
        master.setDismissalDate(employee.getDismissalDate());
        master.setEmployeeCategoryType(employee.getEmployeeCategoryType());
        return master;
    }
}
