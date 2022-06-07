import java.util.Scanner;
class Calculate{
    public int Oldest(int age1,int age2,int age3){
        if(age1>age2 && age1>age3){
            return age1;
        }
        else if(age2>age3){
            return age2;
        }
        else{
            return age3;
        }
    }
    public int Youngest(int age1,int age2,int age3){
        if(age1<age2 && age1<age3){
            return age1;
        }
        else if(age2<age3){
            return age2;
        }
        else{
            return age3;
        }
    }
}

public class AgeCalculator {
    public static void main(String[] args){
        int age1,age2,age3;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter age of 3 person");
        age1=sc.nextInt();
        age2= sc.nextInt();
        age3= sc.nextInt();
        Calculate c=new Calculate();
        int oldest=c.Oldest(age1,age2,age3);
        int youngest=c.Youngest(age1,age2,age3);
        System.out.println("Oldest is "+oldest+" and youngest is "+youngest+" years old");
    }
}
