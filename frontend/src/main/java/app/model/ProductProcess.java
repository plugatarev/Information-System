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
public class ProductProcess extends Entity {
    private Product product = new Product();
    private String descriptionWork;
    private Brigade collectingBrigade = new Brigade();
    private ProductStatus status = new ProductStatus();
    private Date releaseDate;

    private String productProperty;
    private String collectingBrigadeProperty;
    private String statusProperty;
    private String releaseDateProperty;

    @Override
    public ProductProcess clone() {
        var clone = (ProductProcess) super.clone();
        clone.setProduct(product.clone());
        clone.setStatus(status.clone());
        clone.setCollectingBrigade(collectingBrigade.clone());
        return clone;
    }


    @Override
    public void calculateProperties() {
        super.calculateProperties();
        if (product != null) productProperty = product.getId() + " " + product.getCategoryType().getName();
        if (collectingBrigade != null) collectingBrigadeProperty = collectingBrigade.getBrigadeName();
        if (status != null) statusProperty = status.getName();
        if (releaseDate != null) releaseDateProperty = LocalDateFormatter.getFormattedDateTime(releaseDate);;
    }

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("productProperty", "Продукт");
        propertyNames.put("collectingBrigadeProperty", "Собирающая бригада");
        propertyNames.put("descriptionWork", "Описание работ");
        propertyNames.put("statusProperty", "Статус");
        propertyNames.put("releaseDateProperty", "Дата окончания");

        sortPropertyNames.putAll(Entity.getPropertyNames());
        sortPropertyNames.put("productProperty", "Продукт");
        sortPropertyNames.put("collectingBrigadeProperty", "Собирающая бригада");
        sortPropertyNames.put("descriptionWork", "Описание работ");
        sortPropertyNames.put("statusProperty", "Статус");
        sortPropertyNames.put("releaseDateProperty", "Дата окончания");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }

}
