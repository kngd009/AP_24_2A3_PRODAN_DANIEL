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
    }
}