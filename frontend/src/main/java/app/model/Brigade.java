package app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
public class Brigade extends Entity {
    private String brigadeName;
    private Brigadier brigadier = new Brigadier();
    private DepartmentRegion departmentRegion = new DepartmentRegion();

    private String departmentRegionNameProperty;
    private String brigadierNameProperty;

    @Override
    public Brigade clone() {
        var clone = (Brigade) super.clone();
        clone.setBrigadier(brigadier.clone());
        clone.setDepartmentRegion(departmentRegion.clone());
        return clone;
    }

    @Override
    public void calculateProperties() {
        super.calculateProperties();
        if (departmentRegion != null) departmentRegionNameProperty = departmentRegion.getRegionName();
        if (brigadier != null) brigadierNameProperty = brigadier.getFirstName() + " " + brigadier.getSecondName();
    }

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("brigadeName", "Бригада");
        propertyNames.put("departmentRegionNameProperty", "Участок");
        propertyNames.put("brigadierNameProperty", "Начальник");

        sortPropertyNames.putAll(Entity.getSortPropertyNames());
        sortPropertyNames.put("brigadeName", "Бригада");
        sortPropertyNames.put("departmentRegionNameProperty", "Участок");
        sortPropertyNames.put("brigadierNameProperty", "Начальник");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }
}
