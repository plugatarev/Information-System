package app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
public class DepartmentRegion extends Entity {
    private String regionName;
    private Department department = new Department();
    private DepartmentRegionChief chief = new DepartmentRegionChief();

    private String departmentNameProperty;
    private String chiefNameProperty;

    @Override
    public DepartmentRegion clone() {
        var clone = (DepartmentRegion) super.clone();
        clone.setChief(chief.clone());
        clone.setDepartment(department.clone());
        return clone;
    }

    @Override
    public void calculateProperties() {
        super.calculateProperties();
        if (chief != null) chiefNameProperty = chief.getFirstName() + " " + chief.getSecondName();
        if (department != null) departmentNameProperty = department.getDepartmentName();
    }

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("regionName", "Участок");
        propertyNames.put("departmentNameProperty", "Цех");
//        propertyNames.put("chiefNameProperty", "Начальник");

        sortPropertyNames.putAll(Entity.getSortPropertyNames());
        sortPropertyNames.put("regionName", "Участок");
        sortPropertyNames.put("departmentNameProperty", "Цех");
//        sortPropertyNames.put("chiefNameProperty", "Начальник");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }

}
