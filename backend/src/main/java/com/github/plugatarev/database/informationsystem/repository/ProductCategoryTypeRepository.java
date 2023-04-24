package com.github.plugatarev.database.informationsystem.repository;

import com.github.plugatarev.database.informationsystem.entity.ProductCategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryTypeRepository extends JpaRepository<ProductCategoryType, Long> {
}
