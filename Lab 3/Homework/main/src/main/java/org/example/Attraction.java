package org.example;

public abstract class Attraction implements Comparable<Attraction> {
    final private String name;
    final private String type;

    public Attraction(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getAttractionName() {
        return name;
    }

    public String getAttractionType() {
        return type;
    }

    @Override
    public int compareTo(Attraction otherAttraction) {
        return this.name.compareTo(otherAttraction.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
