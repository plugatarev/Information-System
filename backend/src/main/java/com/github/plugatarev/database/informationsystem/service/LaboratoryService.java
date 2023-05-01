package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.LaboratoryDto;
import com.github.plugatarev.database.informationsystem.entity.Laboratory;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.LaboratoryMapper;
import com.github.plugatarev.database.informationsystem.repository.LaboratoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LaboratoryService extends AbstractService<Laboratory, LaboratoryDto> {

    private final LaboratoryRepository laboratoryRepository;
    private final LaboratoryMapper laboratoryMapper;

    @Override
    protected JpaRepository<Laboratory, Long> getRepository() {
        return laboratoryRepository;
    }

    @Override
    protected IMapper<Laboratory, LaboratoryDto> getMapper() {
        return laboratoryMapper;
    }

    public Page<LaboratoryDto> getLaboratoriesByProduct(Long productId, Pageable pageable) {
        return laboratoryRepository.findLaboratoriesByProduct(productId, pageable).map(laboratoryMapper::toDto);
    }
}
