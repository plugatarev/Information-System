package com.github.plugatarev.database.informationsystem.repository;

import com.github.plugatarev.database.informationsystem.entity.DepartmentRegionChief;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRegionChiefRepository extends JpaRepository<DepartmentRegionChief, Long> {
}
