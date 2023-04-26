package app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
public class ProductCategoryType extends Entity {
    private String name;
    private ProductCategory category = new ProductCategory();

    private String categoryNameProperty;

    @Override
    public ProductCategoryType clone() {
        var clone = (ProductCategoryType) super.clone();
        clone.setCategory(category.clone());
        return (ProductCategoryType) super.clone();
    }

    @Override
    public void calculateProperties() {
        super.calculateProperties();
        categoryNameProperty = category.getName();
    }

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("categoryNameProperty", "Подвид изделия");
        propertyNames.put("name", "Вид изделия");

        sortPropertyNames.putAll(Entity.getSortPropertyNames());
        sortPropertyNames.put("categoryNameProperty", "Подвид изделия");
        sortPropertyNames.put("name", "Вид изделия");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }
}
