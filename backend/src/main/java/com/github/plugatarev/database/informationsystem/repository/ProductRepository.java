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
                select pp.product from ProductProcess pp where
                (:productType is null or pp.product.categoryType.category.name=:productType) and
                (:productStatus is null or pp.status.name=:productStatus) and
                (cast(:minAssembledDate as date) is null or pp.releaseDate >= cast(:minAssembledDate as date)) and
                (cast(:maxAssembledDate as date) is null or pp.releaseDate <= cast(:maxAssembledDate as date)) and
                (:dId is null or pp.product.manufacturerDepartment.id=:dId)
                """)
    Page<Product> searchByFilter(String productType,
                                 String productStatus,
                                 Date minAssembledDate,
                                 Date maxAssembledDate,
                                 Long dId,
                                 Pageable pageable);

    @Query(value = """
                select pp.product from ProductProcess pp, OrderTest ot where
                ot.laboratoryOrder.product.id=pp.product.id and
                (:productType is null or pp.product.categoryType.category.name=:productType) and
                (:productStatus is null or pp.status.name=:productStatus) and
                (cast(:minAssembledDate as date) is null or pp.releaseDate >= cast(:minAssembledDate as date)) and
                (cast(:maxAssembledDate as date) is null or pp.releaseDate <= cast(:maxAssembledDate as date)) and
                (:dId is null or pp.product.manufacturerDepartment.id=:dId) and
                (:laboratoryId is null or ot.laboratoryOrder.laboratory.id=:laboratoryId) and
                (cast(:minLaboratoryDate as date) is null or ot.testingDate >= cast(:minLaboratoryDate as date)) and
                (cast(:maxLaboratoryDate as date) is null or ot.testingDate <= cast(:maxLaboratoryDate as date))
                """)
    Page<Product> searchByLaboratoryAndProductFilter(String productType,
                                           String productStatus,
                                           Date minAssembledDate,
                                           Date maxAssembledDate,
                                           Long dId,
                                           Long laboratoryId,
                                           Date minLaboratoryDate,
                                           Date maxLaboratoryDate,
                                           Pageable pageable);

    @Query(value = """
                select ot.laboratoryOrder.product from OrderTest ot where
                (:productType is null or ot.laboratoryOrder.product.categoryType.category.name=:productType) and
                (:dId is null or ot.laboratoryOrder.product.manufacturerDepartment.id=:dId) and
                (:laboratoryId is null or ot.laboratoryOrder.laboratory.id=:laboratoryId) and
                (cast(:minLaboratoryDate as date) is null or ot.testingDate >= cast(:minLaboratoryDate as date)) and
                (cast(:maxLaboratoryDate as date) is null or ot.testingDate <= cast(:maxLaboratoryDate as date))
                """)
    Page<Product> searchByLaboratoryFilter(String productType,
                                           Long dId,
                                           Long laboratoryId,
                                           Date minLaboratoryDate,
                                           Date maxLaboratoryDate,
                                           Pageable pageable);

    Page<Product> findAll(Pageable pageable);

    @Query(value = "select p from Product p where p.categoryType.category.name=:type")
    Page<Product> findAllByType(String type, Pageable pageable);
}
