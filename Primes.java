public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int amountOfPrimes = 0;
        if (n >= 2) {
            System.out.println(2);
            amountOfPrimes++;
        }

        int i = 3;

        while (i <= n) {

            boolean isPrime = true;

            int d = 3;
            while (d * d <= i) {
                if (i % d == 0) {
                    isPrime = false;
                    break;
                }
                d += 2;
            }

            if (isPrime) {
                System.out.println(i);
                amountOfPrimes++;
            }

            i += 2;
        }

        double percent = 100.0 * amountOfPrimes / n;

        System.out.println("There are " + amountOfPrimes + " primes between 2 and " + n +
                " (" + (int) percent + "% are primes)");
    }
}
