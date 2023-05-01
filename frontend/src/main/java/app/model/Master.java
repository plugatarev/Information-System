package app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
public class Master extends Employee {

    private String masterName;
    private DepartmentRegionChief chief = new DepartmentRegionChief();

    private String chiefNameProperty;

    @Override
    public Master clone() {
        var clone = (Master) super.clone();
        clone.setChief(chief.clone());
        return (Master) super.clone();
    }

    @Override
    public void calculateProperties() {
        super.calculateProperties();
        masterName = getFirstName() + " " + getSecondName();
        if (chief != null) chiefNameProperty = chief.getFirstName() + " " + chief.getSecondName();
    }

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("masterName", "Мастер");
        propertyNames.put("chiefNameProperty", "Его начальник");

        sortPropertyNames.putAll(Entity.getSortPropertyNames());
        sortPropertyNames.put("masterName", "Тип изделия");
        sortPropertyNames.put("chiefNameProperty", "Его начальник");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }

}
