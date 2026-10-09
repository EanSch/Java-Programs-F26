package Assignments.Assignment1;

import java.util.*;

public class Assignment2_1 {
    public static final double AbsoluteZeroC = -273.15;
    public static final double AbsoluteZeroF = -459.67;

    public static void main(String[] args) {
        /// Recieving information from user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a temperature value: ");
        double temp = scanner.nextDouble();

        System.out.print("Enter the type of temperature (C for Celsius, F for Fahrenheit:");
        char type = scanner.next().charAt(0);

        /// Decide which type to use
       if (type == 'F' || type == 'f') {
        double tempc = ftoc(temp);
        System.out.println("Celsius temperature is: " + tempc);
    } else if (type == 'C' || type == 'c') {
        double tempf = ctof(temp);
        System.out.println("Fahrenheit temperature is: " + tempf);
    } else {
    System.out.println("Invalid temperature type. Please type 'C' for Celsius or 'F' for Fahrenheit.");
    }   

    scanner.close();
}

public static double ftoc(double temp) {
    if (temp < AbsoluteZeroF) {
        throw new IllegalArgumentException("Temperature cannot be below absolute zero (459.67 F)");
    }
    return (temp-32) * 5 / 9;
    }
public static double ctof(double temp) {
    if (temp < AbsoluteZeroC) {
        throw new IllegalArgumentException("Temperature cannot be below absolute zero (273.15 C)");
    }
        return (temp * 9/5) + 32;
}
}
