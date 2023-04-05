package com.github.plugatarev.database.informationsystem.repository;

import com.github.plugatarev.database.informationsystem.entity.DepartmentRegionChief;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRegionChiefRepository extends CrudRepository<DepartmentRegionChief, Long> {
}
