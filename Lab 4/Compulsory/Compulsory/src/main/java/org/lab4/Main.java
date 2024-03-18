package org.lab4;

import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        LinkedList<Person> persons = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            String name = "Person" + i;

            int age = random.nextInt(40) + 20;
            String destination = "Destination" + random.nextInt(5);
            if (random.nextBoolean()) {
                persons.add(new Driver(name, age, destination));
            } else {
                persons.add(new Passenger(name, age, destination));
            }
        }

        LinkedList<Driver> drivers = persons.stream()
                .filter(person -> person instanceof Driver)
                .map(person -> (Driver) person)
                .collect(Collectors.toCollection(LinkedList::new));

        TreeSet<Passenger> passengers = persons.stream()
                .filter(person -> person instanceof Passenger)
                .map(person -> (Passenger) person)
                .collect(Collectors.toCollection(TreeSet::new));


        System.out.println("Drivers sorted by age:");
        drivers.stream()
                .sorted((d1, d2) -> d1.getAge() - d2.getAge())
                .forEach(System.out::println);

        System.out.println("\nPassengers sorted by name:");
        passengers.forEach(System.out::println);
    }
}
