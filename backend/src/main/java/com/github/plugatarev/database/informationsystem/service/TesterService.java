package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.TesterDto;
import com.github.plugatarev.database.informationsystem.entity.Tester;
import com.github.plugatarev.database.informationsystem.filter.TesterFilter;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.TesterMapper;
import com.github.plugatarev.database.informationsystem.repository.EmployeeRepository;
import com.github.plugatarev.database.informationsystem.repository.TesterRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class TesterService extends AbstractService<Tester, TesterDto> {

    private final TesterRepository testerRepository;
    private final TesterMapper testerMapper;

    @Override
    protected JpaRepository<Tester, Long> getRepository() {
        return testerRepository;
    }

    @Override
    protected IMapper<Tester, TesterDto> getMapper() {
        return testerMapper;
    }

    public Page<TesterDto> searchByFilter(TesterFilter filter, Pageable pageable) {
        Long laboratoryId = filter.getLaboratory() == null ? null : filter.getLaboratory().getId();
        Long productId = filter.getProduct() == null ? null : filter.getProduct().getId();
        Date minDateTest = filter.getMinDateTest() == null ? null : filter.getMinDateTest();
        Date maxDateTest = filter.getMaxDateTest() == null ? null : filter.getMaxDateTest();
        String productType = filter.getProductType() == null ? null : filter.getProductType().name().toLowerCase();

        if (productId == null && minDateTest == null && maxDateTest == null && productType == null) {
            if (laboratoryId != null) {
                return testerRepository.findByLaboratoryId(laboratoryId, pageable).map(testerMapper::toDto);
            }
            return testerRepository.findAll(pageable).map(testerMapper::toDto);
        }

        return testerRepository.searchByType(laboratoryId, productType, minDateTest, maxDateTest, pageable).map(testerMapper::toDto);
    }
}
