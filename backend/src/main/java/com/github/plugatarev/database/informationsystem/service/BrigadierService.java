package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.BrigadierDto;
import com.github.plugatarev.database.informationsystem.entity.Brigadier;
import com.github.plugatarev.database.informationsystem.entity.Employee;
import com.github.plugatarev.database.informationsystem.mapper.BrigadierMapper;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.repository.BrigadierRepository;
import com.github.plugatarev.database.informationsystem.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrigadierService extends AbstractService<Brigadier, BrigadierDto> {

    private final BrigadierRepository brigadierRepository;
    private final BrigadierMapper brigadierMapper;

    private final EmployeeRepository employeeRepository;
    @Override
    protected JpaRepository<Brigadier, Long> getRepository() {
        return brigadierRepository;
    }

    @Override
    protected IMapper<Brigadier, BrigadierDto> getMapper() {
        return brigadierMapper;
    }

    @Override
    public BrigadierDto create(BrigadierDto dto) {
        var entity = employeeRepository.findById(dto.getId()).get();
        Brigadier brigadier = employeeToBrigadier(entity);
        brigadier = brigadierRepository.save(brigadier);
        return getMapper().toDto(brigadier);
    }


    private Brigadier employeeToBrigadier(Employee employee) {
        Brigadier brigadier = new Brigadier();
        brigadier.setId(employee.getId());
        brigadier.setFirstName(employee.getFirstName());
        brigadier.setSecondName(employee.getSecondName());
        brigadier.setPassport(employee.getPassport());
        brigadier.setEmploymentDate(employee.getEmploymentDate());
        brigadier.setDismissalDate(employee.getDismissalDate());
        brigadier.setEmployeeCategoryType(employee.getEmployeeCategoryType());
        return brigadier;
    }
}
