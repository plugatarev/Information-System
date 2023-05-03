package app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class Tester extends Employee {

    private Laboratory laboratory = new Laboratory();

    private String laboratoryProperty;
    private String testerNameProperty;

    @Override
    public Tester clone() {
        var tester = (Tester) super.clone();
        if (laboratory != null) tester.setLaboratory(laboratory.clone());
        return tester;
    }

    @Override
    public void calculateProperties() {
        super.calculateProperties();
        if (laboratory != null) laboratoryProperty = laboratory.getLaboratoryName();
        testerNameProperty = getFirstName() + " " + getSecondName();
    }

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("testerNameProperty", "Имя");
        propertyNames.put("laboratoryProperty", "Лаборатория");

        sortPropertyNames.putAll(Entity.getSortPropertyNames());
        sortPropertyNames.put("testerNameProperty", "Имя");
        sortPropertyNames.put("laboratoryProperty", "Лаборатория");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }
}
