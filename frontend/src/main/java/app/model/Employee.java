package app.model;

import app.utils.LocalDateFormatter;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
public class Employee extends Entity {

    private String firstName;
    private String secondName;
    private String passport;
    private EmployeeCategoryType employeeCategoryType = new EmployeeCategoryType();
    private LocalDate employmentDate = LocalDate.now();
    private LocalDate dismissalDate = LocalDate.now();

    private String employeeCategoryTypeProperty;
    private String employmentDateProperty;
    private String dismissalDateProperty;

    @Override
    public Employee clone() {
        return (Employee) super.clone();
    }


    @Override
    public void calculateProperties() {
        super.calculateProperties();
        employeeCategoryTypeProperty = employeeCategoryType.getName();
        employmentDateProperty = LocalDateFormatter.getFormattedDate(employmentDate);
        dismissalDateProperty = LocalDateFormatter.getFormattedDate(dismissalDate);
    }
    
    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("firstName", "Имя");
        propertyNames.put("secondName", "Фамилия");
        propertyNames.put("passport", "Паспорт");
        propertyNames.put("employmentDateProperty", "Дата найма");
        propertyNames.put("dismissalDateProperty", "Дата увольнения");
        propertyNames.put("employeeCategoryTypeProperty", "Тип сотрудника");

        sortPropertyNames.putAll(Entity.getPropertyNames());
        sortPropertyNames.put("firstName", "Имя");
        sortPropertyNames.put("secondName", "Фамилия");
        sortPropertyNames.put("passport", "Паспорт");
        sortPropertyNames.put("employmentDateProperty", "Дата найма");
        sortPropertyNames.put("dismissalDateProperty", "Дата увольнения");
        sortPropertyNames.put("employeeCategoryTypeProperty", "Тип сотрудника");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }

}
