package app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
public class Laboratory extends Entity {
    private String laboratoryName;

    @Override
    public Laboratory clone() {
        return (Laboratory) super.clone();
    }

    @Override
    public void calculateProperties() {
        super.calculateProperties();
    }

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("laboratoryName", "Название лаборатории");

        sortPropertyNames.putAll(Entity.getSortPropertyNames());
        sortPropertyNames.put("laboratoryName", "Название лаборатории");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }

}
