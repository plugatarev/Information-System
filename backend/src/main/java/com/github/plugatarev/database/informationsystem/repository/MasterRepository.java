package com.github.plugatarev.database.informationsystem.repository;

import com.github.plugatarev.database.informationsystem.entity.Master;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long> {
    @Query(value = """
            select m from Master m, DepartmentRegion dr
            where m.departmentRegionChief.id=dr.departmentRegionChief.id and dr.department.id=:departmentId
            """)
    Page<Master> findMastersByDepartment(Long departmentId, Pageable pageable);

    @Query(value = """
            select m from Master m, DepartmentRegion dr
            where m.departmentRegionChief.id=dr.departmentRegionChief.id and dr.id=:drId
            """)
    Page<Master> findMastersByDepartmentRegion(Long drId, Pageable pageable);
}
