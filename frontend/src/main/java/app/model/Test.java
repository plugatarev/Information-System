package app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
public class Test extends Entity {
    private Equipment equipment = new Equipment();
    private Tester tester = new Tester();
    private String description;

    private String equipmentSerialNumberProperty;
    private String testerNameProperty;

    @Override
    public Test clone() {
        var clone = (Test) super.clone();
        clone.setEquipment(equipment.clone());
        clone.setTester(tester.clone());
        return clone;
    }

    @Override
    public void calculateProperties() {
        super.calculateProperties();
        equipmentSerialNumberProperty = equipment.getSerialNumber();
        testerNameProperty = tester.getFirstName() + " " + tester.getSecondName();
    }

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("equipmentSerialNumberProperty", "Оборудование");
        propertyNames.put("testerFirstNameProperty", "Имя тестировщика");
        propertyNames.put("testerNameProperty", "Тестировщик");

        sortPropertyNames.putAll(Entity.getSortPropertyNames());
        sortPropertyNames.put("equipmentSerialNumberProperty", "Оборудование");
        sortPropertyNames.put("testerNameProperty", "Тестировщик");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }
}
