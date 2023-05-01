package com.github.plugatarev.database.informationsystem.repository;

import com.github.plugatarev.database.informationsystem.entity.Laboratory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {
    @Query("select l from Laboratory l, LaboratoryOrder lo where lo.laboratory.id=l.id and lo.product.id=:productId")
    Page<Laboratory> findLaboratoriesByProduct(Long productId, Pageable pageable);
}
