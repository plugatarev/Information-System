package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.TestDto;
import com.github.plugatarev.database.informationsystem.entity.Test;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.TestMapper;
import com.github.plugatarev.database.informationsystem.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TestService extends AbstractService<Test, TestDto> {

    private final TestRepository testRepository;
    private final TestMapper testMapper;

    @Override
    protected JpaRepository<Test, Long> getRepository() {
        return testRepository;
    }

    @Override
    protected IMapper<Test, TestDto> getMapper() {
        return testMapper;
    }
}
