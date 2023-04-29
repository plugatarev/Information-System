package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.TesterDto;
import com.github.plugatarev.database.informationsystem.entity.Tester;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TesterMapper extends IMapper<Tester, TesterDto> {
    @Override
    TesterDto toDto(Tester tester);

    @Override
    Tester toEntity(TesterDto testerDto);
}