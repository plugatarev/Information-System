package com.github.plugatarev.database.informationsystem.service;

import com.github.plugatarev.database.informationsystem.dto.OrderTestDto;
import com.github.plugatarev.database.informationsystem.entity.OrderTest;
import com.github.plugatarev.database.informationsystem.mapper.IMapper;
import com.github.plugatarev.database.informationsystem.mapper.OrderTestMapper;
import com.github.plugatarev.database.informationsystem.repository.OrderTestRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderTestService extends AbstractService<OrderTest, OrderTestDto> {

    private final OrderTestRepository orderTestRepository;
    private final OrderTestMapper orderTestMapper;

    @Override
    protected JpaRepository<OrderTest, Long> getRepository() {
        return orderTestRepository;
    }

    @Override
    protected IMapper<OrderTest, OrderTestDto> getMapper() {
        return orderTestMapper;
    }

    @Override
    public OrderTestDto create(OrderTestDto dto) {
        var entity = getMapper().toEntity(dto);
        entity = getRepository().save(entity);
        return getMapper().toDto(entity);
    }
}
