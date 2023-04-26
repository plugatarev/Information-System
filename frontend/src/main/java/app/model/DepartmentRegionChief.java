package app.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DepartmentRegionChief extends Employee {

    @Override
    public DepartmentRegionChief clone() {
        return (DepartmentRegionChief) super.clone();
    }
}
