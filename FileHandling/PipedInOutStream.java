package FileHandling;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedInOutStream {
    public static void main(String[] args) throws IOException{
        System.out.println("Writing data");

        PipedInputStream p_in=new PipedInputStream();
        PipedOutputStream p_out=new PipedOutputStream();

        p_in.connect(p_out);

        byte[] array={'K','R','I','S','H','N','A'};

        p_out.write(array);
        System.out.println("Write success");
        int i=7;
        while(i>0){
            System.out.print((char) p_in.read());
            i--;
        }
        p_out.close();

        System.out.println("\nRead success");
    }
}

/**Output:
 * Writing data
 * Write success
 * KRISHNA
 * Read success
 */