package FileHandling;

import java.io.*;

public class FilterInOutStream {
    public static void main(String args[]) throws IOException{
        FilterOutputStream f_out=new FilterOutputStream(new FileOutputStream("src/FileHandling/FilterOut.txt"));

        System.out.println("Writing data");
        System.out.println("File created:FilterOut.txt");
        byte[] array={'C','o','d','i','t','a','s'};

        f_out.write(array);
        System.out.println("Write successful");
        f_out.close();
        System.out.println("Reading data");
        FilterInputStream f_in=new BufferedInputStream(new FileInputStream("src/FileHandling/FilterOut.txt"));

        int i=0;
        while((i=f_in.read())!=-1){
            System.out.print((char) i);
        }
        System.out.println("\nRead successful");
    }
}

/**Output:
 * Writing data
 * File created:FilterOut.txt
 * Write successful
 * Reading data
 * Coditas
 * Read successful
 */