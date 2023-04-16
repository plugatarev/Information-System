package com.github.plugatarev.database.informationsystem.repository;

import com.github.plugatarev.database.informationsystem.entity.Brigade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrigadeRepository extends JpaRepository<Brigade, Long> {
    boolean existsByBrigadeName(String name);
}
