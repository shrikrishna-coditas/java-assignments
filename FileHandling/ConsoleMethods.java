package FileHandling;

import java.io.Console;
import java.util.Scanner;

public class ConsoleMethods {
    public static void main(String[] args){
        Console c=System.console();

        System.out.println("Enter user id");
        String uid=c.readLine();

        System.out.println("Enter password");
        char[] passwd=c.readPassword();
        String str=new String(passwd);

        System.out.println("Enter names");
        Scanner sc=new Scanner(c.reader());

        while (sc.hasNext()){
            String s=sc.next();
            System.out.println(s);
        }
    }
}
