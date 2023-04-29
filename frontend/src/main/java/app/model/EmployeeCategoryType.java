package app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
public class EmployeeCategoryType extends Entity {
    private String name;
    private EmployeeCategory employeeCategory = new EmployeeCategory();

    private String employeeCategoryNameProperty;

    @Override
    public EmployeeCategoryType clone() {
        var clone = (EmployeeCategoryType) super.clone();
        clone.setEmployeeCategory(employeeCategory.clone());
        return (EmployeeCategoryType) super.clone();
    }

    @Override
    public void calculateProperties() {
        super.calculateProperties();
        if (employeeCategory != null) employeeCategoryNameProperty = employeeCategory.getName();
    }

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("employeeCategoryNameProperty", "Вид сотрудника");
        propertyNames.put("name", "Специализация сотрудника");

        sortPropertyNames.putAll(Entity.getSortPropertyNames());
        sortPropertyNames.put("employeeCategoryNameProperty", "Вид сотрудника");
        sortPropertyNames.put("name", "Специализация сотрудника");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }

}
