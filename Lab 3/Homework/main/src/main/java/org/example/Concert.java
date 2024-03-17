package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Concert extends Attraction implements Visitable, Payable {
    private Map<LocalDate, TimeInterval> timetable;
    private int ticketPrice;

    public Concert(String name) {
        super(name, "Concert");
        this.timetable = new HashMap<>();
    }

    @Override
    public String getSchedule() {
        LocalDate date = timetable.keySet().iterator().next();
        TimeInterval timeInterval = timetable.get(date);
        return "The concert starts from " + timeInterval.open() + " to " + timeInterval.close();
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return timetable;
    }

    public void setTimetable(Map<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }

    public void addTimeSlot(LocalDate date, LocalTime startTime, LocalTime endTime) {
        timetable.put(date, new TimeInterval(startTime, endTime));
    }

    @Override
    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}