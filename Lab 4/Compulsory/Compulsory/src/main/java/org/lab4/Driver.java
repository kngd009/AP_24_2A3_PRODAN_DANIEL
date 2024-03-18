package org.lab4;

public class Driver extends Person {
    public Driver(String name, int age, String destination) {
        super(name, age, destination);
    }

    @Override
    public String toString() {
        return "Driver's name: " + getName() + ", age -> " + getAge() + ", destination -> " + getDestination();
    }
}