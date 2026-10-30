package Assignments.Assignment7;

/* This program simulates a library catalog. It reads a CSV file with one book per row (title, total
   copies, copies checked out), constructs a Book object for each row, and prints every book that is
   running low: the books with fewer than LOW_THRESHOLD copies available.

   TODO: rename this file and class (to LibraryMain), then replace this comment with your own header
   describing the program's purpose and the techniques you applied from Lectures 5, 6, 7 and 8.

   This client uses the Book class that you write from BookTemplate.java. The client owns every
   prompt and every println; the Book class prints nothing. */

import java.io.*;
import java.util.*;

public class LibraryMain {
    public static final int MAX_BOOKS = 50;      // the most books the array can hold
    public static final int LOW_THRESHOLD = 2;   // a book is low when fewer copies than this are available

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        giveIntro();

        Scanner input = getInput(console);
        Book[] books = new Book[MAX_BOOKS];     // empty slots (null); the Book objects are constructed in readBook()
        int count = readBooks(input, books);    // count = how many slots are in use

        printLowBooks(books, count);

        input.close();
        console.close();
    }

    public static void giveIntro() {
        System.out.println("This program reads a library catalog file and lists the books that are running low.");
        System.out.println("A book is low when fewer than " + LOW_THRESHOLD + " copies are available.");
        System.out.println();
    }

    // Prompts for the catalog file name until the user enters a file that can be read, then returns
    // a Scanner on that file (the same getInput() pattern as lecture 6, slides #40-41).
    // The prompt is "Catalog file name? " and the message for a bad name is "File not found. Try again."
    public static Scanner getInput(Scanner console) throws FileNotFoundException {
        // TODO 1: Implement the method based on the method-level comments.
        while (true) {
            System.out.print("Catalog file name? ");
            String fileName = console.nextLine();
            try {
                return new Scanner(new File(fileName));
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Try again.");
            }
        }
    }

    // Reads the catalog into the array and returns the number of books stored.
    // 1. The first line of the file is a header row (Title,TotalCopies,CheckedOut). Skip it, but only
    //    if there is a line to read.
    // 2. Declare a counter for the number of books stored so far.
    // 3. Loop while the counter is less than books.length AND the file has another line. Read one line.
    //    Skip a blank line (text.trim().length() > 0 is the test for a line with content).
    // 4. For each line with content, call readBook(line), store the Book object in the array at the
    //    position of the counter, and add 1 to the counter.
    // 5. Return the counter.
    public static int readBooks(Scanner input, Book[] books) {
        // TODO 2: Implement the method based on the method-level comments.
        if (input.hasNextLine()) {
            input.nextLine(); // Skip the header row
        }
        int count = 0;
        while (count < books.length && input.hasNextLine()) {
            String line = input.nextLine();
            if (line.trim().length() > 0) { // Skip blank lines
                books[count] = readBook(line);
                count++;
            }
        }
        return count;
    }

    // Builds one Book from one line of the file, such as "Clean Code,3,3".
    // The values are separated by commas, and a title may contain spaces, so a Scanner built from the
    // line has to split at the commas only (this is a technique beyond lecture 6: look up Scanner's
    // useDelimiter method and explain it in your submission).
    // 1. Build a second Scanner named data from the String line.
    // 2. Call data.useDelimiter(",") so that a comma, not a space, ends a token.
    // 3. Read the title with next(), then read the total copies and the checked-out copies with nextInt().
    // 4. Close the Scanner data.
    // 5. OBJECT CONSTRUCTION: this is where a Book object is constructed. Pass the three values to the
    //    constructor, new Book(...), and return the object.
    public static Book readBook(String line) {
        // TODO 3: Implement the method based on the method-level comments.
        Scanner data = new Scanner(line);
        data.useDelimiter(",");
        String title = data.next();
        int totalCopies = data.nextInt();
        int checkedOut = data.nextInt();
        data.close();
        return new Book(title, totalCopies, checkedOut);
    }

    // Prints "Books running low:", then every book that has fewer than LOW_THRESHOLD copies available
    // (one per line, indented by two spaces), or "  None." if there is no such book.
    // After a blank line, prints a summary such as "12 books in the catalog, 6 running low."
    // OBJECT BEHAVIOR: ask each Book object for its available copies with its accessor method, and
    // print a Book object directly (println calls its toString method automatically).
    // Only the first count slots of the array hold Book objects; the other slots are still null.
    public static void printLowBooks(Book[] books, int count) {
        // TODO 4: Implement the method based on the method-level comments.
        System.out.println("Books running low:");
        int lowCount = 0;
        for (int i = 0; i < count; i++) {
            if (books[i].getAvailable() < LOW_THRESHOLD) {
                System.out.println("  " + books[i]);
                lowCount++;
            }
        }
        if (lowCount == 0) {
            System.out.println("  None.");
        }
        System.out.println(count + " books in the catalog, " + lowCount + " running low.");
    }
}
