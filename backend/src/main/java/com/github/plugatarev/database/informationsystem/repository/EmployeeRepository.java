package com.github.plugatarev.database.informationsystem.repository;

import com.github.plugatarev.database.informationsystem.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = """
            select distinct e from Employee e where
            e.id in (select dr.departmentRegionChief.id from DepartmentRegion dr where dr.department.id=:departmentId)
            or e.id in (select m.id from Master m, DepartmentRegion dr where m.chief.id=dr.departmentRegionChief.id and dr.department.id=:departmentId)
            or e.id in (select d.departmentChief.id from Department d where d.id=:departmentId)
            or e.id in (select b.id from Brigadier b, Brigade brigade where brigade.brigadier.id=b.id and brigade.departmentRegion.department.id=:departmentId)
            or e.id in (select wb.id from WorkerBrigade wb where wb.brigade.departmentRegion.department.id=:departmentId)
            """)
    Page<Employee> findEmployeesByDepartment(Long departmentId, Pageable pageable);

    @Query(value = """
            select distinct e from Employee e where
            e.id in (select dr.departmentRegionChief.id from DepartmentRegion dr where dr.id=:drId)
            or e.id in (select m.id from Master m, DepartmentRegion dr where m.chief.id=dr.departmentRegionChief.id and dr.id=:drId)
            or e.id in (select d.departmentChief.id from Department d, DepartmentRegion dr where d.id=dr.department.id and dr.id=:drId)
            or e.id in (select b.id from Brigadier b, Brigade brigade where brigade.brigadier.id=b.id and brigade.departmentRegion.id=:drId)
            or e.id in (select wb.id from WorkerBrigade wb where wb.brigade.departmentRegion.id=:drId)
            """)
    Page<Employee> findEmployeesByDepartmentRegion(Long drId, Pageable pageable);

    @Query("""
            select e from Employee e
            where :employeeType is null or e.employeeCategoryType.employeeCategory.name=:employeeType
            """)
    Page<Employee> searchByFilter(String employeeType, Pageable pageable);
}
