package app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
public class LaboratoryOrder extends Entity {
    private Product product = new Product();

    private Laboratory laboratory = new Laboratory();

    private Long laboratoryOrderNumberProperty;
    private String productTypeProperty;
    private String productCustomerProperty;
    private String laboratoryNameProperty;

    @Override
    public LaboratoryOrder clone() {
        var clone = (LaboratoryOrder) super.clone();
        clone.setProduct(product.clone());
        clone.setLaboratory(laboratory.clone());
        return (LaboratoryOrder) super.clone();
    }

    @Override
    public void calculateProperties() {
        super.calculateProperties();
        if (product != null) laboratoryOrderNumberProperty = product.getId();
        if (product != null && product.getCategoryType() != null) productTypeProperty = product.getCategoryType().getName();
        if (product != null) productCustomerProperty = product.getCustomer();
        if (laboratory != null) laboratoryNameProperty = laboratory.getLaboratoryName();
    }

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("laboratoryOrderNumberProperty", "Номер заказа");
        propertyNames.put("productTypeProperty", "Тип изделия");
        propertyNames.put("productCustomerProperty", "Заказчик");
        propertyNames.put("laboratoryNameProperty", "Лаборатория");

        sortPropertyNames.putAll(Entity.getSortPropertyNames());
        sortPropertyNames.put("laboratoryOrderNumberProperty", "Номер заказа");
        sortPropertyNames.put("productTypeProperty", "Тип изделия");
        sortPropertyNames.put("productCustomerProperty", "Заказчик");
        sortPropertyNames.put("laboratoryNameProperty", "Лаборатория");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }
}
