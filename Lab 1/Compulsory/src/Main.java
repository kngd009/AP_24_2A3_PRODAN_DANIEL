public class Main {
    public static int sumanr(int result) {

        int suma = 0;
        while (result != 0) {
            suma += result % 10;
            result = result / 10;
        }

        if (suma > 9) {
            return sumanr(suma);
        } else {
            return suma;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        int result = n * 3;
        result = result + 0b10101;
        result = result + 0xFF;
        result = result * 6;
        int a = sumanr(result);
        System.out.println(a);
        System.out.println("Willy-nilly, this semester I will learn " + languages[a]);
    }
}