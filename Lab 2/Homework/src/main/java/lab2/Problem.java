package lab2;

import java.util.Random;

/**
 * Clasa Problem reprezinta o problema de rutare a vehiculelor.
 * Aceasta clasa defineste o problema de rutare a vehiculelor care implica depozite, vehicule,
 * clienti si distanțe intre acestia.
 */

public class Problem {
    private Depot[] depots;
    private Vehicle[] vehicles;
    private Client[] clients;
    private int[][] distances;

    /**
     * Constructorul implicit al clasei Problem.
     */
    public Problem() {
        this.vehicles = new Vehicle[0];
        this.clients = new Client[0];
        this.depots = new Depot[0];
        this.distances = new int[0][0];
    }

    /**
     * Constructorul clasei Problem cu parametri.
     *
     * @param depots    Lista de depozite.
     * @param vehicles  Lista de vehicule.
     * @param clients   Lista de clienti.
     * @param distances Matricea distantelor.
     */
    public Problem(Depot[] depots, Vehicle[] vehicles, Client[] clients, int[][] distances) {
        this.depots = depots;
        this.vehicles = vehicles;
        this.clients = clients;
        this.distances = distances;
    }

    /**
     * Metoda pentru obtinerea listei de depozite.
     *
     * @return Lista de depozite.
     */
    public Depot[] getDepots() {
        return depots;
    }

    /**
     * Metoda pentru setarea listei de depozite.
     *
     * @param depots Lista de depozite.
     */
    public void setDepots(Depot[] depots) {
        this.depots = depots;
    }

    // Metode pentru obtinerea si setarea listei de vehicule si clienti
    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    public int[][] getDistances() {
        return distances;
    }

    public void setDistances(int[][] distances) {
        this.distances = distances;
    }

    // Metode pentru adaugarea de depozite, vehicule si clienti
    public void addDepot(Depot depot) {
        if (this.depots == null) {
            this.depots = new Depot[1];
            this.depots[0] = depot;
        } else {
            for (Depot d : depots) {
                if (d.equals(depot)) {
                    System.out.println("Depot " + depot.getName() + " already exists in the problem.");
                    return;
                }
            }
            Depot[] newDepots = new Depot[depots.length + 1];
            for (int i = 0; i < depots.length; i++) {
                newDepots[i] = depots[i];
            }
            newDepots[depots.length] = depot;
            this.depots = newDepots;
        }
    }

    public void addVehicle(Vehicle vehicle) {
        if (this.vehicles == null) {
            this.vehicles = new Vehicle[1];
            this.vehicles[0] = vehicle;
        } else {
            for (Vehicle v : vehicles) {
                if (v.equals(vehicle)) {
                    System.out.println("Vehicle " + vehicle.getName() + " already exists in the problem.");
                    return;
                }
            }

            Vehicle[] newVehicles = new Vehicle[vehicles.length + 1];
            for (int i = 0; i < vehicles.length; i++) {
                newVehicles[i] = vehicles[i];
            }
            newVehicles[vehicles.length] = vehicle;
            this.vehicles = newVehicles;
        }
    }

    public void addClient(Client client) {
        if (this.clients == null) {
            this.clients = new Client[1];
            this.clients[0] = client;
        } else {
            for (Client c : clients) {
                if (c.equals(client)) {
                    System.out.println("Client " + client.getName() + " already exists in the problem.");
                    return;
                }
            }
            Client[] newClients = new Client[clients.length + 1];
            for (int i = 0; i < clients.length; i++) {
                newClients[i] = clients[i];
            }
            newClients[clients.length] = client;
            this.clients = newClients;
        }
    }

    public Vehicle[] getVehicles2() {
        Vehicle[] allVehicles = new Vehicle[0];
        for (Depot d : depots) {
            for (Vehicle v : d.getVehicles()) {
                Vehicle[] newVehicles = new Vehicle[allVehicles.length + 1];
                for (int i = 0; i < allVehicles.length; i++) {
                    newVehicles[i] = allVehicles[i];
                }
                newVehicles[allVehicles.length] = v;
                allVehicles = newVehicles;
            }
        }
        return allVehicles;
    }

    // Metode pentru initializarea si generarea aleatorie a distantelor intre locatii
    public void initializeDistances() {
        int n = depots.length + clients.length;
        distances = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = 0;
            }
        }
    }

    public void generateRandomDistances() {
        Random random = new Random();
        int n = depots.length + clients.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < i) {
                    distances[i][j] = random.nextInt(100);
                    distances[j][i] = distances[i][j];
                }
            }
        }
    }

    // Metoda pentru afisarea distantelor intre locatii
    public void printDistances() {
        for (int i = 0; i < depots.length; i++) {
            System.out.print("\t" + depots[i].getName());
        }
        for (int i = 0; i < clients.length; i++) {
            System.out.print("\t" + clients[i].getName());
        }
        System.out.println();
        for (int i = 0; i < distances.length; i++) {
            if (i < depots.length) {
                System.out.print(depots[i].getName() + "\t");
            } else {
                System.out.print(clients[i - depots.length].getName() + "\t");
            }
            for (int j = 0; j < distances[i].length; j++) {
                System.out.print(distances[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Metoda pentru rezolvarea problemei de rutare a vehiculelor
    public Solution solve() {
        Solution s = new Solution();
        boolean[] visited = new boolean[clients.length];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < depots.length; i++) {
            Depot d = depots[i];
            Vehicle[] vehicles = d.getVehicles();
            for (int j = 0; j < vehicles.length; j++) {
                Vehicle v = vehicles[j];
                Tour t = new Tour();
                t.setVehicle(v);
                t.addLocation(d, i);
                s.addTour(t);
            }
        }

        while (true) {
            boolean allVisited = true;
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    allVisited = false;
                    break;
                }
            }
            if (allVisited) {
                break;
            }

            for (int i = 0; i < s.getTours().length; i++) {
                Tour t = s.getTours()[i];
                Vehicle v = t.getVehicle();
                Depot d = v.getDepot();
                int[] indexes = t.getIndexes();
                Object[] locations = t.getLocations();
                int lastIndex = indexes[indexes.length - 1];
                int minDistance = Integer.MAX_VALUE;
                int minIndex = -1;

                for (int j = 0; j < clients.length; j++) {
                    if (!visited[j]) {
                        int distance = distances[lastIndex][depots.length + j];
                        if (distance < minDistance) {
                            minDistance = distance;
                            minIndex = j;
                        }
                    }
                }

                if (minIndex != -1) {
                    visited[minIndex] = true;
                    t.addLocation(clients[minIndex], minIndex + depots.length);
                    t.addCost(minDistance);
                }

            }

        }
        return s;
    }
}