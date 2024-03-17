package org.example;

import java.time.LocalDate;
import java.util.Map;

class Statue extends Attraction implements Visitable {
    final private String description;

    public Statue(String name, String description) {
        super(name, "Statue");
        if (description == null) {
            this.description = "There is no description!";
        } else {
            this.description = description;
        }
    }

    @Override
    public String getSchedule() {
        return "You can visit the statue 24/7";
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return null;
    }
}