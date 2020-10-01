package entities;

import java.util.UUID;

public abstract class Employee {
    private UUID id;
    private String name;
    private int age;

    public Employee() {
    }

    public Employee(String name, int age){
        this.name = name;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                '}';
    }
}