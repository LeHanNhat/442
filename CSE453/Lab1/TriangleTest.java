package lab1q3;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;


class TriangleTest {

	@Test
    void testIsTriangle() {
        
        String input = "6\n8\n10\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

       
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        
        String[] args = {};
        Triangle.main(args);

       
        String expectedOutput = "Enter side 1: " + System.lineSeparator();
        expectedOutput += "Enter side 2: " + System.lineSeparator();
        expectedOutput += "Enter side 3: " + System.lineSeparator();
        expectedOutput += "This is a triangle." ;

        
        assertEquals(expectedOutput.trim(), out.toString().trim());
    }
	@Test
    void testNotTriangle() {
        
        String input = "8\n16\n8\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

       
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        
        String[] args = {};
        Triangle.main(args);

       
        String expectedOutput = "Enter side 1: " + System.lineSeparator();
        expectedOutput += "Enter side 2: " + System.lineSeparator();
        expectedOutput += "Enter side 3: " + System.lineSeparator();
        expectedOutput += "This is not a triangle.";

        
        assertEquals(expectedOutput.trim(), out.toString().trim());
    }

    

}
