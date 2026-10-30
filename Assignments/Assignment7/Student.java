package Assignments.Assignment7;

/* A Student object represents one student's course grades: the student's name and a running record
   of the courses taken so far. From that record the object can report the student's GPA.

   TODO: rename this file and class (to Student), then replace this comment with your own header
   describing the purpose of the class and the techniques you applied from Lecture 8.

   Write this class first. The client program (StudentMain) cannot compile until the constructor
   and the methods described below exist, and they must have exactly these names. */

public class Student {

    // TODO 1: Fields (reference lecture 8, section 8.4).

    // Declare three private fields: the student's name (a String), the total of the grade points of
    // all the courses recorded so far (a double), and the number of courses recorded so far (an int).
    // Do not store a GPA field. The GPA can always be computed from the other two values, so a stored
    // GPA could become out of date.

    private String name;
    private double totalGradePoints;
    private int courseCount;

    // TODO 2: Constructor (reference lecture 8, section 8.3).
    // Header:  public Student(String name)
    // The constructor runs when a client writes new Student("Alice"). It stores the name and starts
    // the student with no courses recorded. Reject a null name by throwing a NullPointerException.
    // The parameter has the same name as the field, so use this.name to refer to the field.

    public Student(String name) {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        }
        this.name = name;
        this.totalGradePoints = 0.0;
        this.courseCount = 0;
    }

    // TODO 3: Mutator (reference lecture 8, section 8.2).
    // Header:  public void addCourse(double gradePoints)
    // A mutator changes the state of the object. A client calls it on an existing Student object, as in
    // student.addCourse(3.5), to record one more course: add the grade points to the total and count
    // the course. Grade points must be from 0.0 to 4.0. Anything else is a client bug, so throw an
    // IllegalArgumentException (this keeps the class invariant true).
    public void addCourse(double gradePoints) {
        if (gradePoints < 0.0 || gradePoints > 4.0) {
            throw new IllegalArgumentException("Grade points must be between 0.0 and 4.0");
        }
        this.totalGradePoints += gradePoints;
        this.courseCount++;
    }


    // TODO 4: Accessors (reference lecture 8, section 8.2).
    // Header:  public String getName()
    // Returns the student's name.
    //
    // Header:  public double getGPA()
    // Returns the grade point average: the total grade points divided by the number of courses.
    // A student with no courses has a GPA of 0.0 (avoid dividing by zero). Accessors report the state
    // and never modify it. Return the answer; do not print it.
    public String getName() {
        return this.name;
    }

    public double getGPA() {
        if (this.courseCount == 0) {
            return 0.0;
        }
        return this.totalGradePoints / this.courseCount;
    }

    // TODO 5: toString (reference lecture 8, section 8.2).
    // Header:  public String toString()
    // Returns a String that shows the contents of the object, so that println(student) is useful for
    // inspecting it. For example:  Student[name=Alice, totalGradePoints=10.5, courseCount=3]
    // Return the text; do not print it. Java calls toString automatically when an object is printed
    // or joined to a String.
public String toString() {
        return "Student[name=" + this.name + ", totalGradePoints=" + this.totalGradePoints + ", courseCount=" + this.courseCount + "]";
    }
}
