package function;

public class PrintPrimes {

    private static final int NUMBER_OF_PRIMES = 1000;

    public void main(String[] args) {
        PrimePrintHelper primePrintHelper = new PrimePrintHelper();
        int[] primeNumbers = primePrintHelper.primeNumbers(NUMBER_OF_PRIMES);
        primePrintHelper.printNumbers(NUMBER_OF_PRIMES, primeNumbers);


    }

    public class PrimePrintHelper {

        private static final int ordmax = 30;

        private int[] primeNumbers(final int numberOfPrimes) {

            int[] primes = new int[numberOfPrimes + 1];
            int[] multiples = new int[ordmax + 1];

            int candidate = 1;
            int primeIndex = 1;
            primes[1] = 2;
            int ord = 2;
            int square = 9;
            while (primeIndex < numberOfPrimes) {
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
                primeIndex = primeIndex + 1;
                primes[primeIndex] = candidate;
            }
            return primes;
        }

        private void printNumbers(int numberOfPrimes, int[] numbers) {
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
