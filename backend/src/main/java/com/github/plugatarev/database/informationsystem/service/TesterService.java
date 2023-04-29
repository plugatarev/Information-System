package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.TesterDto;
import com.github.plugatarev.database.informationsystem.entity.Employee;
import com.github.plugatarev.database.informationsystem.entity.Tester;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.TesterMapper;
import com.github.plugatarev.database.informationsystem.repository.EmployeeRepository;
import com.github.plugatarev.database.informationsystem.repository.TesterRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TesterService extends AbstractService<Tester, TesterDto> {

    private final TesterRepository testerRepository;
    private final TesterMapper testerMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    protected JpaRepository<Tester, Long> getRepository() {
        return testerRepository;
    }

    @Override
    protected IMapper<Tester, TesterDto> getMapper() {
        return testerMapper;
    }

    @Override
    public TesterDto create(TesterDto dto) {
        var entity = employeeRepository.findById(dto.getId()).get();
        Tester testerDto = employeeToTester(entity);
        testerDto = testerRepository.save(testerDto);
        return testerMapper.toDto(testerDto);
    }


    private Tester employeeToTester(Employee employee) {
        Tester tester = new Tester();
        tester.setId(employee.getId());
        tester.setFirstName(employee.getFirstName());
        tester.setSecondName(employee.getSecondName());
        tester.setPassport(employee.getPassport());
        tester.setEmploymentDate(employee.getEmploymentDate());
        tester.setDismissalDate(employee.getDismissalDate());
        tester.setEmployeeCategoryType(employee.getEmployeeCategoryType());
        return tester;
    }
}
