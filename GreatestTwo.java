import java.util.Scanner;

public class GreatestTwo {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n1,n2;
        System.out.println("Enter two numbers");
        n1=sc.nextInt();
        n2=sc.nextInt();
        int ans=(n1>n2) ? n1: n2;
        System.out.println("Maximum of "+n1+" and "+n2+" is "+ans);
    }
}
