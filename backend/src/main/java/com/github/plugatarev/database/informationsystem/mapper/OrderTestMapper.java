package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.OrderTestDto;
import com.github.plugatarev.database.informationsystem.entity.OrderTest;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderTestMapper extends IMapper<OrderTest, OrderTestDto> {
    @Override
    OrderTestDto toDto(OrderTest orderTest);

    @Override
    OrderTest toEntity(OrderTestDto orderTestDto);
}
