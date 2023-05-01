package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.BrigadeDto;
import com.github.plugatarev.database.informationsystem.entity.Brigade;
import com.github.plugatarev.database.informationsystem.mapper.BrigadeMapper;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.repository.BrigadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrigadeService extends AbstractService<Brigade, BrigadeDto> {

    private final BrigadeRepository brigadeRepository;
    private final BrigadeMapper brigadeMapper;


    @Override
    protected JpaRepository<Brigade, Long> getRepository() {
        return brigadeRepository;
    }

    @Override
    protected IMapper<Brigade, BrigadeDto> getMapper() {
        return brigadeMapper;
    }

    public Page<BrigadeDto> getBrigades(Long departmentRegionId, Pageable pageable) {
        Page<Brigade> brigades = brigadeRepository.findAllByDepartmentRegionId(departmentRegionId, pageable);
        return brigades.map(brigadeMapper::toDto);
    }
}
