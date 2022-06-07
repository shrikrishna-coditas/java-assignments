package day17filehandling;

import java.io.*;

/* Removing the system information leak vulnerability by printing only
generic (non-detailed) error messages */
class passwdAuth
{
    public static void main(String args[])
    {
        try
        {
            String logFileName = args[0];
            File f = new File(logFileName);
            boolean access_granted = false;
            String password = "";
            int integer = 5;

            if (args.length == 2)
            {
                System.out.println("Checking command-line password");
                password = password + args[1];
                if (password.equals("3dTAqb.7"))
                {
                    access_granted = true;
                    System.out.println("Password matches.");
                }
                else
                    System.out.println("Command-line password does not match");
            }//end if

            if (access_granted)
            {
                System.out.println("Access granted!");

                PrintWriter out = new PrintWriter(new
                        FileOutputStream(f, true));
                out.println();
                out.print("Updated...");
                out.println();
                out.flush();
                out.close();

                DataInputStream din=new DataInputStream(new FileInputStream(f));
                int i=0;
                while((i=din.read())!=-1){
                    System.out.print((char) i);
                }
                din.close();
                System.out.println("\nRead Successful");
            }//end if

        }//end try
        catch (Exception e)
        {
            System.out.println("an error has occured.");
            //e.printStackTrace();
        }
    }//end main
}//end class
/**Output:
 * Checking command-line password
 * Password matches.
 * Access granted!
 *
 * Updated...
 *
 * Updated...
 *
 * Read Successful
 */