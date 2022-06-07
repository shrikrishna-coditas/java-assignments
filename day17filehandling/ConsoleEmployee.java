package day17filehandling;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

class Employee1 {
    int empId;
    String empName;
    float empSalary;

    public Employee1(int empId, String empName, float empSalary) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
    }
}
public class ConsoleEmployee {
    int id;
    String name;
    float salary;
    public void acceptData() throws IOException {
        Console c=System.console();

        System.out.println("Enter employee name");
        name=c.readLine();

        System.out.println("Enter employee id");
        id=Integer.parseInt(c.readLine());

        System.out.println("Enter employee salary");
        salary=Float.parseFloat(c.readLine());
    }

    public void displayData(Employee1 e){
        System.out.println("Employee name:"+e.empName+" and Id:"+e.empId+" having salary:"+e.empSalary);
    }

    public static void main(String[] args) throws IOException{
        ConsoleEmployee cn=new ConsoleEmployee();
        cn.acceptData();
        Employee1 obj_emp=new Employee1(cn.id, cn.name, cn.salary );
        cn.displayData(obj_emp);
    }
}

/** Output:
 * Enter employee name
 * Krishna
 * Enter employee id
 * 103
 * Enter employee salary
 * 30000
 * Employee name:Krishna and Id:103 having salary:30000.0
 */
