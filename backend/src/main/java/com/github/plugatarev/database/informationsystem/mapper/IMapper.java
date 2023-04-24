package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.AbstractDto;
import com.github.plugatarev.database.informationsystem.entity.AbstractEntity;

public interface IMapper<E extends AbstractEntity, DTO extends AbstractDto> {
    E toEntity(DTO dto);

    DTO toDto(E entity);
}
