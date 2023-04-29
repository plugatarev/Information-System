package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.WorkerBrigadeDto;
import com.github.plugatarev.database.informationsystem.entity.WorkerBrigade;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WorkerBrigadeMapper extends IMapper<WorkerBrigade, WorkerBrigadeDto> {
    @Override
    WorkerBrigadeDto toDto(WorkerBrigade workerBrigade);

    @Override
    WorkerBrigade toEntity(WorkerBrigadeDto workerBrigadeDto);
}