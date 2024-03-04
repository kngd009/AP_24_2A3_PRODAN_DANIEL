import org.omg.CORBA.StringHolder;

import java.time.LocalTime;

public class Client {
    private String name;
    private LocalTime minTime;
    private LocalTime maxTime;
    private Type type;

    public Client() {
    }

    public Client(String name) {
        this.name = name;
        this.minTime = null;
        this.maxTime = null;
    }

    public Client(String name, Type type) {
        this.name = name;
        this.type = type;
        this.minTime = null;
        this.maxTime = null;
    }

    public Client(String name, Type type, LocalTime minTime, LocalTime maxTime) {
        this.name = name;
        this.type = type;
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    public Client(String name, LocalTime minTime, LocalTime maxTime) {
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    // Getters and Setters

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getMinTime() {
        return minTime;
    }

    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }

    public LocalTime getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }

    @Override
    public String toString() {
        return name;
    }

    enum Type {
        REGULAR,
        PREMIUM
    }

}
