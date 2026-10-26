package Assignments.Assignment6;

import java.util.*;

public class WeeklySpending {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        System.out.println("How much did you spend on each day this week?");
        double[] spending = readSpending(console, days);
        System.out.println();
        System.out.printf("%-6s %s%n", "Day", "Amount");
        System.out.println("-----------------");
        printSpending(days, spending);

        double total = sum(spending);
        int highest = indexOfMax(spending);
        //TODO-2 format the lines to print "Total spent", "Daily average", and "Highest day"
        System.out.printf("Total spent: $%.2f%n", total);
        System.out.printf("Daily average: $%.2f%n", total / spending.length);
        System.out.printf("Highest day: %s ($%.2f)%n", days[highest], spending[highest]);

        console.close();
    }

    // TODO-3: Prompts for the amount spent on each day and returns the amounts in a new array.
    // Do not hard-code the new array length. Use indexing-looop to store the value into array.
    public static double[] readSpending(Scanner console, String[] days) {
        double[] spending = new double[days.length];
        for (int i = 0; i < days.length; i++) {
            System.out.print( days[i] + ": $");
            spending[i] = console.nextDouble();
        }
        return spending;
    }

    // TODO-4: traverse the loop to print both "Day" and "Amount". 
    // Since both arrays have the same length, they can share the same index 
    // to get the element value of each. Do not hard-code the array length.
    public static void printSpending(String[] days, double[] spending) {
        for (int i = 0; i < days.length; i++) {
            System.out.printf("%-3s: $%.2f%n", days[i], spending[i]);
        }
    }

    // TODO-5: Use a for-each loop (slide #18) with a cumulative sum to sum the total expense.
    public static double sum(double[] list) {
        double total = 0;
        for (double amount : list) {
            total += amount;
        }
        return total;
    }

    // TODO-6: Find the index to the largest expense element.
    // Assume the first value is the largest. Traverse the rest of the array 
    // with an indexed loop that starts at 1. Swap the index if the element value is larger. 
    public static int indexOfMax(double[] list) {
        int maxIndex = 0;
        for (int i = 1; i < list.length; i++) {
            if (list[i] > list[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
