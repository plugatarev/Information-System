package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.RegionBrigadeDto;
import com.github.plugatarev.database.informationsystem.entity.RegionBrigade;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.RegionBrigadeMapper;
import com.github.plugatarev.database.informationsystem.repository.RegionBrigadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegionBrigadeService extends AbstractService<RegionBrigade, RegionBrigadeDto> {

    private final RegionBrigadeRepository regionBrigadeRepository;
    private final RegionBrigadeMapper regionBrigadeMapper;

    @Override
    protected JpaRepository<RegionBrigade, Long> getRepository() {
        return regionBrigadeRepository;
    }

    @Override
    protected IMapper<RegionBrigade, RegionBrigadeDto> getMapper() {
        return regionBrigadeMapper;
    }
}
