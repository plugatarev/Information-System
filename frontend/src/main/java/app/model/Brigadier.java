package app.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Brigadier extends Employee {
    @Override
    public Brigadier clone() {
        return (Brigadier) super.clone();
    }
}
