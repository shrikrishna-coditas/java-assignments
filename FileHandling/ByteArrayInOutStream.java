package FileHandling;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayInOutStream {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream b_out=new ByteArrayOutputStream();
        byte[] array={'J','a','v','a','C','l','a','s','s'};
        b_out.write(array);
        System.out.println("Write success");
        ByteArrayInputStream b_in=new ByteArrayInputStream(array);
        int i;
        while((i=b_in.read())!=-1){
            char ch=(char) i;
            System.out.print(ch);
        }

        System.out.println("\nRead success");
    }
}

/**Output:
 * Write success
 * JavaClass
 * Read success
 */
