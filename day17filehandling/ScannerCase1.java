package day17filehandling;

import java.util.Scanner;

public class ScannerCase1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter student name");
        String name=sc.nextLine();

        System.out.println("Enter student id");
        int id=sc.nextInt();

        System.out.println("Enter student marks");
        float marks=sc.nextFloat();

        Student obj_s=new Student(id,name,marks);

        System.out.println(obj_s);
    }
}

/**Output:
 * Enter student name
 * Vivek
 * Enter student id
 * 101
 * Enter student marks
 * 92
 * Student{studentId=101, studentName='Vivek', studentMarks=92.0}
 */
