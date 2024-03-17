package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TravelPlan {
    final private Map<LocalDate, List<Attraction>> plan;

    public TravelPlan() {
        this.plan = new TreeMap<>();
    }

    public void addTrip(Trip trip) {
        LocalDate today = trip.getOpeningTime();
        LocalDate endTrip = trip.getClosingTime();
        while (!today.isAfter(endTrip)) {
            List<Attraction> attractions4Today = new ArrayList<>();
            for (Attraction attraction : trip.getAttractions()) {
                if (attraction instanceof Visitable) {
                    Map<LocalDate, TimeInterval> timetable = ((Visitable) attraction).getTimetable();
                    if (timetable != null && timetable.containsKey(today)) {
                        attractions4Today.add(attraction);
                    }
                }
            }
            plan.put(today, attractions4Today);
            today = today.plusDays(1);
        }
    }

    public void printPlan(Trip trip) {
        System.out.println("What can you visit today in" + trip.getCityName());
        for (Map.Entry<LocalDate, List<Attraction>> entry : plan.entrySet()) {
            LocalDate date = entry.getKey();
            List<Attraction> attractions = entry.getValue();
            if (!attractions.isEmpty()) {
                System.out.println("Today's date: " + date);
                for (Attraction attraction : attractions) {
                    if (attraction instanceof Game) {
                        Game game = (Game) attraction;
                        System.out.println(game.getAttractionName() + ": Watch " + game.whoIsFirst() + " vs " + game.whoIsSecond() + "!");
                    } else
                        System.out.println(attraction.getAttractionName());
                }
            }
        }
        System.out.println("No closing Time:");
        for (Attraction attraction : trip.getAttractions()) {
            boolean isPlanned = false;
            for (List<Attraction> attractions : plan.values()) {
                if (attractions.contains(attraction)) {
                    isPlanned = true;
                    break;
                }
            }
            if (!isPlanned && !(attraction instanceof Visitable && ((Visitable) attraction).getTimetable() != null)) {
                System.out.println(attraction.getAttractionName());
            }
        }

        System.out.println("What you cannot visit:");
        for (Attraction attraction : trip.getAttractions()) {
            boolean isPlanned = false;
            for (List<Attraction> attractions : plan.values()) {
                if (attractions.contains(attraction)) {
                    isPlanned = true;
                    break;
                }
            }
            if (!isPlanned && (attraction instanceof Visitable && ((Visitable) attraction).getTimetable() != null)) {
                System.out.println(attraction.getAttractionName());
            }
        }
    }
}
