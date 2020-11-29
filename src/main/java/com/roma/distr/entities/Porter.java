package com.roma.distr.entities;

public class Porter extends Employee {

    public Porter(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Porter{" +
                "name='" + super.getName() + '\'' +
                ", age='" + super.getAge() + '\'' +
                '}';
    }
}
