package day17filehandling;

import java.util.Scanner;

public class ScannerCase2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter student id");
        int id=sc.nextInt();

        System.out.println("Enter student marks");
        float marks=sc.nextFloat();

        //Consuming the leftover new line of above nextFloat()
        sc.nextLine();

        System.out.println("Enter student name");
        String name=sc.nextLine();

        Student obj_s=new Student(id,name,marks);

        System.out.println(obj_s);
    }
}

/**Output:
 * Enter student id
 * 101
 * Enter student marks
 * 87
 * Enter student name
 * Krishna
 * Student{studentId=101, studentName='Krishna', studentMarks=87.0}
 */
