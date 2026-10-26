package Assignments.Assignment6;

////Note: the user counts rows and seats from 1, but array indexes start at 0, so subtract 1
///whenever a row or seat number is used as an index. 

import java.util.*;

public class MovieSeatsTemplate {
    public static final int TOTAL_ROW = 4;
    public static final int TOTAL_COL = 6;
    public static final int STOP = 0;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean[][] taken = new boolean[TOTAL_ROW][TOTAL_COL]; //all seats are open (initialized to false)

        System.out.println("Reserve seats in a theater with " + TOTAL_ROW + " rows of " + TOTAL_COL + " seats.");
        showSeats(taken);

        System.out.print("Row to reserve (" + STOP + " to finish): ");
        int row = console.nextInt(); // priming read
        while (row != STOP) { // sentinel loop: stop when the row is 0
            System.out.print("Seat number: ");
            int seat = console.nextInt();

            if (!isValidSeat(taken, row, seat)) {
                System.out.println("There is no such seat.");
            } else if (taken[row - 1][seat - 1]) {
                System.out.println("Sorry, that seat is already taken.");
            } else {
                taken[row - 1][seat - 1] = true;
                System.out.println("Reserved!");
            }
            showSeats(taken);

            System.out.print("Row to reserve (0 to finish): ");
            row = console.nextInt(); // read again
        }

        int total = taken.length * taken[0].length;
        System.out.println("Seats taken: " + countTaken(taken) + " of " + total);

        console.close();
    }

    // TOOD-2: Prints the seat map: O (false) is an open seat and X (true) is a taken seat.
    // For a theater of 4 rows of 6 seats where row 2, seat 3 is taken, print exactly:
    //
    //     Row 1:  O O O O O O
    //     Row 2:  O O X O O O
    //     Row 3:  O O O O O O
    //     Row 4:  O O O O O O
    //
    // Use nested loops to print row and column. Do not hard-code the row and column(slide #60). 
    // Use taken.length for the number of rows and taken[r].length for the number of seats in row r.
    public static void showSeats(boolean[][] taken) {
        for (int r = 0; r < taken.length; r++) {
            System.out.print("Row " + (r + 1) + ":  ");
            for (int s = 0; s < taken[r].length; s++) {
                if (taken[r][s]) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
 
    // TODO-3: Returns the number of taken seats in the whole theater.
    // Use the same nested loops as showSeats() to visit every seat. Increment counter if seat is true. 
    public static int countTaken(boolean[][] taken) {
        int count = 0;
        for (int r = 0; r < taken.length; r++) {
            for (int s = 0; s < taken[r].length; s++) {
                if (taken[r][s]) {
                    count++;
                }
            }
        }
        return count;
    }

    // TODO-4: Returns true if the row and seat numbers (counted from 1) are a real seat in the theater.
    // Use logical operators and Boolean Zen.
    public static boolean isValidSeat(boolean[][] taken, int row, int seat) {
        return row >= 1 && row <= taken.length && seat >= 1 && seat <= taken[0].length;
    }
}
