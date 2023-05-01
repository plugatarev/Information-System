package com.github.plugatarev.database.informationsystem.repository;

import com.github.plugatarev.database.informationsystem.entity.Brigade;
import com.github.plugatarev.database.informationsystem.entity.Employee;
import com.github.plugatarev.database.informationsystem.entity.WorkerBrigade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerBrigadeRepository extends JpaRepository<WorkerBrigade, Long> {

    Page<WorkerBrigade> findAllByBrigadeId(Long brigadeId, Pageable pageable);
    boolean existsByBrigadeAndWorker(Brigade brigade, Employee worker);

    @Query(value = """
                    select wb.worker from WorkerBrigade wb, ProductProcess pp
                    where pp.collectingBrigade.id=wb.brigade.id and pp.product.id=:productId
                    """)
    Page<Employee> findBrigadeEmployeesByProductId(Long productId, Pageable pageable);
}
