package app.model.type;

import app.gui.custom.ChoiceItem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ProductTypeEnum {
    MOTORBIKE,
    TRUCK,
    PASSENGER_CAR,
    BUS,
    AGRICULTURAL_CAR,
    ROAD_CONSTRUCTION_CAR;

    public static String toLocalizedString(ProductTypeEnum type) {
        return switch (type) {
            case MOTORBIKE -> "Мотоцикл";
            case TRUCK -> "Грузовой автомобиль";
            case PASSENGER_CAR -> "Легковой автомобиль";
            case BUS -> "Автобус";
            case AGRICULTURAL_CAR -> "Сельскохозяйственный автомобиль";
            case ROAD_CONSTRUCTION_CAR -> "Дорожно-строительный автомобиль";
        };
    }

    public static List<ChoiceItem<ProductTypeEnum>> getChoiceItems() {
        return Arrays.stream(ProductTypeEnum.values())
                     .map(s -> new ChoiceItem<>(s, ProductTypeEnum.toLocalizedString(s)))
                     .collect(Collectors.toList());
    }
}
