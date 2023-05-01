package com.github.plugatarev.database.informationsystem.repository;

import com.github.plugatarev.database.informationsystem.entity.ProductProcess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductProcessRepository extends JpaRepository<ProductProcess, Long> {
    Page<ProductProcess> findAllByProductId(Long productId, Pageable pageable);
}
