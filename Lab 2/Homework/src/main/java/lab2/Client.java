package lab2;

import java.time.LocalTime;

/**
 * Clasa Client reprezinta un client al serviciului de livrare.
 * Aceasta clasa contine informatii despre client, inclusiv numele, tipul de client,
 * intervalul orar in care poate primi livrari si alte detalii relevante.
 */


public class Client {
    private String name;
    private LocalTime minTime;
    private LocalTime maxTime;
    private Type type;

    /**
     * Constructorul implicit al clasei Client.
     */
    public Client() {
    }

    /**
     * Constructorul clasei Client cu un parametru pentru nume.
     *
     * @param name Numele clientului.
     */
    public Client(String name) {
        this.name = name;
        this.minTime = null;
        this.maxTime = null;
    }

    /**
     * Constructorul clasei Client cu doi parametri pentru nume si tip.
     *
     * @param name Numele clientului.
     * @param type Tipul clientului.
     */
    public Client(String name, Type type) {
        this.name = name;
        this.type = type;
        this.minTime = null;
        this.maxTime = null;
    }

    /**
     * Constructorul clasei Client cu patru parametri pentru nume, tip si timp minim si maxim de servire.
     *
     * @param name    Numele clientului.
     * @param type    Tipul clientului.
     * @param minTime Timpul minim de servire.
     * @param maxTime Timpul maxim de servire.
     */
    public Client(String name, Type type, LocalTime minTime, LocalTime maxTime) {
        this.name = name;
        this.type = type;
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    /**
     * Constructorul clasei Client cu trei parametri pentru nume, timp minim si maxim de servire.
     *
     * @param name    Numele clientului.
     * @param minTime Timpul minim de servire.
     * @param maxTime Timpul maxim de servire.
     */
    public Client(String name, LocalTime minTime, LocalTime maxTime) {
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    /**
     * Metoda pentru obtinerea tipului clientului.
     *
     * @return Tipul clientului.
     */
    public Type getType() {
        return type;
    }

    /**
     * Metoda pentru setarea tipului clientului.
     *
     * @param type Tipul clientului.
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Metoda pentru obtinerea numelui clientului.
     * @return name Numele clientului.
     */
    public String getName() {
        return name;
    }

    /**
     * Metoda pentru setarea numelui clientului.
     *
     * @param name Numele clientului.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metoda pentru obtinerea timpului minim de servire.
     *
     * @return Timpul minim de servire.
     */
    public LocalTime getMinTime() {
        return minTime;
    }

    /**
     * Metoda pentru setarea timpului minim de servire.
     *
     * @param minTime Timpul minim de servire.
     */
    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }

    /**
     * Metoda pentru obtinerea timpului maxim de servire.
     *
     * @return Timpul maxim de servire.
     */
    public LocalTime getMaxTime() {
        return maxTime;
    }

    /**
     * Metoda pentru setarea timpului maxim de servire.
     *
     * @param maxTime Timpul maxim de servire.
     */
    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }

    /**
     * Metoda pentru reprezentarea textuala a clientului.
     *
     * @return String ce reprezinta numele clientului.
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Metoda pentru verificarea egalitatii intre doi clienti.
     *
     * @param obiect Obiectul de comparat.
     * @return true daca clientii sunt egali, false in caz contrar.
     */
    @Override
    public boolean equals(Object obiect) {
        if (!(obiect instanceof Client)) {
            return false;
        }
        Client other = (Client) obiect;
        return this.name.equals(other.name);
    }

    enum Type {
        REGULAR,
        PREMIUM
    }
}
