package day17filehandling;

import java.io.*;

public class ClosingStreams {
    public static void main(String[] args) throws IOException {

        System.out.println("Writing data");
        System.out.println("File created: Dataout.txt");
        FileOutputStream file_out=new FileOutputStream("src/day17filehandling/Dataout1.txt");
        DataOutputStream d_out=new DataOutputStream(file_out);

        d_out.writeBytes("Hello,this is Shrikrishna");
        d_out.write(65);
        System.out.println("Write successful");
        d_out.close();
        file_out.close();

        System.out.println("Reading Data");
        FileInputStream file_in= new FileInputStream("src/day17filehandling/Dataout1.txt");
        DataInputStream d_in=new DataInputStream(file_in);

        int i=0;
        while((i=d_in.read())!=-1){
            System.out.print((char) i);
        }
        file_in.close();
        d_in.close();
        System.out.println("\nRead Successful");

    }
}
/**Note:if we don't close() the output stream,
 * the data that we intended to write
 * in the file remains in the buffer and is not written.
 * Output:
 * Writing data
 * File created: Dataout.txt
 * Write successful
 * Reading Data
 * Hello,this is ShrikrishnaA
 * Read Successful
 */