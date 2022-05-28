package function;

public class PrintPrimes {

    private static final int NUMBER_OF_PRIMES = 1000;

    public void main(String[] args) {
        int[] primeNumbers = new PrimeGenerator().generatePrimeNumber(NUMBER_OF_PRIMES);
        new NumberPrinter().print(NUMBER_OF_PRIMES, primeNumbers);

    }

    public class PrimeGenerator {

        private static final int ordmax = 30;

        private int candidate = 1;
        private int ord = 2;
        private int square = 9;
        private int[] primes;
        private int[] multiples;


        private int[] generatePrimeNumber(final int numberOfPrimes) {

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

    private class NumberPrinter {

        private void print(int numberOfPrimes, int[] numbers) {
            int pagenumber = 1;
            int pageoffset = 1;
            int linesPerPage = 50;
            int columns = 4;

            while (pageoffset <= numberOfPrimes) {
                System.out.println("The First " + numberOfPrimes + " Prime Numbers --- Page " + pagenumber);
                System.out.println();

                for (int rowoffset = pageoffset; rowoffset < pageoffset + linesPerPage; rowoffset++) {
                    for (int column = 0; column < columns; column++) {
                        if (rowoffset + column * linesPerPage <= numberOfPrimes) {
                            System.out.format("%10d", numbers[rowoffset + column * linesPerPage]);
                        }
                    }
                    System.out.println();
                }
                System.out.println("\f");
                pagenumber = pagenumber + 1;
                pageoffset = pageoffset + linesPerPage * columns;
            }
        }
    }
}
