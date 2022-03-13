package com.credentials.model;

public class Employee {
    public final String firstName;
    public final String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    String getName() {
        return firstName + lastName;
    }

    @Override
    public String toString() {
        return getName();
    }
}
