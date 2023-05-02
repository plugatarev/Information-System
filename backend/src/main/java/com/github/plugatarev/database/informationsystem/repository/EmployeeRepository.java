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
            e.id in (select dr.departmentRegionChief.id from DepartmentRegion dr where (:departmentId is null or dr.department.id=:departmentId) and
            (:employeeType is null or dr.departmentRegionChief.employeeCategoryType.employeeCategory.name=:employeeType))
            or e.id in (select m.id from Master m, DepartmentRegion dr where m.departmentRegionChief.id=dr.departmentRegionChief.id and (:departmentId is null or dr.department.id=:departmentId) and
            (:employeeType is null or m.employeeCategoryType.employeeCategory.name=:employeeType))
            or e.id in (select d.departmentChief.id from Department d where (:departmentId is null or d.id=:departmentId) and
            (:employeeType is null or d.departmentChief.employeeCategoryType.employeeCategory.name=:employeeType))
            or e.id in (select b.id from Brigadier b, Brigade brigade where brigade.brigadier.id=b.id and (:departmentId is null or brigade.departmentRegion.department.id=:departmentId) and
            (:employeeType is null or b.employeeCategoryType.employeeCategory.name=:employeeType))
            or e.id in (select wb.worker.id from WorkerBrigade wb where (:departmentId is null or wb.brigade.departmentRegion.department.id=:departmentId) and
            (:employeeType is null or wb.worker.employeeCategoryType.employeeCategory.name=:employeeType))
            """)
    Page<Employee> findEmployeesByDepartment(String employeeType, Long departmentId, Pageable pageable);

    @Query(value = """
            select distinct e from Employee e where
            e.id in (select dr.departmentRegionChief.id from DepartmentRegion dr where (:drId is null or dr.id=:drId) and
            (:employeeType is null or dr.departmentRegionChief.employeeCategoryType.employeeCategory.name=:employeeType))
            or e.id in (select m.id from Master m, DepartmentRegion dr where m.departmentRegionChief.id=dr.departmentRegionChief.id and (:drId is null or dr.id=:drId) and
            (:employeeType is null or m.employeeCategoryType.employeeCategory.name=:employeeType))
            or e.id in (select d.departmentChief.id from Department d, DepartmentRegion dr where d.id=dr.department.id and (:drId is null or dr.id=:drId) and
            (:employeeType is null or d.departmentChief.employeeCategoryType.employeeCategory.name=:employeeType))
            or e.id in (select b.id from Brigadier b, Brigade brigade where brigade.brigadier.id=b.id and (:drId is null or brigade.departmentRegion.id=:drId) and
            (:employeeType is null or b.employeeCategoryType.employeeCategory.name=:employeeType))
            or e.id in (select wb.worker.id from WorkerBrigade wb where (:drId is null or wb.brigade.departmentRegion.id=:drId) and
            (:employeeType is null or wb.worker.employeeCategoryType.employeeCategory.name=:employeeType))
            """)
    Page<Employee> findEmployeesByDepartmentRegion(String employeeType, Long drId, Pageable pageable);

    @Query(value = "select e from Employee e where e.employeeCategoryType.employeeCategory.name=:employeeType")
    Page<Employee> findEmployeesByType(String employeeType, Pageable pageable);

    @Query(value = "select wb.worker from WorkerBrigade wb where wb.brigade.departmentRegion.id=:departmentRegionId")
    Page<Employee> findBrigadeWorkersByDepartmentRegion(Long departmentRegionId, Pageable pageable);

    @Query(value = "select wb.worker from WorkerBrigade wb where wb.brigade.departmentRegion.department.id=:departmentId")
    Page<Employee> findBrigadeWorkersByDepartment(Long departmentId, Pageable pageable);
}
