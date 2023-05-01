package app.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter @Setter
public class WorkerBrigade extends Entity {
    private Employee worker = new Employee();
    private Brigade brigade = new Brigade();

    private String workerNameProperty;
    private String brigadeNameProperty;

    @Override
    public WorkerBrigade clone() {
        var clone = (WorkerBrigade) super.clone();
        clone.setWorker(worker.clone());
        clone.setBrigade(brigade.clone());
        return (WorkerBrigade) super.clone();
    }

    @Override
    public void calculateProperties() {
        super.calculateProperties();
        if (worker != null) workerNameProperty = worker.getFirstName() + " " + worker.getSecondName();
        if (brigade != null) brigadeNameProperty = brigade.getBrigadeName();
    }

    private static final Map<String, String> propertyNames = new LinkedHashMap<>();
    private static final Map<String, String> sortPropertyNames = new LinkedHashMap<>();

    static {
        propertyNames.putAll(Entity.getPropertyNames());
        propertyNames.put("workerNameProperty", "Работник");
        propertyNames.put("brigadeNameProperty", "Бригада");

        sortPropertyNames.putAll(Entity.getSortPropertyNames());
        sortPropertyNames.put("workerNameProperty", "Работник");
        sortPropertyNames.put("brigadeNameProperty", "Бригада");
    }

    public static Map<String, String> getPropertyNames() {
        return Collections.unmodifiableMap(propertyNames);
    }

    public static Map<String, String> getSortPropertyNames() {
        return Collections.unmodifiableMap(sortPropertyNames);
    }
}
