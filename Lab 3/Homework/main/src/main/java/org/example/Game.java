package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Game extends Attraction implements Visitable, Payable {
    private GameName gameName;
    private String firstTeam;
    private String secondTeam;
    private Map<LocalDate, TimeInterval> timetable;
    private int ticketPrice;

    public Game(String name) {
        super(name, "Game");
        this.timetable = new HashMap<>();
    }

    public Game(String name, GameName gameName, String firstTeam, String secondTeam) {
        super(name, "Game");
        this.gameName = gameName;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.timetable = new HashMap<>();
    }

    public void addTimeSlot(LocalDate date, LocalTime start, LocalTime end) {
        timetable.put(date, new TimeInterval(start, end));
    }

    @Override
    public String getSchedule() {
        LocalDate date = timetable.keySet().iterator().next();
        TimeInterval timeInterval = timetable.get(date);
        return "The game will start at " + timeInterval.open() + " and will end at " + timeInterval.close();
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return timetable;
    }

    @Override
    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public GameName getGameType() {
        return gameName;
    }

    public String whoIsFirst() {
        return firstTeam;
    }

    public String whoIsSecond() {
        return secondTeam;
    }

    public enum GameName {
        FOOTBALL,
        BASKETBALL
    }
}
