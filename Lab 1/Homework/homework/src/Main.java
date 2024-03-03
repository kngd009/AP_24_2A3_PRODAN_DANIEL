
public class Main {
    public static void main(String[] args){

        System.out.println("Mod de utilizare: java Main [a] [b] [k]");

        if (args.length != 3) {
            System.out.println("Introduceti 3 argumente!");
            System.exit(-1);
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        StringBuilder numere = new StringBuilder();
        long start = System.nanoTime();

        for (int i = a; i <= b; i++) {
            int reduced = kReductibil(i);
            if (reduced == k) {
                numere.append(i).append(" ");
            }
        }

        long end = System.nanoTime();
        long time = (end - start) / 1000000;  /*Pentru a converti in milisec*/

        System.out.println("Numerele " + k + "-reductibile din intervalul [" + a + ", " + b + "], sunt: ");
        System.out.println(numere.toString().trim());
        System.out.println("Timpul de executie: " + time + " milisecunde");
    }

    public static int kReductibil(int num) {
        int sum = 0;
        while (num > 0) {
            int nr = num % 10;
            sum += nr * nr;
            num /= 10;
        }
        if (sum >= 10) {
            return kReductibil(sum);
        }
        return sum;
    }
}


