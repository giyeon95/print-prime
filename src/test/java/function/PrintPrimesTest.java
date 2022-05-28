package function;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrintPrimesTest {

    private PrintStream out;

    @BeforeEach
    void init() throws FileNotFoundException {
        out = System.out;
        System.setOut(new PrintStream(new FileOutputStream("lead")));
    }

    @AfterEach
    void tearDown() {
        System.setOut(out);
        new File("lead").delete();
    }


    @Test
    void makeSureMatchesGold() throws IOException {
        new PrintPrimes().main(new String[0]);
        BufferedReader lead = new BufferedReader(new FileReader("lead"));
        BufferedReader gold = new BufferedReader(new FileReader("src/test/java/function/gold"));

        String line;
        while ((line = gold.readLine()) != null) {
            assertEquals(line, lead.readLine());
        }
        assertNull(lead.readLine());
    }
}
