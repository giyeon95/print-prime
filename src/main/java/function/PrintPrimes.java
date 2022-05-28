package function;

public class PrintPrimes {

    private static final int NUMBER_OF_PRIMES = 1000;

    public void main(String[] args) {
        int[] primeNumbers = new PrimeGenerator().generatePrimeNumber(NUMBER_OF_PRIMES);
        new NumberPrinter().print(NUMBER_OF_PRIMES, primeNumbers);

    }

}
