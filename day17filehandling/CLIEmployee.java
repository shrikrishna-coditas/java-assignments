package day17filehandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLIEmployee {
    int id;
    String name;
    float salary;

    public void acceptData(String name,int id,float salary) {
        this.name=name;
        this.id=id;
        this.salary=salary;
    }

    public void displayData(Employee e){
        System.out.println("Employee name:"+e.empName+" and Id:"+e.empId+" having salary:"+e.empSalary);
    }

    public static void main(String[] args){
        CLIEmployee ce=new CLIEmployee();
        ce.acceptData(args[0],Integer.parseInt(args[1]),Float.parseFloat(args[2]));
        Employee obj_emp=new Employee(ce.id, ce.name, ce.salary );
        ce.displayData(obj_emp);
    }
}

/**Output:
 * Employee name:Krishna and Id:101 having salary:40000.0
 */