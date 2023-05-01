package com.github.plugatarev.database.informationsystem.repository;

import com.github.plugatarev.database.informationsystem.entity.Equipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    @Query("""
            select ot.test.equipment from OrderTest ot where
            (:productId is null or ot.laboratoryOrder.product.id=:productId) and
            (:laboratoryId is null or ot.laboratoryOrder.laboratory.id=:laboratoryId) and
            (cast(:minDateTest as date) is null or ot.testingDate >= cast(:minDateTest as date)) and
            (cast(:maxDateTest as date) is null or ot.testingDate >= cast(:maxDateTest as date))
            """)
    Page<Equipment> searchByProductFilter(
            Long productId,
            Long laboratoryId,
            Date minDateTest,
            Date maxDateTest,
            Pageable pageable);

    @Query("""
            select ot.test.equipment from OrderTest ot where
            (:productType is null or ot.laboratoryOrder.product.categoryType.category.name=:productType) and
            (:laboratoryId is null or ot.laboratoryOrder.laboratory.id=:laboratoryId) and
            (cast(:minDateTest as date) is null or ot.testingDate >= cast(:minDateTest as date)) and
            (cast(:maxDateTest as date) is null or ot.testingDate <= cast(:maxDateTest as date))
            """)
    Page<Equipment> searchByTypeFilter(
            Long laboratoryId,
            String productType,
            Date minDateTest,
            Date maxDateTest,
            Pageable pageable);
}
