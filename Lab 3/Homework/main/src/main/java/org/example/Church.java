package org.example;

import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;

public class Church extends Attraction implements Visitable {
    private Map<LocalDate, TimeInterval> timetable;

    public Church(String name) {
        super(name,"Church");
        this.timetable = new HashMap<>();
    }


    @Override
    public String getSchedule() {
        LocalDate date = timetable.keySet().iterator().next();
        TimeInterval timeInterval = timetable.get(date);
        return "The church is open from:  " + timeInterval.open() + " to " + timeInterval.close();
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return timetable;
    }

    public void setTimetable(Map<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }
}