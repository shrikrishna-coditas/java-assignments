package FileHandling;

import java.io.*;

public class DataInOutStream {
    public static void main(String[] args) throws IOException {

        System.out.println("Writing data");
        System.out.println("File created: Dataout.txt");
        FileOutputStream file_out=new FileOutputStream("src/FileHandling/Dataout1.txt");
        DataOutputStream d_out=new DataOutputStream(file_out);

        d_out.writeBytes("Hello,this is Shrikrishna");
        d_out.write(65);
        System.out.println("Write successful");
        d_out.close();
        file_out.close();

        System.out.println("Reading Data");
        FileInputStream file_in= new FileInputStream("src/FileHandling/Dataout1.txt");
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

/**Output:
 * Writing data
 * File created: Dataout.txt
 * Write successful
 * Reading Data
 * Hello,this is ShrikrishnaA
 * Read Successful
 */