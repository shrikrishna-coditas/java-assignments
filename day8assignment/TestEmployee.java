package day8assignment;


import java.util.Scanner;

class Employee {
    Employee(){

    }
    public String toString(){
        return "This is employee object";
    }

}
class WageEmployee extends Employee{
    int hours;
    int rate;

    WageEmployee(){

    }

    WageEmployee(int hours,int rate){
        this.hours=hours;
        this.rate=rate;
    }

    public void computeSalary(){
        System.out.println("Wage Employee salary:"+hours*rate);
    }

    public String toString(){
        return "Wage Employee has worked "+hours+" hours with the rate of "+rate+" per hour";
    }
}

class SalesPerson extends WageEmployee{
    int sales;
    int commission;

    SalesPerson(){

    }

    SalesPerson(int sales,int commission){
        this.sales=sales;
        this.commission=commission;
    }

    public void computeSalary(){
        System.out.println("Sales Person salary:"+sales*commission);
    }

    public String toString(){
        return "Sales Person has sold "+sales+" items with commission of "+commission+" per item";
    }
}

class Manager extends Employee{
    int fixedSalary;
    int incentives;

    Manager(){

    }

    Manager(int fixedSalary,int incentives){
        this.fixedSalary=fixedSalary;
        this.incentives=incentives;
    }

    public void computeSalary(){
        System.out.println("Manager salary:"+(fixedSalary+incentives));
    }

    public String toString(){
        return "Manager has fixed salary of "+fixedSalary+" and incentive of "+incentives;
    }

}

public class TestEmployee {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        /*System.out.println("What is the rate for wage employee?");
        int rate=sc.nextInt();
        System.out.println("How many hours he has worked?");
        int hours= sc.nextInt();

        WageEmployee obj_we=new WageEmployee(hours,rate);
        System.out.println(obj_we);
        obj_we.computeSalary();

        System.out.println();*/


        /*for (int i=0;i<3;i++){
            System.out.println("Enter sales:");
            int sales=sc.nextInt();
            System.out.println("Enter commission:");
            int commission= sc.nextInt();
            salesPeople[i]=new SalesPerson(sales,commission);
        }

        for(int i=0;i<3;i++){
            System.out.println(salesPeople[i]);
            salesPeople[i].computeSalary();
        }

        System.out.println();*/


        /*for (int i=0;i<3;i++){
            System.out.println("Enter fixed salary:");
            int fixedSalary=sc.nextInt();
            System.out.println("Enter incentive:");
            int incentive= sc.nextInt();
            managers[i]=new Manager(fixedSalary,incentive);
        }

        for(int i=0;i<3;i++){
            System.out.println(managers[i]);
            managers[i].computeSalary();
        }*/
        SalesPerson[] salesPeople=new SalesPerson[3];
        Manager[] managers=new Manager[3];
        WageEmployee[] wageEmployees=new WageEmployee[3];
        for(int i=0;i<3;i++){
            System.out.println("Employee "+(i+1));
            System.out.println("Wage employee: Enter number of hours and rate");
            int hours=sc.nextInt();
            int rate=sc.nextInt();
            wageEmployees[i]=new WageEmployee(hours,rate);
            System.out.println(wageEmployees[i]);
            wageEmployees[i].computeSalary();
            System.out.println();

            System.out.println("Sales person: Enter number of sales and commission");
            int sales= sc.nextInt();
            int commission= sc.nextInt();
            salesPeople[i]=new SalesPerson(sales,commission);
            System.out.println(salesPeople[i]);
            salesPeople[i].computeSalary();
            System.out.println();

            System.out.println("Manager: Enter fixed salary and incentives");
            int fixedSalary=sc.nextInt();
            int incentives=sc.nextInt();
            managers[i]=new Manager(fixedSalary,incentives);
            System.out.println(managers[i]);
            managers[i].computeSalary();
            System.out.println();
        }

    }
}



