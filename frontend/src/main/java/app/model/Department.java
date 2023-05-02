package app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
public class Department extends Entity {

    private String departmentName;
    private DepartmentChief departmentChief = new DepartmentChief();

    private String chiefNameProperty;

    @Override
    public Department clone() {
        var clone = (Department) super.clone();
        if (departmentChief != null) clone.setDepartmentChief(departmentChief.clone());
        return clone;
    }

    @Override
    public void calculateProperties() {
        super.calculateProperties();
        if (departmentChief != null) chiefNameProperty = departmentChief.getFirstName() + " " + departmentChief.getSecondName();
    }

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("departmentName", "Цех");
        propertyNames.put("chiefNameProperty", "Начальник");

        sortPropertyNames.putAll(Entity.getSortPropertyNames());
        sortPropertyNames.put("name", "Название отдела");
        sortPropertyNames.put("chiefNameProperty", "Начальник");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }
}
