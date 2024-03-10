package lab2;

/**
 * Clasa Vehicle reprezinta un vehicul.
 * Aceasta clasa defineste caracteristicile generale ale unui vehicul, cum ar fi numele si depozitul asociat.
 */
public class Vehicle {
    private Depot depot;
    private String name;

    /**
     * Constructorul implicit al clasei Vehicle.
     */
    public Vehicle() {
    }

    /**
     * Constructorul clasei Vehicle cu un parametru pentru nume.
     *
     * @param name Numele vehiculului.
     */
    public Vehicle(String name) {
        this.name = name;
    }

    /**
     * Constructorul clasei Vehicle cu doi parametri pentru nume si depozit.
     *
     * @param name  Numele vehiculului.
     * @param depot Depozitul asociat vehiculului.
     */
    public Vehicle(String name, Depot depot) {
        this.name = name;
        this.depot = depot;
    }

    /**
     * Metoda pentru obtinerea numelui vehiculului.
     *
     * @return Numele vehiculului.
     */
    public String getName() {
        return name;
    }

    /**
     * Metoda pentru setarea numelui vehiculului.
     *
     * @param name Numele vehiculului.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metoda pentru obținerea depozitului asociat vehiculului.
     *
     * @return Depozitul asociat vehiculului.
     */
    public Depot getDepot() {
        return depot;
    }

    /**
     * Metoda pentru setarea depozitului asociat vehiculului.
     *
     * @param depot Depozitul asociat vehiculului.
     */
    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    /**
     * Metoda pentru reprezentarea textuala a vehiculului.
     *
     * @return String ce descrie detaliile vehiculului.
     */
    @Override
    public String toString() {
        return "Vehicle name: " + name + "', depot: " + depot.getName();
    }
}
