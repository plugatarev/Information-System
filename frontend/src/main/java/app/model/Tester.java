package app.model;

public class Tester extends Employee {

    @Override
    public Tester clone() {
        return (Tester) super.clone();
    }
}
