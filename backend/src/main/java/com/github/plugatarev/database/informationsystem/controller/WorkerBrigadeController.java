package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.WorkerBrigadeDto;
import com.github.plugatarev.database.informationsystem.service.Service;
import com.github.plugatarev.database.informationsystem.service.WorkerBrigadeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/workerBrigade")
@AllArgsConstructor
public class WorkerBrigadeController extends AbstractController<WorkerBrigadeDto> {

    private final WorkerBrigadeService workerBrigadeService;

    @Override
    protected Service<WorkerBrigadeDto> getService() {
        return workerBrigadeService;
    }
}
