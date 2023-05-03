package app.model;

import app.utils.LocalDateFormatter;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class OrderTest extends Entity {
    private LaboratoryOrder laboratoryOrder = new LaboratoryOrder();
    private Test test = new Test();
    private Date testingDate;

    private String productProperty;
    private String laboratoryProperty;
    private String testProperty;
    private String testingDateProperty;

    @Override
    public OrderTest clone() {
        var clone = (OrderTest) super.clone();
        clone.setTest(test.clone());
        clone.setLaboratoryOrder(laboratoryOrder.clone());
        return clone;
    }

    @Override
    public void calculateProperties() {
        super.calculateProperties();
        laboratoryOrder.calculateProperties();
        test.calculateProperties();
        if (laboratoryOrder != null) {
            productProperty = laboratoryOrder.getProduct().getId() + " " + laboratoryOrder.getProduct().getCustomer();
            laboratoryProperty = laboratoryOrder.getLaboratory().getLaboratoryName();
        }
        if (test != null) testProperty = test.getTesterNameProperty() + " " + test.getEquipmentSerialNumberProperty();
        if (testingDate != null) testingDateProperty = LocalDateFormatter.getFormattedDateTime(testingDate);
    }

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("productProperty", "Продукт");
        propertyNames.put("laboratoryProperty", "Лаборатория");
        propertyNames.put("testProperty", "Тест");
        propertyNames.put("testingDateProperty", "Дата тестирования");

        sortPropertyNames.putAll(Entity.getPropertyNames());
        sortPropertyNames.put("productProperty", "Продукт");
        sortPropertyNames.put("laboratoryProperty", "Лаборатория");
        sortPropertyNames.put("testProperty", "Тест");
        sortPropertyNames.put("testingDateProperty", "Дата тестирования");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }

}
