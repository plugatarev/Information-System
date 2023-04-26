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
    private Brigade collectingBrigade = new Brigade();
    private DepartmentRegionChief chief = new DepartmentRegionChief();

    private String departmentNameProperty;
    private String collectionBrigadeNameProperty;
    private String chiefFirstNameProperty;
    private String chiefSecondNameProperty;

    @Override
    public DepartmentRegion clone() {
        var clone = (DepartmentRegion) super.clone();
        clone.setChief(chief.clone());
        clone.setDepartment(department.clone());
        clone.setCollectingBrigade(collectingBrigade.clone());
        return clone;
    }

    @Override
    public void calculateProperties() {
        super.calculateProperties();
        chiefFirstNameProperty = chief.getFirstName();
        chiefSecondNameProperty = chief.getSecondName();
        departmentNameProperty = department.getDepartmentName();
        collectionBrigadeNameProperty = collectingBrigade.getBrigadeName();
    }

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("regionName", "Участок");
        propertyNames.put("departmentNameProperty", "Цех");
        propertyNames.put("collectionBrigadeNameProperty", "Собирающая бригада");
        propertyNames.put("chiefFirstNameProperty", "Имя начальника");
        propertyNames.put("chiefSecondNameProperty", "Фамилия начальника");

        sortPropertyNames.putAll(Entity.getSortPropertyNames());
        sortPropertyNames.put("regionName", "Участок");
        sortPropertyNames.put("departmentNameProperty", "Цех");
        sortPropertyNames.put("collectionBrigadeNameProperty", "Собирающая бригада");
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
