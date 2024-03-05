public class Depot {
    private String name;
    private Vehicle[] cars;

    public Depot() {
        this.name = "Default Depot Name";
    }

    public Depot(String depot) {
        this.name = depot;
    }

    public Depot(String depot, Vehicle[] cars) {
        this.name = depot;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String depot) {
        this.name = depot;
    }

    public Vehicle[] getVehicles() {
        return cars;
    }

    public void setVehicles(Vehicle... cars) {
        this.cars = cars;
        for (Vehicle masina : cars) {
            masina.setDepot(this);
        }
    }
@Override
    public String toString() {
        return "Depot name " + name;
    }
}
