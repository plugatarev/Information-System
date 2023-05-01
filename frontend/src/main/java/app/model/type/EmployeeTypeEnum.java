package app.model.type;

import app.gui.custom.ChoiceItem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum EmployeeTypeEnum {
    ENGINEER,
    WORKER,
    TESTER;

    public static String toLocalizedString(EmployeeTypeEnum type) {
        return switch (type) {
            case ENGINEER -> "Инженерная специальность";
            case WORKER -> "Рабочий";
            case TESTER -> "Лабораторный работник";
        };
    }

    public static List<ChoiceItem<EmployeeTypeEnum>> getChoiceItems() {
        return Arrays.stream(EmployeeTypeEnum.values())
                     .map(s -> new ChoiceItem<>(s, EmployeeTypeEnum.toLocalizedString(s)))
                     .collect(Collectors.toList());
    }
}
