package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.MasterDto;
import com.github.plugatarev.database.informationsystem.entity.Master;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.MasterMapper;
import com.github.plugatarev.database.informationsystem.repository.MasterRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MasterService extends AbstractService<Master, MasterDto> {

    private final MasterRepository masterRepository;
    private final MasterMapper masterMapper;

    @Override
    protected JpaRepository<Master, Long> getRepository() {
        return masterRepository;
    }

    @Override
    protected IMapper<Master, MasterDto> getMapper() {
        return masterMapper;
    }
}
