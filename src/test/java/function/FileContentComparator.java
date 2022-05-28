package function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.BufferedReader;
import java.io.FileReader;


public class FileContentComparator {
    public void compare() {
        try {
            BufferedReader lead = new BufferedReader(new FileReader("lead"));
            BufferedReader gold = new BufferedReader(new FileReader("src/test/java/function/gold"));
            String line;
            while ((line = gold.readLine()) != null)
                assertEquals(line, lead.readLine());
            assertNull(lead.readLine());
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
