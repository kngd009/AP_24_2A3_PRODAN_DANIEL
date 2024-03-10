package lab2;

/**
 * Clasa Tour reprezinta un tur asociat unui vehicul in cadrul unei solutii pentru problema de rutare a vehiculelor.
 * Aceasta clasa defineste un tur care poate contine o serie de locatii si un vehicul asociat.
 */

public class Tour {
    private Vehicle vehicle;
    private Object[] locations;
    private int[] Indexes;
    private int totalCost;

    /**
     * Constructorul implicit al clasei Tour.
     */
    public Tour() {
        this.vehicle = null;
        this.locations = null;
        this.Indexes = null;
        this.totalCost = 0;
    }

    /**
     * Constructorul clasei Tour cu doi parametri: vehicul și locații.
     * @param vehicle Vehiculul asociat turului.
     * @param locations Locațiile turului.
     */
    public Tour(Vehicle vehicle, Object[] locations) {
        this.vehicle = vehicle;
        this.locations = locations;
        this.totalCost = 0;
    }

    /**
     * Constructorul clasei Tour cu trei parametri: vehicul, locatii și indexuri.
     * @param vehicle Vehiculul asociat turului.
     * @param locations Locatiile turului.
     * @param Indexes Indexurile locațiilor.
     */
    public Tour(Vehicle vehicle, Object[] locations, int[] Indexes) {
        this.vehicle = vehicle;
        this.locations = locations;
        this.Indexes = Indexes;
        this.totalCost = 0;
    }

    /**
     * Metoda pentru obtinerea vehiculului asociat turului.
     * @return Vehiculul asociat turului.
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Metoda pentru setarea vehiculului asociat turului.
     * @param vehicle Vehiculul asociat turului.
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Metoda pentru obținerea locațiilor turului.
     * @return Locatiile turului.
     */
    public Object[] getLocations() {
        return locations;
    }

    /**
     * Metoda pentru setarea locațiilor turului.
     * @param locations Locatiile turului.
     */
    public void setLocations(Object... locations) {
        this.locations = locations;
    }

    /**
     * Metoda pentru obtinerea costului total al turului.
     * @return Costul total al turului.
     */
    public int getTotalCost() {
        return totalCost;
    }

    /**
     * Metoda pentru setarea costului total al turului.
     * @param totalCost Costul total al turului.
     */
    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Metoda pentru obtinerea indexurilor locațiilor turului.
     * @return Indexurile locatiilor turului.
     */
    public int[] getIndexes() {
        return Indexes;
    }

    /**
     * Metoda pentru setarea indexurilor locațiilor turului.
     * @param Indexes Indexurile locatiilor turului.
     */
    public void setIndexes(int[] Indexes) {
        this.Indexes = Indexes;
    }

    /**
     * Metoda pentru scaderea costului din costul total al turului.
     * @param cost Costul care urmeaza sa fie scazut.
     */
    public void subtractCost(int cost) {
        totalCost -= cost;
    }

    /**
     * Metoda pentru adaugarea costului la costul total al turului.
     * @param cost Costul care urmeaza să fie adaugat.
     */
    public void addCost(int cost) {
        totalCost += cost;
    }

    /**
     * Metoda pentru adaugarea unei locatii si a indexului corespunzator in tur.
     * @param location Locatia care urmeaza să fie adaugata.
     * @param index Indexul locatiei.
     */
    public void addLocation(Object location, int index) {
        if (locations == null) {
            locations = new Object[1];
            locations[0] = location;
            Indexes = new int[1];
            Indexes[0] = index;
        } else {
            Object[] newLocations = new Object[locations.length + 1];
            int[] newIndexes = new int[Indexes.length + 1];
            System.arraycopy(locations, 0, newLocations, 0, locations.length);
            newLocations[locations.length] = location;
            System.arraycopy(Indexes, 0, newIndexes, 0, Indexes.length);
            newIndexes[Indexes.length] = index;
            Indexes = newIndexes;
            locations = newLocations;
        }
    }

    /**
     * Metoda pentru eliminarea unei locații din tur, pe baza indexului.
     * @param index Indexul locatiei care urmeaza să fie eliminata.
     */
    public void removeLocation(int index) {
        if (index < 0 || index >= locations.length) {
            return;
        }
        Object[] newLocations = new Object[locations.length - 1];
        int[] newIndexes = new int[Indexes.length - 1];
        for (int i = 0; i < index; i++) {
            newLocations[i] = locations[i];
            newIndexes[i] = Indexes[i];
        }
        for (int i = index + 1; i < locations.length; i++) {
            newLocations[i - 1] = locations[i];
            newIndexes[i - 1] = Indexes[i];
        }
        locations = newLocations;
        Indexes = newIndexes;
    }

    /**
     * Override la metoda toString pentru afisarea informatiilor despre tur.
     * @return Informatii despre tur: vehicul si locatii.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Tur cu vehiculul " + vehicle.getName() + " si clienți: ");
        for (Object locatii : locations) {
            str.append(locatii.toString()).append(" ");
        }
        return str.toString();
    }
}
