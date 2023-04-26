package app.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DepartmentChief extends Employee {

    @Override
    public DepartmentChief clone() {
        return (DepartmentChief) super.clone();
    }
}
