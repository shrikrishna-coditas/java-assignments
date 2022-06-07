import java.util.Scanner;

class ConStat{
    public char checkGrade(int marks){
        if(marks>90){
            return 'A';
        }else if(marks>70){
            return 'B';
        }else if(marks>50){
            return 'C';
        }else{
            return 'F';
        }
    }
    public String checkDay(int ch){
        switch(ch){
            case 1:return "Sunday";
            case 2:return "Monday";
            case 3:return "Tuesday";
            case 4:return "Wednesday";
            case 5:return "Thursday";
            case 6:return "Friday";
            case 7:return "Saturday";
            default:return "Invalid choice";
        }
    }
}

public class ControlStatements {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter marks between 0 to 100");
        int marks=sc.nextInt();
        ConStat cs=new ConStat();
        if(marks>=0 && marks<=100) {
            char grade = cs.checkGrade(marks);
            System.out.println("Grade is "+grade);
        }else{
            System.out.println("Invalid choice");
        }
        System.out.println("Enter number between 1 to 7");
        int num=sc.nextInt();
        String day=cs.checkDay(num);
        System.out.println(day);
    }
}
