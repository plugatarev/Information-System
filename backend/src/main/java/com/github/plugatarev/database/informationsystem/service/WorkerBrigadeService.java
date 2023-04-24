package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.WorkerBrigadeDto;
import com.github.plugatarev.database.informationsystem.entity.WorkerBrigade;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.WorkerBrigadeMapper;
import com.github.plugatarev.database.informationsystem.repository.WorkerBrigadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WorkerBrigadeService extends AbstractService<WorkerBrigade, WorkerBrigadeDto> {

    private final WorkerBrigadeRepository workerBrigadeRepository;
    private final WorkerBrigadeMapper workerBrigadeMapper;

    @Override
    protected JpaRepository<WorkerBrigade, Long> getRepository() {
        return workerBrigadeRepository;
    }

    @Override
    protected IMapper<WorkerBrigade, WorkerBrigadeDto> getMapper() {
        return workerBrigadeMapper;
    }
}
