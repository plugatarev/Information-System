package com.github.plugatarev.database.informationsystem.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface Service<DTO> {

    long countAll();

    DTO getById(Long id);

    Page<DTO> getAll(Pageable pageable);

    Collection<DTO> getAllById(Collection<Long> idCollection);

    DTO create(DTO dto);

    DTO save(Long id, DTO dto);

    Collection<DTO> saveAll(Collection<DTO> dtoCollection);

    void deleteById(Long id);

    void deleteAllById(Collection<Long> idCollection);

}
