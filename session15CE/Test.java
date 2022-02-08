package session15CE;

import java.util.Scanner;

public class Test {
    public static void main(String args[]){
        RegisterUser obj_r=new RegisterUser();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Citizenship");
        String citizenship= sc.nextLine();
        try{
            obj_r.validate(citizenship);
            System.out.println("Enter Age");
            int age=sc.nextInt();
            try{
                obj_r.validate(age);
            }
            catch (InvalidAgeException e){
                System.out.println("Invalid age Exception occurred::"+e.getMessage());
            }
        }
        catch (InvalidCitizenshipException e){
            System.out.println(e.getMessage());
        }

    }
}

/**
 * Output: Case 1:
 * Enter Citizenship
 * American
 * Parameter String:: Constructor==>Citizenship should be INDIAN
 * Message: InvalidCitizenship: You must be Indian
 *
 * Case 2:
 * Enter Citizenship
 * Indian
 * Enter Age
 * 17
 * Parameter String:: Constructor==>You are Minor
 * Invalid age Exception occurred::Message: Please enter age >= 18
 */
