package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public interface Visitable {
    String getSchedule();

    Map<LocalDate, TimeInterval> getTimetable();

    default LocalTime getOpeningHour(LocalDate date) {
        Map<LocalDate, TimeInterval> timetable = getTimetable();
        TimeInterval timeInterval = timetable.get(date);
        return timeInterval.open();
    }
}
