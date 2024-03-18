package org.lab4;

public class Passenger extends Person implements Comparable<Passenger> {
    public Passenger(String name, int age, String destination) {
        super(name, age, destination);
    }

    @Override
    public String toString() {
        return "Passenger's name: " + getName() + ", age -> " + getAge() + ", destination -> " + getDestination();
    }

    @Override
    public int compareTo(Passenger otherPassenger) {
        return this.getName().compareTo(otherPassenger.getName());
    }
}