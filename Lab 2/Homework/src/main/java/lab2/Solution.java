
package lab2;

/**
 * Clasa Solution reprezinta o solutie pentru problema de rutare a vehiculelor.
 * Aceasta clasa defineste o solutie care contine unul sau mai multe tururi in cadrul unei probleme de rutare a vehiculelor.
 */
public class Solution {
    private Tour[] tours;

    /**
     * Constructorul implicit al clasei Solution.
     */
    public Solution() {
        this.tours = new Tour[0];
    }

    /**
     * Constructorul clasei Solution cu un parametru pentru tururi.
     * @param tours Tururile soluției.
     */
    public Solution(Tour[] tours) {
        this.tours = tours;
    }

    /**
     * Metoda pentru obtinerea tururilor din solutie.
     * @return Tururile solutiei.
     */
    public Tour[] getTours() {
        return tours;
    }

    /**
     * Metoda pentru setarea tururilor din solutie.
     * @param tours Tururile solutiei.
     */
    public void setTours(Tour[] tours) {
        this.tours = tours;
    }

    /**
     * Metoda pentru adaugarea unui tur în solutie.
     * @param tour Turul care urmeaza sa fie adaugat.
     */
    public void addTour(Tour tour) {
        if (tours == null) {
            tours = new Tour[1];
            tours[0] = tour;
        } else {
            Tour[] newTours = new Tour[tours.length + 1];
            for (int i = 0; i < tours.length; i++) {
                newTours[i] = tours[i];
            }
            newTours[tours.length] = tour;
            tours = newTours;
        }
    }

    /**
     * Metoda pentru eliminarea unui tur din solutie, pe baza indexului.
     * @param index Indexul turului care urmeaza sa fie eliminat.
     */
    public void removeTour(int index) {
        if (index < 0 || index >= tours.length) {
            return;
        }
        Tour[] newTours = new Tour[tours.length - 1];
        for (int i = 0; i < index; i++) {
            newTours[i] = tours[i];
        }
        for (int i = index + 1; i < tours.length; i++) {
            newTours[i - 1] = tours[i];
        }
        tours = newTours;
    }

    /**
     * Override la metoda toString pentru afisarea informatiilor despre solutie.
     * @return Informatii despre solutie: tururi.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Solutie cu urmatoarele tururi: \n");
        for (Tour tururi : tours) {
            str.append(tururi.toString()).append("\n");
        }
        return str.toString();
    }
}
