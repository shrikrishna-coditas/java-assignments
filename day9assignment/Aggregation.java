package  day9assignment;
class DOB{
    int date,year;
    String month;

    public DOB(int date, String month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }
}
class Teacher{
    int teacherId;
    String teacherName;
    DOB teacherDOB;

    Teacher(){

    }

    public Teacher(int teacherId, String teacherName, DOB teacherDOB) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherDOB = teacherDOB;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherDOB=" + teacherDOB.date + " "+ teacherDOB.month + " " + teacherDOB.year +
                '}';
    }
}

class Employee{
    int empId;
    String empName;
    float empSalary;
    DOB empDOB;

    Employee(){

    }

    public Employee(int empId, String empName, float empSalary, DOB empDOB) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empDOB = empDOB;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", empDOB=" + empDOB.date + " "+ empDOB.month + " " + empDOB.year +
                '}';
    }
}

public class Aggregation {
    public static void main(String[] args){

        DOB teacherDOB=new DOB(22,"March",2000);
        Teacher obj_t=new Teacher(101,"Krishna",teacherDOB);
        System.out.println(obj_t);

        System.out.println();

        DOB empDOB=new DOB(18,"May",2000);
        Employee obj_e=new Employee(201,"Ram",12000f,empDOB);
        System.out.println(obj_e);

    }
}
