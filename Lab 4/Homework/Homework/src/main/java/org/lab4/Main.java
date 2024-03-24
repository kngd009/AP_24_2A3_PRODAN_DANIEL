package org.lab4;

import com.github.javafaker.Faker;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();
        Random random = new Random();
        LinkedList<Person> persons = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            String name = faker.name().fullName();
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


        System.out.println("\n==============================Drivers sorted by age:========================================\n");
        drivers.stream()
                .sorted((d1, d2) -> d1.getAge() - d2.getAge())
                .forEach(System.out::println);

        System.out.println("\n==============================Passengers sorted by name:========================================\n");
        passengers.forEach(System.out::println);

        CarpoolProblem carpoolProblem = new CarpoolProblem();

        // list of all destinations that the drivers pass through
        List<String> allDestinations = carpoolProblem.getAllDestinations(drivers);
        System.out.println("\n==============================All destinations that drivers pass through:========================================\n" + allDestinations);

        // map of destinations and people who want to go there
        List<Person> allPersons = new LinkedList<>(drivers);
        allPersons.addAll(passengers);
        System.out.println("\n==============================Map of destinations and people who want to go there:========================================\n");
        Map<String, List<Person>> destinationMap = carpoolProblem.getDestinationMap(allPersons);
        destinationMap.forEach((destination, people) -> {
            System.out.println(destination + " -> " + people);
        });

        Map<Driver, Passenger> matches = new HashMap<>();
        Set<Passenger> unmatchedPassengers = new HashSet<>(passengers);

        for (Driver driver : drivers) {
            String driverDestination = driver.getDestination();
            Passenger bestMatch = null;
            int minDistance = Integer.MAX_VALUE;

            for (Passenger passenger : unmatchedPassengers) {
                if (passenger.getDestination().equals(driverDestination)) {
                    matches.put(driver, passenger);
                    unmatchedPassengers.remove(passenger);
                    break; // only one passenger per driver
                } else {
                    int distance = computeDistance(driverDestination, passenger.getDestination());
                    if (distance < minDistance) {
                        minDistance = distance;
                        bestMatch = passenger;
                    }
                }
            }

            if (bestMatch != null) {
                matches.put(driver, bestMatch);
                unmatchedPassengers.remove(bestMatch);
            }
        }

        System.out.println("\n==============================Matches (Driver -> Passenger):========================================\n");
        for (Map.Entry<Driver, Passenger> entry : matches.entrySet()) {
            System.out.println(entry.getKey().getName() + " -> " + entry.getValue().getName());
        }
        System.out.println("====================================================================================================");
    }
    private static int computeDistance(String destination1, String destination2) {
        Random random = new Random();
        return random.nextInt(100);
    }
}
