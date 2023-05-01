package com.github.plugatarev.database.informationsystem.repository;

import com.github.plugatarev.database.informationsystem.entity.Brigade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrigadeRepository extends JpaRepository<Brigade, Long> {
    Page<Brigade> findAllByDepartmentRegionId(Long departmentRegionId, Pageable pageable);
}
