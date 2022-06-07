package day7assignment;
class Employee{
    private int empId;
    private String empName;
    private float empSalary;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public float getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(float empSalary) {
        this.empSalary = empSalary;
    }

    public String toString(){
        return "Employee id:"+empId+" and name:"+empName+" is having salary: "+empSalary;
    }
}

public class Encapsulation {
    public static void main(String[] args){
        Employee obj_emp=new Employee();
        obj_emp.setEmpId(101);
        obj_emp.setEmpName("Krishna");
        obj_emp.setEmpSalary(10200.75f);

        System.out.println("Employee id is:"+obj_emp.getEmpId());
        System.out.println("Employee name is:"+obj_emp.getEmpName());
        System.out.println("Employee salary is:"+obj_emp.getEmpSalary());

        System.out.println();
        System.out.println("toString Method:");
        System.out.println(obj_emp);
    }
}
