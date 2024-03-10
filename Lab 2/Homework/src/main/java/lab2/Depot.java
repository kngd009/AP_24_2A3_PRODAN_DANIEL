package lab2;

/**
 * Clasa Depot reprezinta un depozit care stocheaza vehicule.
 * Aceasta clasa conține campuri pentru nume si vehiculele din depozit.
 */
public class Depot {
    private String name;
    private Vehicle[] cars;

    /**
     * Constructorul fară parametri pentru clasa Depot.
     * Inițializează numele depozitului cu o valoare prestabilita.
     */
    public Depot() {
        this.name = "Default Depot Name";
    }

    /**
     * Constructorul cu un parametru pentru clasa Depot.
     * @param depot Numele depozitului.
     */
    public Depot(String depot) {
        this.name = depot;
    }

    /**
     * Constructorul cu doi parametri pentru clasa Depot.
     * @param depot Numele depozitului.
     * @param cars Lista de vehicule din depozit.
     */
    public Depot(String depot, Vehicle[] cars) {
        this.name = depot;
        this.cars = cars;
    }

    /**
     * Metoda pentru obținerea numelui depozitului.
     * @return Numele depozitului.
     */
    public String getName() {
        return name;
    }

    /**
     * Metoda pentru setarea numelui depozitului.
     * @param depot Noul nume al depozitului.
     */
    public void setName(String depot) {
        this.name = depot;
    }

    /**
     * Metoda pentru obtinerea vehiculelor din depozit.
     * @return Lista de vehicule din depozit.
     */
    public Vehicle[] getVehicles() {
        return cars;
    }

    /**
     * Metoda pentru setarea vehiculelor din depozit.
     * @param cars Lista de vehicule din depozit.
     */
    public void setVehicles(Vehicle... cars) {
        this.cars = cars;
        for (Vehicle masina : cars) {
            masina.setDepot(this);
        }
    }

    /**
     * Metoda pentru adaugarea unui vehicul in depozit.
     * @param vehicle Vehiculul de adaugat in depozit.
     */
    public void addVehicle(Vehicle vehicle) {
        if (cars == null) {
            cars = new Vehicle[1];
            cars[0] = vehicle;
            vehicle.setDepot(this);
        } else {
            // Dacă vehiculul este deja in depozit, nu l adaug din nou
            for (Vehicle v : cars) {
                if (v.equals(vehicle)) {
                    return;
                }
            }
            Vehicle[] newVehicles = new Vehicle[cars.length + 1];
            for (int i = 0; i < cars.length; i++) {
                newVehicles[i] = cars[i];
            }
            newVehicles[cars.length] = vehicle;
            vehicle.setDepot(this);
            cars = newVehicles;
        }
    }

    /**
     * Override pentru metoda toString().
     * @return String reprezentand informații despre depozit.
     */
    @Override
    public String toString() {
        return "Depot name " + name;
    }

    /**
     * Override pentru metoda equals().
     * @param obiect Obiectul de comparat.
     * @return true dacă obiectele sunt egale, false altfel.
     */
    @Override
    public boolean equals(Object obiect) {
        if (!(obiect instanceof Depot)) {
            return false;
        }
        Depot other = (Depot) obiect;
        return this.name.equals(other.name);
    }
}