package org.lab4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarpoolProblem {

    public List<String> getAllDestinations(List<Driver> drivers) {
        return drivers.stream()
                .map(Driver::getDestination)
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<String, List<Person>> getDestinationMap(List<Person> persons) {
        Map<String, List<Person>> destinationMap = new HashMap<>();
        for (Person person : persons) {
            destinationMap.computeIfAbsent(person.getDestination(), k -> new LinkedList<>()).add(person);
        }
        return destinationMap;
    }
}
