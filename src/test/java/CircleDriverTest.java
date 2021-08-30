import com.sun.tools.javac.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CircleDriverTest {

    private PrintStream stdout;
    private ByteArrayOutputStream baos;
    private final PrintStream realSTDOUT = System.out;

    @BeforeEach
    void setStdout() {
        baos = new ByteArrayOutputStream();
        stdout = new PrintStream(baos, true, Charset.defaultCharset());
    }

    private void setupSTDIN(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private void setupSTDOUT(PrintStream printStream) {
        System.setOut(printStream);
    }

    private void resetSTDOUT() {
        System.setOut(realSTDOUT);
    }

    @Test
    void main() {
        setupSTDIN("1");
        setupSTDOUT(stdout);
        CircleDriver.main( new String[]{} );
        resetSTDOUT();

        String data = baos.toString(Charset.defaultCharset());
        String[] splitData = data.split("\\n");
        String output = splitData[1].replaceAll("[\\n\\r]", ""); // Only get the numbers, not the EOL

        assertEquals(output, Double.toString(Math.PI));
    }

    @Test
    void invalidMain() {
        setupSTDIN("A");
        assertThrows(NoSuchElementException.class, () -> CircleDriver.main( new String[]{} ));
    }

    @Test
    void takeInvalidRadius() {

        setupSTDIN("A");
        assertThrows(NoSuchElementException.class, CircleDriver::takeRadius);
    }

    @Test
    void takeRadius() {

        setupSTDIN("1");
        assertDoesNotThrow(CircleDriver::takeRadius);
    }
}