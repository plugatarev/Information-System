package app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
public class Department extends Entity {

    private String departmentName;
    private DepartmentChief chief = new DepartmentChief();

    private String chiefFirstNameProperty;
    private String chiefSecondNameProperty;

    @Override
    public Department clone() {
        var clone = (Department) super.clone();
        clone.setChief(chief.clone());
        return clone;
    }

    @Override
    public void calculateProperties() {
        super.calculateProperties();
        chiefFirstNameProperty = chief.getFirstName();
        chiefSecondNameProperty = chief.getSecondName();
    }

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("departmentName", "Цех");
        propertyNames.put("chiefFirstNameProperty", "Имя начальника");
        propertyNames.put("chiefSecondNameProperty", "Фамилия начальника");

        sortPropertyNames.putAll(Entity.getSortPropertyNames());
        sortPropertyNames.put("name", "Название отдела");
        sortPropertyNames.put("chiefFirstNameProperty", "Имя начальника");
        sortPropertyNames.put("chiefSecondNameProperty", "Фамилия начальника");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }
}
