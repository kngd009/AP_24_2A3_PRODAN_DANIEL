import java.time.LocalTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Client c1 = new Client();
        c1.setName("Dan");
        c1.setMinTime(LocalTime.of(8, 0));
        c1.setMaxTime(LocalTime.of(12, 30));
        System.out.println("Numele primululi client este: " + c1.getName());

        Client c2 = new Client("Andrei");
        c2.setMinTime(LocalTime.of(6, 0));
        c2.setMaxTime(LocalTime.of(14, 30));
        System.out.println("Numele clientului 2 este: " + c2.getName()); //toString()
        System.out.println("c2.getMinTime() = " + c2.getMinTime());
        System.out.println("c2.getMaxTime() = " + c2.getMaxTime());

        Client c3 = new Client("Alex", Client.Type.REGULAR);
        Client c4 = new Client("Cosmin", Client.Type.PREMIUM, LocalTime.of(10, 0), LocalTime.of(14, 0) );

        System.out.println("Numele clientului 4 este: " + c4.getName());
        System.out.println("Clientul 4 este: " + c4.getType());
        System.out.println("c4.getMinTime() = " + c4.getMinTime());
        System.out.println("c4.getMaxTime() = " + c4.getMaxTime());

        Vehicle car1 = new Vehicle("BMW");
        Depot d1 = new Depot();
        Vehicle car2 = new Vehicle("Mercedes");
        Vehicle car3 = new Vehicle("Mazda", d1);

        d1.setVehicles(car1);
        System.out.println("Vehicolul 1 este: " + car1.getName());
        System.out.println("Numele depozitului este: " + d1.getName());

        d1.setVehicles(car1, car2, car3);
        //System.out.println(d1.getVehicles());
    }
}