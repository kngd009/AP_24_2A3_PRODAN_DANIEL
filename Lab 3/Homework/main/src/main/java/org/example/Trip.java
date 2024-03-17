package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;

class Trip {
    final private String city;
    final private LocalDate openingTime;
    final private LocalDate closingTime;
    final private List<Attraction> attractions;

    public Trip(String city, String openingTime, String closingTime) {
        this.city = city;
        this.openingTime = LocalDate.parse(openingTime);
        this.closingTime = LocalDate.parse(closingTime);
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public LocalDate getOpeningTime() {
        return openingTime;
    }

    public LocalDate getClosingTime() {
        return closingTime;
    }

    public String getCityName() {
        return city;
    }

    public void displayVisitableNotPayable() {
        TreeSet<Visitable> visitableNotPayable = new TreeSet<>((opening1, opening2) -> {
            String open1 = opening1.getSchedule();
            String open2 = opening2.getSchedule();
            if (open1 == null && open2 == null) {
                return 0;
            } else if (open1 == null) {
                return 1;
            } else if (open2 == null) {
                return -1;
            } else {
                return open1.compareTo(open2);
            }
        });

        for (Attraction attraction : attractions) {
            if (attraction instanceof Visitable && !(attraction instanceof Payable)) {
                visitableNotPayable.add((Visitable) attraction);
            }
            if (attraction instanceof Visitable && attraction instanceof Payable) {
                double ticketPrice = ((Payable) attraction).getTicketPrice();
                if (ticketPrice == 0.0) {
                    visitableNotPayable.add((Visitable) attraction);
                }
            }
        }

        System.out.println("What locations can you visit in " + getCityName() + " without paying anything!");
        for (Visitable visitable : visitableNotPayable) {
            System.out.println(((Attraction) visitable).getAttractionName() + " ---> " + visitable.getSchedule());
        }
    }

    public void printAttractions() {
        System.out.println("What attractions are there in " + getCityName() + ":");

        for (Attraction attraction : attractions) {
            System.out.print(attraction.getAttractionType() + " ---> " + attraction.getAttractionName());
            if (attraction instanceof Visitable) {
                System.out.println();
                Map<LocalDate, TimeInterval> timetable = ((Visitable) attraction).getTimetable();
                if (timetable != null) {
                    for (Map.Entry<LocalDate, TimeInterval> entry : timetable.entrySet()) {
                        System.out.println("Date: " + entry.getKey() + ", starts from " + entry.getValue().open() + " to " + entry.getValue().close());
                    }
                } else {
                    System.out.println("Sorry, there was a problem displaying the timetable...");
                }
            }
            if (attraction instanceof Payable) {
                System.out.print("How much is the ticket? ");
                int ticketPrice = ((Payable) attraction).getTicketPrice();
                System.out.println("Just " + ticketPrice + " lei");
            }
            if (attraction instanceof Game) {
                Game game = (Game) attraction;
                System.out.println("What game: " + game.getGameType());
                System.out.println("Who are playing: " + game.whoIsFirst() + " vs " + game.whoIsSecond());
            }
            System.out.println();
        }
    }
}
