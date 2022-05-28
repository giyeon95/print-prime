package function;

public class PrimeGenerator {

    private static final int ordmax = 30;

    private int candidate = 1;
    private int ord = 2;
    private int square = 9;
    private int[] primes;
    private int[] multiples;


    public int[] generatePrimeNumber(final int numberOfPrimes) {

        primes = new int[numberOfPrimes + 1];
        multiples = new int[ordmax + 1];

        int primeIndex = 1;
        primes[1] = 2;

        while (primeIndex < numberOfPrimes) {
            findNextPrime();
            primeIndex = primeIndex + 1;
            primes[primeIndex] = candidate;
        }
        return primes;
    }

    private void findNextPrime() {
        boolean possiblyPrime;
        do {
            candidate = candidate + 2;
            if (candidate == square) {
                ord = ord + 1;
                square = primes[ord] * primes[ord];
                multiples[ord - 1] = candidate;
            }
            int n = 2;
            possiblyPrime = true;
            while (n < ord && possiblyPrime) {
                while (multiples[n] < candidate) {
                    multiples[n] = multiples[n] + primes[n] + primes[n];
                }
                if (multiples[n] == candidate) {
                    possiblyPrime = false;
                }
                n = n + 1;
            }
        } while (!possiblyPrime);
    }
}
