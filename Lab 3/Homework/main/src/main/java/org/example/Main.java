package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //First game:
        Game game = new Game("Champions League", Game.GameName.FOOTBALL, "FC Barcelona", "Bayern Munich");
        game.addTimeSlot(LocalDate.of(2024, 3, 18), LocalTime.of(13, 0), LocalTime.of(14, 30));
        game.setTicketPrice(1000);


        //Statue
        Statue statue = new Statue("Mihai Vitezul", "Statuia lui Mihai Viteazul din București este o statuie ecvestră din Piața Universității, operă a sculptorului francez Albert-Ernest Carrier-Belleuse (1824-1887) și este primul monument de această factură din Capitală.");


        //Concert
        Concert concert = new Concert("Neversea 2024");
        concert.addTimeSlot(LocalDate.of(2024, 3, 18), LocalTime.of(0, 0), LocalTime.of(22, 0));
        concert.setTicketPrice(800);

        //Church
        Church church = new Church("Biserica din Densus");
        Map<LocalDate, TimeInterval> churchTimetable = new HashMap<>();
        churchTimetable.put(LocalDate.of(2024, 3, 18), new TimeInterval(LocalTime.of(5, 0), LocalTime.of(22, 0)));
        church.setTimetable(churchTimetable);


        Trip trip = new Trip("Iasi", "2024-03-18", "2024-03-19");
        trip.addAttraction(game);
        trip.addAttraction(statue);
        trip.addAttraction(concert);
        trip.addAttraction(church);

        trip.printAttractions();
        trip.displayVisitableNotPayable();
        System.out.println();

        TravelPlan travelPlan = new TravelPlan();
        travelPlan.addTrip(trip);
        travelPlan.printPlan(trip);
    }
}
