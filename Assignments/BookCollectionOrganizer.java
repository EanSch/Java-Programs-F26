package Assignments;

import java.util.*;

public class BookCollectionOrganizer{
    /* This program hels users organize a book collection.
    It will ask for information, like how many books you want to add to the collection
    Then, the title, author, page number, and whether it has been read or not
    Repeats for total number of books, and then gives stats at the end.

    Techniques from Lectures:
 - while loop to repeatedly enter books
 - boolean to track whether each book has been read
 - methods to handle smaller tasks
 - counters and accumulators
 - input validation
 - if statement for read/unread books
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("How many books do you want in your collection? ");
        int goal = input.nextInt();
        input.nextLine();

        // Validate the collection goal
        while (goal <= 0) {
            System.out.print("Please enter a positive number of books: ");
            goal = input.nextInt();
            input.nextLine();
        }

        int bookCount = 0;
        int totalPages = 0;
        int readCount = 0;

        // Continue entering books until the collection goal is reached
        while (bookCount < goal) {

            String title = getTitle(input);

            String author = getAuthor(input);

            int pages = getPages(input);

            boolean read = getReadStatus(input);

            if (read) {
                readCount++;
            }

            totalPages += pages;
            bookCount++;

            System.out.println("Book added: " + title + " by " + author);
            System.out.println();
        }

        // Calculate average pages
        double averagePages = (double) totalPages / bookCount;

        // Determine whether the collection goal was reached
        boolean goalReached = bookCount >= goal;

        System.out.println("----- Collection Summary -----");
        System.out.println("Total books: " + bookCount);
        System.out.println("Total pages: " + totalPages);
        System.out.printf("Average pages: %.2f%n", averagePages);
        System.out.println("Books read: " + readCount);
        System.out.println("Books unread: " + (bookCount - readCount));

        if (goalReached) {
            System.out.println("Collection goal reached: true");
        } else {
            System.out.println("Collection goal reached: false");
        }

        input.close();
    }

    // Gets the title of a book
    public static String getTitle(Scanner input) {
        System.out.print("Enter the title of the book: ");
        return input.nextLine();
    }

    // Gets the author of a book
    public static String getAuthor(Scanner input) {
        System.out.print("Enter the author of the book: ");
        return input.nextLine();
    }

    // Gets and validates the number of pages
    public static int getPages(Scanner input) {

        System.out.print("Enter the number of pages in the book: ");
        int pages = input.nextInt();
        input.nextLine();

        while (pages <= 0) {
            System.out.print("Pages must be greater than 0. Enter the number of pages: ");
            pages = input.nextInt();
            input.nextLine();
        }

        return pages;
    }

    // Gets whether the user has read the book
    public static boolean getReadStatus(Scanner input) {

        System.out.print("Have you read this book? (true/false): ");
        boolean read = input.nextBoolean();
    input.nextLine();

    return read;
    }
}