package day6assignment;

class Employee{
    int empId;
    String empName;
    String empAddress;
    float empSalary;

    Employee(int empId,String empName,String empAddress,float empSalary){
        this.empId=empId;
        this.empName=empName;
        this.empAddress=empAddress;
        this.empSalary=empSalary;
    }
}
public class Constructor {
    public static void main(String[] args){
        Employee objEmp=new Employee(120,"Krishna","Dharwad",10000.78f);
        System.out.println("Employee id: "+objEmp.empId);
        System.out.println("Employee name: "+objEmp.empName);
        System.out.println("Employee address: "+objEmp.empAddress);
        System.out.println("Employee salary: "+objEmp.empSalary);

    }
}
