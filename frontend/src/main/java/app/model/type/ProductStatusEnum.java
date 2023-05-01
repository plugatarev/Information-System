package app.model.type;

import app.gui.custom.ChoiceItem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ProductStatusEnum {
    WAITING,
    ASSEMBLED,
    ASSEMBLING;

    public static String toLocalizedString(ProductStatusEnum status) {
        return switch (status) {
            case WAITING -> "Ожидает";
            case ASSEMBLED -> "Собран";
            case ASSEMBLING -> "Собирается";
        };
    }

    public static List<ChoiceItem<ProductStatusEnum>> getChoiceItems() {
        return Arrays.stream(ProductStatusEnum.values())
                     .map(s -> new ChoiceItem<>(s, ProductStatusEnum.toLocalizedString(s)))
                     .collect(Collectors.toList());
    }
}
