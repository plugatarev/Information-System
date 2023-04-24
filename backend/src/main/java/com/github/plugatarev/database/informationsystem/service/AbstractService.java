package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.AbstractDto;
import com.github.plugatarev.database.informationsystem.entity.AbstractEntity;
import com.github.plugatarev.database.informationsystem.exception.EntityNotFoundException;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class AbstractService<E extends AbstractEntity, DTO extends AbstractDto> implements Service<DTO> {

    protected abstract JpaRepository<E, Long> getRepository();
    protected abstract IMapper<E, DTO> getMapper();

    @Override
    public long countAll() {
        return getRepository().count();
    }

    @Override
    public DTO getById(Long id) {
        E entity = getEntityByIdOrThrow(id);
        return getMapper().toDto(entity);
    }

    @Override
    public Page<DTO> getAll(Pageable pageable) {
        return getRepository()
                .findAll(pageable)
                .map(getMapper()::toDto);
    }

    @Override
    public Collection<DTO> getAllById(Collection<Long> idCollection) {
        return getRepository()
                .findAllById(idCollection)
                .stream()
                .map(getMapper()::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DTO create(DTO dto) {
        var entity = getMapper().toEntity(dto);
        entity = getRepository().save(entity);
        return getMapper().toDto(entity);
    }

    @Override
    public DTO save(Long id, DTO dto) {
        dto.setId(id);
        return create(dto);
    }

    @Override
    public Collection<DTO> saveAll(Collection<DTO> dtoCollection) {
        var entityCollection = dtoCollection
                .stream()
                .map(getMapper()::toEntity)
                .collect(Collectors.toList());

        return getRepository()
                .saveAll(entityCollection)
                .stream()
                .map(getMapper()::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        getRepository().deleteById(id);
    }

    @Override
    public void deleteAllById(Collection<Long> idCollection) {
        var entityCollection = idCollection
                .stream()
                .map(getRepository()::getOne)
                .collect(Collectors.toList());

        getRepository().deleteAll(entityCollection);
    }

    protected E getEntityByIdOrThrow(Long id) {
        return getRepository().findById(id).orElseThrow(() ->
                new EntityNotFoundException(
                        String.format("Entity with id '%s' was not found", id)
                )
        );
    }

    protected String prepareStringToLikeStatement(String stringValue) {
        return stringValue == null ?
                null : String.format("%%%s%%", stringValue.toLowerCase());
    }

}
