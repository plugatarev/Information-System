package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.TesterDto;
import com.github.plugatarev.database.informationsystem.entity.Tester;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.TesterMapper;
import com.github.plugatarev.database.informationsystem.repository.TesterRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TesterService extends AbstractService<Tester, TesterDto> {

    private final TesterRepository testerRepository;
    private final TesterMapper testerMapper;

    @Override
    protected JpaRepository<Tester, Long> getRepository() {
        return testerRepository;
    }

    @Override
    protected IMapper<Tester, TesterDto> getMapper() {
        return testerMapper;
    }
}
