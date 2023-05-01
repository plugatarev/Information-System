package com.github.plugatarev.database.informationsystem.repository;

import com.github.plugatarev.database.informationsystem.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

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

    @Query(value = """
                select distinct p from Product p, ProductProcess pp where
                pp.product.id=p.id and
                (:productType is null or p.categoryType.category.name=:productType) and
                (:productStatus is null or pp.status.name=:productStatus) and
                (cast(:minAssembledDate as date) is null or pp.releaseDate >= cast(:minAssembledDate as date)) and
                (cast(:maxAssembledDate as date) is null or pp.releaseDate <= cast(:maxAssembledDate as date)) and
                (:dId is null or p.manufacturerDepartment.id=:dId)
                """)
    Page<Product> searchByFilter(String productType,
                                 String productStatus,
                                 Date minAssembledDate,
                                 Date maxAssembledDate,
                                 Long dId,
                                 Pageable pageable);
}
