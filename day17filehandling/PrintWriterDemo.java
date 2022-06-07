package day17filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterDemo {
    public static void main(String args[]) throws FileNotFoundException {
        PrintWriter writer=new PrintWriter(new File("src/day17filehandling/pw.txt"));
        writer.write("I like Java");
        writer.close();
        System.out.println("Done writing");
    }
}
/**File created: pw.txt
 * Output:
 * Done writing
 */
