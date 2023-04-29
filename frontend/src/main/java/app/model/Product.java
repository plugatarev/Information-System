package app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
public class Product extends Entity {
    private ProductCategoryType categoryType = new ProductCategoryType();
    private Department manufacturerDepartment = new Department();
    private String customer;

    private String categoryTypeProperty;
    private String manufacturerDepartmentNameProperty;

    @Override
    public Product clone() {
        var clone = (Product) super.clone();
        clone.setCategoryType(categoryType);
        clone.setManufacturerDepartment(manufacturerDepartment);
        return (Product) super.clone();
    }

    @Override
    public void calculateProperties() {
        super.calculateProperties();
        if (categoryType != null) categoryTypeProperty = categoryType.getName();
        if (manufacturerDepartment != null) manufacturerDepartmentNameProperty = manufacturerDepartment.getDepartmentName();
    }

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("categoryTypeProperty", "Тип изделия");
        propertyNames.put("manufacturerDepartmentNameProperty", "Цех сборщик");
        propertyNames.put("customer", "Заказчик");

        sortPropertyNames.putAll(Entity.getSortPropertyNames());
        sortPropertyNames.put("categoryTypeProperty", "Тип изделия");
        sortPropertyNames.put("manufacturerDepartmentNameProperty", "Цех сборщик");
        sortPropertyNames.put("customer", "Заказчик");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }
}
