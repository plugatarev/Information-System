package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.entity.Brigade;
import com.github.plugatarev.database.informationsystem.exception.NotFoundEntityException;
import com.github.plugatarev.database.informationsystem.exception.NotUniqueEntityException;
import com.github.plugatarev.database.informationsystem.repository.BrigadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrigadeService {

    private final BrigadeRepository brigadeRepository;

    public Brigade save(Brigade brigade) {
        String name = brigade.getBrigadeName();
        if (!brigadeRepository.existsByBrigadeName(name)) {
            throw new NotUniqueEntityException("Brigade with name " + name + " already exists!");
        }

        Brigade newBrigade = new Brigade();
        newBrigade.setBrigadier(brigade.getBrigadier());
        newBrigade.setBrigadeName(brigade.getBrigadeName());
        return brigadeRepository.save(newBrigade);
    }

    public void delete(Long id) {
        brigadeRepository.deleteById(id);
    }

    public Brigade update(Long id, Brigade brigade) {
        Brigade updateBrigade = brigadeRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("Brigade with id " + id + " not exists!")
        );
        updateBrigade.setBrigadeName(brigade.getBrigadeName());
        updateBrigade.setBrigadier(brigade.getBrigadier());
        return brigadeRepository.save(updateBrigade);
    }

    public Brigade getById(Long id) {
        return brigadeRepository.findById(id).orElseThrow(
                () -> new NotFoundEntityException("Brigade with id " + id + " not found")
        );
    }

    public List<Brigade> getAll() {
        return brigadeRepository.findAll();
    }
}
