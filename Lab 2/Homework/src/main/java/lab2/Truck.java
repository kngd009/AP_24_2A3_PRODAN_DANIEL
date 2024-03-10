package lab2;

/**
 * Clasa Truck reprezinta un camion, o subclasa a clasei Vehicle.
 * Aceasta clasa defineste caracteristicile specifice unui camion, cum ar fi capac  itatea.
 */
public class Truck extends Vehicle {
    private int capacity;

    /**
     * Constructorul implicit al clasei Truck.
     */
    public Truck() {
        super();
        capacity = 0;
    }

    /**
     * Constructorul clasei Truck cu un parametru pentru nume.
     * @param name Numele camionului.
     */
    public Truck(String name) {
        super(name);
        capacity = 0;
    }

    /**
     * Constructorul clasei Truck cu doi parametri pentru nume si depozit.
     * @param name Numele camionului.
     * @param depot Depozitul in care se afla camionul.
     */
    public Truck(String name, Depot depot) {
        super(name, depot);
        capacity = 0;
    }

    /**
     * Constructorul clasei Truck cu trei parametri pentru nume, depozit si capacitate.
     * @param name Numele camionului.
     * @param depot Depozitul in care se afla camionul.
     * @param capacity Capacitatea camionului.
     */
    public Truck(String name, Depot depot, int capacity) {
        super(name, depot);
        this.capacity = capacity;
    }

    /**
     * Metoda pentru obținerea capacitatii camionului.
     * @return Capacitatea camionului.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Metoda pentru setarea capacitatii camionului.
     * @param capacity Noua capacitate a camionului.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Override la metoda toString pentru a afișa informatii despre camion.
     * @return Informatii despre camion: nume, capacitate și depozit.
     */
    @Override
    public String toString() {
        return "Camionul " + getName() + " are capacitatea " + capacity + " și se află în depozitul " + getDepot().getName();
    }

    /**
     * Override la metoda equals pentru compararea a doua obiecte de tip Truck.
     * @param obiect Obiectul de comparat.
     * @return true daca obiectele sunt egale, false in caz contrar.
     */
    @Override
    public boolean equals(Object obiect) {
        if (!(obiect instanceof Truck))
            return false;

        Truck other = (Truck) obiect;
        return this.getName().equals(other.getName()) && this.capacity == other.capacity;
    }
}
