package day17filehandling;

import java.util.Scanner;

public class ScannerEmployee {
    int id;
    String name;
    float salary;

    public void acceptData(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter employee name");
        name=sc.nextLine();

        System.out.println("Enter employee id");
        id=sc.nextInt();

        System.out.println("Enter employee salary");
        salary=sc.nextFloat();
    }

    public void displayData(Employee e){
        System.out.println("Employee name:"+e.empName+" and Id:"+e.empId+" having salary:"+e.empSalary);
    }

    public static void main(String[] args){
        ScannerEmployee se=new ScannerEmployee();
        se.acceptData();
        Employee obj_emp=new Employee(se.id, se.name, se.salary );
        se.displayData(obj_emp);
    }
}

/**Output:
 * Enter employee name
 * Krishna
 * Enter employee id
 * 102
 * Enter employee salary
 * 20000
 * Employee name:Krishna and Id:102 having salary:20000.0
 */
