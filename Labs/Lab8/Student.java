package Lab8;

public class Student {

    private int studentId;
    private String studentName;
    private double gpa;
    private String major;

    public Student() {
        this(0, "", 0.0, "");
    }

    public Student(int studentId, String studentName, double gpa, String major) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gpa = gpa;
        this.major = major;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getGPA() {
        return gpa;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + studentName + ", GPA: " + gpa + ", Major: " + major;
    }
}
