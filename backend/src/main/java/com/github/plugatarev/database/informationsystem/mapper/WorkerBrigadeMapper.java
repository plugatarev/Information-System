package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.WorkerBrigadeDto;
import com.github.plugatarev.database.informationsystem.entity.WorkerBrigade;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WorkerBrigadeMapper {
    WorkerBrigadeDto workerBrigadeToWorkerBrigadeDto(WorkerBrigade workerBrigade);

    WorkerBrigade workerBrigadeDtoToWorkerBrigade(WorkerBrigadeDto workerBrigadeDto);
}