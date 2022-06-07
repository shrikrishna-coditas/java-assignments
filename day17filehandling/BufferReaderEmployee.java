package day17filehandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BufferReaderEmployee {
    int id;
    String name;
    float salary;

    public void acceptData() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter employee name");
        name=br.readLine();

        System.out.println("Enter employee id");
        id=Integer.parseInt(br.readLine());

        System.out.println("Enter employee salary");
        salary=Float.parseFloat(br.readLine());
    }

    public void displayData(Employee e){
        System.out.println("Employee name:"+e.empName+" and Id:"+e.empId+" having salary:"+e.empSalary);
    }

    public static void main(String[] args) throws IOException{
        BufferReaderEmployee be=new BufferReaderEmployee();
        be.acceptData();
        Employee obj_emp=new Employee(be.id, be.name, be.salary );
        be.displayData(obj_emp);
    }
}

/**
 * Enter employee name
 * Sundar
 * Enter employee id
 * 103
 * Enter employee salary
 * 15000
 * Employee name:Sundar and Id:103 having salary:15000.0
 */