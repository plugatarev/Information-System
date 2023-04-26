package app.model;

public class Master extends Employee {
    @Override
    public Master clone() {
        return (Master) super.clone();
    }
}
