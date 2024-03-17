package org.example;

import java.time.LocalTime;

public class TimeInterval extends Pair<LocalTime, LocalTime> {
    public TimeInterval(LocalTime open, LocalTime close) {
        super(open, close);
    }
}