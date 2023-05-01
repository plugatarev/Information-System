package com.github.plugatarev.database.informationsystem.controller;

import com.github.plugatarev.database.informationsystem.dto.EmployeeDto;
import com.github.plugatarev.database.informationsystem.dto.WorkerBrigadeDto;
import com.github.plugatarev.database.informationsystem.service.Service;
import com.github.plugatarev.database.informationsystem.service.WorkerBrigadeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{brigadeId}/employees")
    public ResponseEntity<Page<EmployeeDto>> getBrigadeWorkers(@PathVariable("brigadeId") Long brigadeId, Pageable pageable) {
        return ResponseEntity.ok(workerBrigadeService.getBrigadeWorkers(brigadeId, pageable));
    }
}
