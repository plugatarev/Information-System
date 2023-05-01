package com.github.plugatarev.database.informationsystem.repository;

import com.github.plugatarev.database.informationsystem.entity.DepartmentRegion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRegionRepository extends JpaRepository<DepartmentRegion, Long> {
    Page<DepartmentRegion> findAllByDepartmentId(Long departmentId, Pageable pageable);
}
