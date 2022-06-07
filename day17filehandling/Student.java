package day17filehandling;

public class Student {
    int studentId;
    String studentName;
    float studentMarks;

    public Student(int studentId, String studentName, float studentMarks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentMarks = studentMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentMarks=" + studentMarks +
                '}';
    }
}
