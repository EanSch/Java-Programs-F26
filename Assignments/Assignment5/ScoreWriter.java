package Assignments.Assignment5;

import java.io.*;
import java.util.*;

public class ScoreWriter {
    public static final String OUTPUT_FILE = "Assignments/Assignment5/scores.txt";
    public static final String QUIT = "quit";

    public static void main(String[] args) throws FileNotFoundException {
        printIntro();

        Scanner console = new Scanner(System.in);
        PrintStream output = new PrintStream(new File(OUTPUT_FILE));// TODO 1: Construct a PrintStream named 'output' that writes to a File named OUTPUT_FILE
        
        int count = 0;
        String name = getName(console);             // priming read for student name
        while (!name.equalsIgnoreCase(QUIT)) {      // sentinel loop: stop at "quit"
            writeStudent(console, output, name);    // write student and both scores to file
            count++;
            name = getName(console);                // read again
        }

        System.out.println();
        System.out.println(count + " student record(s) written to " + OUTPUT_FILE);
    }

    public static void printIntro() {
        System.out.println(); //Just makes it easier for me to see in Terminal
        System.out.println("This program records each student's midterm and final exam scores in " + OUTPUT_FILE + ".");
        System.out.println("Enter each student's name (one word), then the two scores (0-100).");
        System.out.println("Enter '" + QUIT + "' as a name when you are finished.");
        System.out.println();
    }

    // Prompts for and returns one student name (a single token).
    public static String getName(Scanner console) {
        System.out.print("Student name (or " + QUIT + "): ");
        return console.next();
    }

    // Reads the student's midterm and final scores and writes a line to the output file:
    // 1. Get the midterm score by calling getScore(), passing the prompt "  Midterm exam score for <name>: ".
    // 2. Get the final exam score the same way, with the prompt "  Final exam score for <name>: ".
    //    (final is a reserved word in Java, so name the variable something like finalExam.)
    // 3. Print the name and the two scores on one line to the output file with println().
    // Note: printing to the file uses 'output'; only prompts use console.
    public static void writeStudent(Scanner console, PrintStream output, String name) {
        // TODO 2: Implement the method based on the method-level comments.
        int midterm = getScore(console, " Midterm exam score for " + name + ": ");
        int finalExam = getScore(console, " Final exam score for " + name + ": ");
        output.println(name + " " + midterm + " " + finalExam);
        return;
    }

    // Construct a fencepost loop to prompt for one score until a good one is received. Then returns it.
    // 1. Print the prompt that was passed in and read an int.                 <- priming read
    // 2. While the score is not valid (delegate the test to isValidScore()), print an error message
    //    then print the prompt again and read another int.                    <- read again
    // 3. Return the validated score.
    public static int getScore(Scanner console, String prompt) {
        // TODO 3: Implement the method based on the method-level comments.
        System.out.print(prompt);
        int score = console.nextInt();
        while (!isValidScore(score)) {
            System.out.println("Invalid score. Please enter a score between 0 and 100.");
            System.out.print(prompt);
            score = console.nextInt();
        }
        return score;
    }

    // Returns true if score is a legal score from 0 to 100.
    public static boolean isValidScore(int score) {
        return score >= 0 && score <= 100;
    }
}

