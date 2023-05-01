package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.repository.DepartmentRegionChiefRepository;
import com.github.plugatarev.database.informationsystem.repository.DepartmentRegionRepository;
import com.github.plugatarev.database.informationsystem.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Test {

    private final DepartmentRegionRepository departmentRegionRepository;
    private final DepartmentRepository departmentRepository;
    private final DepartmentRegionChiefRepository departmentRegionChiefRepository;
    private final DepartmentService departmentService;


    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
//        departmentService.getDepartmentEmployees(1, )
    }
}
