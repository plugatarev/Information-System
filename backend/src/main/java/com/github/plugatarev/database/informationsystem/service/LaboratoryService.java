package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.entity.Laboratory;
import com.github.plugatarev.database.informationsystem.exception.NotFoundEntityException;
import com.github.plugatarev.database.informationsystem.exception.NotUniqueEntityException;
import com.github.plugatarev.database.informationsystem.repository.LaboratoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LaboratoryService {

    private final LaboratoryRepository laboratoryRepository;

    public Laboratory save(Laboratory laboratory) {
        String laboratoryName = laboratory.getLaboratoryName();
        if (laboratoryRepository.existsByLaboratoryName(laboratoryName)) {
            throw new NotUniqueEntityException("Laboratory entity with name " + laboratoryName + " already exists!");
        }
        return laboratoryRepository.save(laboratory);
    }

    public void delete(Long id) {
        laboratoryRepository.deleteById(id);
    }

    public Laboratory update(Long id, Laboratory laboratory) {
        Laboratory updateLaboratory = laboratoryRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("Laboratory entity with id " + id + " not found")
        );
        updateLaboratory.setLaboratoryName(laboratory.getLaboratoryName());
        return laboratoryRepository.save(laboratory);
    }

    public Laboratory getById(Long id) {
        return laboratoryRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("Laboratory entity with id " + id + " not found")
        );

    }

    public List<Laboratory> getAll() {
        return laboratoryRepository.findAll();
    }
}
