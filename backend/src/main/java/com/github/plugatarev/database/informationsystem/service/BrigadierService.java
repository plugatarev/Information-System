package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.BrigadierDto;
import com.github.plugatarev.database.informationsystem.entity.Brigadier;
import com.github.plugatarev.database.informationsystem.mapper.BrigadierMapper;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.repository.BrigadierRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrigadierService extends AbstractService<Brigadier, BrigadierDto> {

    private final BrigadierRepository brigadierRepository;
    private final BrigadierMapper brigadierMapper;

    @Override
    protected JpaRepository<Brigadier, Long> getRepository() {
        return brigadierRepository;
    }

    @Override
    protected IMapper<Brigadier, BrigadierDto> getMapper() {
        return brigadierMapper;
    }
}
