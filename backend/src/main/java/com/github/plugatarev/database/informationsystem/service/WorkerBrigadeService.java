package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.EmployeeDto;
import com.github.plugatarev.database.informationsystem.dto.WorkerBrigadeDto;
import com.github.plugatarev.database.informationsystem.entity.WorkerBrigade;
import com.github.plugatarev.database.informationsystem.exception.EntityNotUniqueException;
import com.github.plugatarev.database.informationsystem.mapper.EmployeeMapper;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.WorkerBrigadeMapper;
import com.github.plugatarev.database.informationsystem.repository.WorkerBrigadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WorkerBrigadeService extends AbstractService<WorkerBrigade, WorkerBrigadeDto> {

    private final WorkerBrigadeRepository workerBrigadeRepository;
    private final WorkerBrigadeMapper workerBrigadeMapper;
    private final EmployeeMapper employeeMapper;

    @Override
    protected JpaRepository<WorkerBrigade, Long> getRepository() {
        return workerBrigadeRepository;
    }

    @Override
    protected IMapper<WorkerBrigade, WorkerBrigadeDto> getMapper() {
        return workerBrigadeMapper;
    }

    @Override
    public WorkerBrigadeDto create(WorkerBrigadeDto dto) {
        var entity = getMapper().toEntity(dto);
        if (workerBrigadeRepository.existsByBrigadeAndWorker(entity.getBrigade(), entity.getWorker())) {
            throw new EntityNotUniqueException("This worker already work it this brigade!");
        }
        entity = getRepository().save(entity);
        return getMapper().toDto(entity);
    }

    public Page<EmployeeDto> getBrigadeWorkers(Long brigadeId, Pageable pageable) {
        Page<WorkerBrigade> employees = workerBrigadeRepository.findAllByBrigadeId(brigadeId, pageable);
        return employees.map(s -> workerBrigadeMapper.toDto(s).getWorker());
    }

    public Page<EmployeeDto> getBrigadeWorkersByProduct(Long productId, Pageable pageable) {
        return workerBrigadeRepository.findBrigadeEmployeesByProductId(productId, pageable).map(employeeMapper::toDto);
    }
}
