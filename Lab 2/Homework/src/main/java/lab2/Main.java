package lab2;

import java.time.LocalTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Client client1 = new Client();
        client1.setName("Dan");
        client1.setMinTime(LocalTime.of(8, 0));
        client1.setMaxTime(LocalTime.of(12, 30));
        System.out.println("Numele primululi client este: " + client1.getName());

        Client client2 = new Client("Andrei");
        client2.setMinTime(LocalTime.of(6, 0));
        client2.setMaxTime(LocalTime.of(14, 30));
        System.out.println("Numele clientului 2 este: " + client2.getName()); //toString()
        System.out.println("c2.getMinTime() = " + client2.getMinTime());
        System.out.println("c2.getMaxTime() = " + client2.getMaxTime());

        Client client3 = new Client("Alex", Client.Type.REGULAR);
        Client client4 = new Client("Cosmin", Client.Type.PREMIUM, LocalTime.of(10, 0), LocalTime.of(14, 0) );

        System.out.println("Numele clientului 4 este: " + client4.getName());
        System.out.println("Clientul 4 este: " + client4.getType());
        System.out.println("c4.getMinTime() = " + client4.getMinTime());
        System.out.println("c4.getMaxTime() = " + client4.getMaxTime());

        Vehicle car1 = new Vehicle("BMW");
        Depot depot1 = new Depot();
        Vehicle car2 = new Vehicle("Mercedes");
        Vehicle car3 = new Vehicle("Mazda", depot1);

        depot1.setVehicles(car1);
        System.out.println("Vehicolul 1 este: " + car1.getName());
        System.out.println("Numele depozitului este: " + depot1.getName());

        depot1.setVehicles(car1, car2, car3);


        Problem problema1 = new Problem();

        Client clientul0 = new Client("Clientul0");
        Client clientul1 = new Client("Clientul1");
        Client clientul2 = new Client("Clientul2");
        Client clientul3 = new Client("Clientul3");
        Client clientul4 = new Client("Clientul4");
        Client clientul5 = new Client("Clientul5");
        Client clientul6 = new Client("Clientul6");
        Client clientul7 = new Client("Clientul7");
        Client clientul8 = new Client("Clientul8");

        problema1.setClients(new Client[] { clientul0, clientul1, clientul2, clientul3, clientul4, clientul5, clientul6, clientul7, clientul8 });

        Depot depou0 = new Depot("Depou0");
        Depot depou1 = new Depot("Depou1");
        Depot depou2 = new Depot("Depou2");

        Vehicle masina0 = new Truck("Masina0");
        Vehicle masina1 = new Drone("Masina1");
        Vehicle masina2 = new Drone("Masina2");
        Vehicle masina3 = new Drone("Masina3");
        Vehicle masina4 = new Drone("Masina4");

        depou0.addVehicle(masina0);

        depou1.addVehicle(masina1);

        depou1.addVehicle(masina2);

        depou2.addVehicle(masina3);

        depou2.addVehicle(masina4);

        problema1.addDepot(depou0);
        problema1.addDepot(depou1);
        problema1.addDepot(depou2);


        Vehicle[] result = problema1.getVehicles2();
        System.out.println("Vehicule in problema1: ");
        for (Vehicle masini : result) {
            System.out.println(masini.getName());
        }

        problema1.initializeDistances();
        problema1.generateRandomDistances();
        problema1.printDistances();

        Solution solutia = problema1.solve();

        System.out.println(solutia);
    }
}