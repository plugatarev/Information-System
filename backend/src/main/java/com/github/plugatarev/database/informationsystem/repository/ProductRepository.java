package com.github.plugatarev.database.informationsystem.repository;

import com.github.plugatarev.database.informationsystem.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = """
            select distinct p from Product p where p.manufacturerDepartment.id=:departmentId
            """)
    Page<Product> findProductsByDepartment(Long departmentId, Pageable pageable);

    @Query(value = """
            select distinct p from Product p, DepartmentRegion dr where dr.department.id=p.manufacturerDepartment.id and dr.id=:drId
            """)
    Page<Product> findProductsByDepartmentRegion(Long drId, Pageable pageable);
}
