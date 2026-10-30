package Assignments.Assignment7;


/* This program asks the user for the number of students, then for each student's name and the grade
   points of each of that student's courses. It stores the Student objects in an array and finishes
   by printing every student's name and GPA.

   TODO: rename this file and class (to StudentMain), then replace this comment with your own header
   describing the program's purpose and the techniques you applied from Lectures 7 and 8.

   This client uses the Student class that you write from StudentTemplate.java. The client owns every
   prompt and every println; the Student class prints nothing. */

import java.util.*;

public class StudentMain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        giveIntro();

        System.out.print("How many students? ");
        int numStudents = console.nextInt();

        // Constructing the array creates only empty slots (null). The Student objects themselves are
        // constructed one at a time, inside readStudent().
        Student[] students = new Student[numStudents];
        for (int i = 0; i < students.length; i++) {
            students[i] = readStudent(console);
        }

        printReport(students);

        console.close();
    }

    public static void giveIntro() {
        System.out.println("This program computes the GPA of each student.");
        System.out.println("Enter each student's name (one word), then the grade points of each course");
        System.out.println("(4.0 = A, 3.0 = B, 2.0 = C, 1.0 = D, 0.0 = F).");
        System.out.println();
    }

    // Reads one student's name, the number of courses, and the grade points of each course,
    // and returns the Student object for that student.
    // OBJECT CONSTRUCTION: construct the Student object here, as soon as you have the name (new Student(...)).
    // OBJECT BEHAVIOR: after each grade points value is read, ask the Student object to record it
    //     by calling its addCourse method.
    // Print a blank line after the last course so the next student's prompts are easy to read.
    public static Student readStudent(Scanner console) {
        // TODO 1: Implement the method based on the method-level comments.
        System.out.print("Enter student's name: ");
        String name = console.next();
        Student student = new Student(name);
        System.out.print("How many courses? ");
        int numCourses = console.nextInt();
        for (int i = 0; i < numCourses; i++) {
            System.out.print("Enter grade points for course " + (i + 1) + ": ");
            double gradePoints = console.nextDouble();
            student.addCourse(gradePoints);
        }
        System.out.println();
        return student;
    }

    // Prints a heading line (Name and GPA), a line of dashes, and then one line per student with
    // the name (left-aligned in 12 columns) and the GPA with 2 digits after the decimal point.
    //     Alice        3.50
    // OBJECT BEHAVIOR: ask each Student object for its name and its GPA with the accessor methods.
    // The client never reaches into the fields of a Student.
    public static void printReport(Student[] students) {
        // TODO 2: Implement the method based on the method-level comments.
        System.out.println("Name         GPA");
        System.out.println("------------ ------------");
        for (Student student : students) {
            System.out.printf("%-12s %.2f%n", student.getName(), student.getGPA());
        }
    }
}


