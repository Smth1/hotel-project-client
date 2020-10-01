package entities;

public class Cashier extends Employee {

    public Cashier(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "name='" + super.getName() + '\'' +
                '}';
    }
}
