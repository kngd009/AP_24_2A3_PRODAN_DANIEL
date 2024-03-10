package lab2;

/**
 * Clasa Drone reprezinta un tip de vehicul specific pentru serviciile de livrare.
 * Aceasta clasa extinde clasa Vehicle si contine informatii suplimentare despre drone,
 * inclusiv durata maxima de zbor si detalii despre depozitul in care se afla.
 */
public class Drone extends Vehicle {
    private int maximumFlightDuration;

    /**
     * Constructorul implicit al clasei Drone.
     */
    public Drone() {
        super();
        maximumFlightDuration = 0;
    }

    /**
     * Constructorul clasei Drone cu un parametru pentru nume.
     *
     * @param name Numele dronei.
     */
    public Drone(String name) {
        super(name);
        maximumFlightDuration = 0;
    }

    /**
     * Constructorul clasei Drone cu doi parametri pentru nume si depozit.
     *
     * @param name  Numele dronei.
     * @param depot Depozitul unde este localizata drona.
     */
    public Drone(String name, Depot depot) {
        super(name, depot);
        maximumFlightDuration = 0;
    }

    /**
     * Constructorul clasei Drone cu trei parametri pentru nume, depozit și durata maxima de zbor.
     *
     * @param name                  Numele dronei.
     * @param depot                 Depozitul unde este localizata drona.
     * @param maximumFlightDuration Durata maxima de zbor a dronei.
     */
    public Drone(String name, Depot depot, int maximumFlightDuration) {
        super(name, depot);
        this.maximumFlightDuration = maximumFlightDuration;
    }

    /**
     * Metoda pentru obtinerea duratei maxime de zbor a dronei.
     *
     * @return Durata maxima de zbor.
     */
    public int getMaximumFlightDuration() {
        return maximumFlightDuration;
    }

    /**
     * Metoda pentru setarea duratei maxime de zbor a dronei.
     *
     * @param maximumFlightDuration Durata maxima de zbor.
     */
    public void setMaximumFlightDuration(int maximumFlightDuration) {
        this.maximumFlightDuration = maximumFlightDuration;
    }

    /**
     * Metoda pentru reprezentarea textuala a dronei.
     *
     * @return String ce descrie detaliile dronei.
     */
    @Override
    public String toString() {
        return "Drone " + getName() + " has maximum flight duration " + maximumFlightDuration + " and is in depot " + getDepot().getName();
    }

    /**
     * Metoda pentru compararea dronei cu un alt obiect.
     *
     * @param obiect Obiectul cu care se compara drona.
     * @return true daca dronele sunt identice, false in caz contrar.
     */
    @Override
    public boolean equals(Object obiect) {
        if (!(obiect instanceof Drone)) {
            return false;
        }
        Drone other = (Drone) obiect;
        return this.getName().equals(other.getName()) && this.maximumFlightDuration == other.maximumFlightDuration;
    }
}
