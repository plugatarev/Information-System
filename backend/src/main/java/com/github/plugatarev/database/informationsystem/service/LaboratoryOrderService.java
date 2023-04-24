package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.LaboratoryOrderDto;
import com.github.plugatarev.database.informationsystem.entity.LaboratoryOrder;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.LaboratoryOrderMapper;
import com.github.plugatarev.database.informationsystem.repository.LaboratoryOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LaboratoryOrderService extends AbstractService<LaboratoryOrder, LaboratoryOrderDto> {

    private final LaboratoryOrderRepository laboratoryOrderRepository;
    private final LaboratoryOrderMapper laboratoryOrderMapper;

    @Override
    protected JpaRepository<LaboratoryOrder, Long> getRepository() {
        return laboratoryOrderRepository;
    }

    @Override
    protected IMapper<LaboratoryOrder, LaboratoryOrderDto> getMapper() {
        return laboratoryOrderMapper;
    }
}
