package Assignments;

//import the package required for using the Scanner class
import java.util.*;

public class SavingsSkeleton {
    // constant for the bank's annual interest rate, such as 0.065 for 6.5% or other value at your definition
    public static final double INTEREST_RATE = 0.065;

    // column widths used to line up the table (in characters)
    public static final int YEAR_WIDTH = 6;
    public static final int MONEY_WIDTH = 16;

    public static void main(String[] args) {
        // create a Scanner object to read input from the user
        Scanner console = new Scanner(System.in);
        System.out.print("initial deposit?");
        double initialDeposit = console.nextDouble();
        if (initialDeposit < 0){
            System.out.println("Initial deposit must be a positive number");
            return;
        }
        System.out.print("annual deposit?");
        double annualDeposit = console.nextDouble();
        if (annualDeposit < 0){
            System.out.println("Annual deposit must be a positive number");
            return;
        }
        System.out.print("number of years?");
        int years = console.nextInt();
        if (years < 0){
            System.out.println("Years must be more than 0");
            return;
            
        }

        // call the printTable method to display the savings account growth table
        printTable(initialDeposit, annualDeposit, INTEREST_RATE, years);

    }

    /*  
    This method takes the initial deposit, annual deposit, interest rate, and number of years as parameters
    Step 1. print the table header, for each column with predefined width

    Step 2. use a for-loop to calculate the ending-balance for each year, printing the results 
    in a formatted table.

     In Step2, calls the printField method to print the cell value with padding spaces to align 
     the columns. The first year does not have an annual deposit, so the deposit for the first
      year is 0.0.

      In Step2, calls the round2 method to round the interest and balance to two decimal places. */
    
    public static void printTable(double initialDeposit, double annualDeposit,
                                   double rate, int years) {                         
        double balance = initialDeposit;
        double totalInterest = 0.0;
        printField("year", YEAR_WIDTH);
        printField("current balance", MONEY_WIDTH);
        printField("interest", MONEY_WIDTH);
        printField("deposit", MONEY_WIDTH);
        printField("new balance", MONEY_WIDTH);
        System.out.println();
        
        

        
        for (int i = 1; i <= years; i++) {
            double depositThisYear = (i == 1) ? 0.0 : annualDeposit; // deposit for the first year is 0.0
            double interest = round2(balance * INTEREST_RATE);
            double newBalance = round2(balance + interest + depositThisYear);
            printField(String.valueOf(i), YEAR_WIDTH);
            printField(String.format("%.2f", balance), MONEY_WIDTH);
            printField(String.format("%.2f", interest), MONEY_WIDTH);
            printField(String.format("%.2f", depositThisYear), MONEY_WIDTH);
            printField(String.format("%.2f", newBalance), MONEY_WIDTH);
            balance = newBalance;
            totalInterest = totalInterest + interest;
            System.out.println();

        }
        totalInterest = round2(totalInterest);
            System.out.printf("Total Interest: " + totalInterest );
    }

    /*  This method take cell value and column width as parameters
     It uses a for-loop to pad the cell value for unfilled spaces. 
     You decide to make it left-aligned or right-aligned.
    */
    public static void printField(String text, int width) {
        System.out.print(text);
        for (int i = text.length(); i < width; i++) {
            System.out.print(" ");
        }
    }

    // This method rounds a number to 2 digits after the decimal point
    public static double round2(double n) {
        return (int) (n * 100.0 + 0.5) / 100.0;
    }
}
