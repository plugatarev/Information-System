package com.github.plugatarev.database.informationsystem.mapper;

import com.github.plugatarev.database.informationsystem.dto.TestDto;
import com.github.plugatarev.database.informationsystem.entity.Test;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TestMapper {
    TestDto testToTestDto(Test test);

    Test testDtoToTest(TestDto testDto);
}