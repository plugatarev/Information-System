package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.EquipmentDto;
import com.github.plugatarev.database.informationsystem.entity.Equipment;
import com.github.plugatarev.database.informationsystem.filter.EquipmentFilter;
import com.github.plugatarev.database.informationsystem.mapper.EquipmentMapper;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.repository.EquipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class EquipmentService extends AbstractService<Equipment, EquipmentDto> {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;

    @Override
    protected JpaRepository<Equipment, Long> getRepository() {
        return equipmentRepository;
    }

    @Override
    protected IMapper<Equipment, EquipmentDto> getMapper() {
        return equipmentMapper;
    }

    public Page<EquipmentDto> searchByFilter(EquipmentFilter filter, Pageable pageable) {
        Long laboratoryId = filter.getLaboratory() == null ? null : filter.getLaboratory().getId();
        String productType = filter.getProductType() == null ? null : filter.getProductType().name().toLowerCase();
        Long productId = filter.getProduct() == null ? null : filter.getProduct().getId();
        Date minDateTest = filter.getMinDateTest() == null ? null : filter.getMinDateTest();
        Date maxDateTest = filter.getMaxDateTest() == null ? null : filter.getMaxDateTest();

        if (laboratoryId == null && productId == null && productType == null && minDateTest == null && maxDateTest == null) {
            return equipmentRepository.findAll(pageable).map(equipmentMapper::toDto);
        }
        if (productId != null) {
            return equipmentRepository.searchByProductFilter(
                    productId,
                    laboratoryId,
                    minDateTest,
                    maxDateTest,
                    pageable
            ).map(equipmentMapper::toDto);
        }

        return equipmentRepository
                .searchByTypeFilter(
                        laboratoryId,
                        productType,
                        minDateTest,
                        maxDateTest,
                        pageable)
                .map(equipmentMapper::toDto);
    }
}
