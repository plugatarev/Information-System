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
    private Employee departmentRegionChief = new Employee();

    private String departmentNameProperty;
    private String departmentRegionChiefProperty;

    @Override
    public DepartmentRegion clone() {
        var clone = (DepartmentRegion) super.clone();
        clone.setDepartmentRegionChief(departmentRegionChief.clone());
        clone.setDepartment(department.clone());
        return clone;
    }

    @Override
    public void calculateProperties() {
        super.calculateProperties();
        if (departmentRegionChief != null) departmentRegionChiefProperty = departmentRegionChief.getFirstName() + " " + departmentRegionChief.getSecondName();
        if (department != null) departmentNameProperty = department.getDepartmentName();
    }

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("regionName", "Участок");
        propertyNames.put("departmentNameProperty", "Цех");
        propertyNames.put("departmentRegionChiefProperty", "Начальник");

        sortPropertyNames.putAll(Entity.getSortPropertyNames());
        sortPropertyNames.put("regionName", "Участок");
        sortPropertyNames.put("departmentNameProperty", "Цех");
        sortPropertyNames.put("departmentRegionChiefProperty", "Начальник");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }

}
