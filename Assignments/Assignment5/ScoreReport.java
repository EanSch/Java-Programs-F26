package Assignments.Assignment5;
/* 
   TODO: rename this file and class after complete the program. */

import java.io.*;
import java.util.*;

public class ScoreReport {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        Scanner input = getInput(console);
        processFile(input);
    }

    // Prompts for a file name until the user enters a file that can be read, then returns a
    // Scanner on that file (reference lecture 6 slides #40-41).
    // 1. Print the prompt "Input file name? " and read a whole line with console.nextLine()
    //    (why nextLine() and not next()? see slide #40). Build a File object from it.   <- priming read
    // 2. While the file cannot be read (use the canRead() method of File), print
    //    "File not found. Try again.", then prompt and read the file name again.        <- read again
    // 3. Return a new Scanner built from the File that can be read.
    public static Scanner getInput(Scanner console) throws FileNotFoundException {
        // TODO 1: Implement the method based on the method-level comments.
        System.out.print("Input file name? ");
        String filename = console.nextLine();
        File file = new File(filename);
        while (!file.canRead()) {
            System.out.println("File not found. Try again.");
            System.out.print("Input file name? ");
            filename = "Assignments/Assignment5/" +console.nextLine(); //Wanted to keep my files clean, so I stored the txt file in same folder
            file = new File(filename);
        }
        return new Scanner(file);
    }

    // Processes the file one line at a time. Prints a report line for each student,
    // then the number of students reported.
    // 1. Declare a counter for the students.
    // 2. while-loop input.hasNextLine(). Read one line with nextLine().
    // 3. Skip a blank line using this condition to test "text.trim().length() > 0".
    // 4. For each non-blank line, call reportStudent(text) and count the student.
    // 5. After the loop, print a blank line, then:
    //        Students reported: <number of students>
    public static void processFile(Scanner input) {
        // TODO 2: Implement the method based on the method-level comments.
        int studentCount = 0;
        while (input.hasNextLine()) {
            String text = input.nextLine();
            if (text.trim().length() > 0) {
                reportStudent(text);
                studentCount++;
            }
        }
        System.out.println();
        System.out.println("Students reported: " + studentCount);
    }

    // Report one line for a student with average of exams, such as "Alice   87.50"
    // Line and token processing combined (reference lecture 6 slides #31-32):
    // 1. Build a second Scanner named 'data' from the String text.
    // 2. Read the student's name with next().
    // 3. Use a cumulative sum and a count while data.hasNextInt(): add each nextInt() to the sum.
    // 4. compute the average as a double and print one line such as "Alice   87.50"
    //        Alice      87.50
    public static void reportStudent(String text) {
        // TODO 3: Implement the method based on the method-level comments.
        Scanner data = new Scanner(text);
        String name = data.next();
        int sum = 0;
        int count = 0;
        while (data.hasNextInt()) {
            sum += data.nextInt();
            count++;
        }
        double average = sum / (double) count;
        System.out.printf("%s      %.2f%n", name, average);
    }
}
