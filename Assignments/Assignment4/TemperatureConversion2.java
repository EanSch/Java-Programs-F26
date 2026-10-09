/* This program will input user for a temperature value and the type of temperature, then convert it
from Celsius to Fahrenheit or vice versa */

package Assignments.Assignment4;

import java.util.Scanner;

public class TemperatureConversion2 {
    public static final double ABSOLUTE_ZERO_C = -273.15;
    public static final double ABSOLUTE_ZERO_F = -459.67;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        
        char type = getTemperatureType(console,
                "Enter the type of temperature (C for Celsius, F for Fahrenheit): ");
        double temperature = getTemperature(console, type);

        printConversion(type, temperature);

        console.close();
    }

    // Prompts for a temperature value based on the type. Validate the user inputs until a good value received. 
    // 1. build prompt based on type.
    // 2. select the sentinel based on type.
    // 3. divide the validation to two parts: 
    //      part 1 is to get a double by delegating to getDouble().
    //      part 2 is to validate the returned double with sentinel (absolute zero) until an above-absolute-zero temperature is confirmed
    // 4. using fencepost-while loop to handle 'part 2'
    // 5. return the finally validated temperature.
    public static double getTemperature(Scanner console, char type) {
        String prompt;
        double AbsoluteZero;
        if (type == 'C') {
            prompt = "Enter a Celsius temperature (must be above " + ABSOLUTE_ZERO_C + "): ";
            AbsoluteZero = ABSOLUTE_ZERO_C;
        } else {
            prompt = "Enter a Fahrenheit temperature (must be above " + ABSOLUTE_ZERO_F + "): ";
            AbsoluteZero = ABSOLUTE_ZERO_F;
        }

        double temperature = getDouble(console, prompt);
        while (temperature <= AbsoluteZero) {
            System.out.println("Temperature must be above absolute zero.");
            temperature = getDouble(console, prompt);
        }
        return temperature;
    }

    // Prompts for a temperature value and returns it as a double. Re-prompting
    // until a good double is recieved (reference lecture 5 slide# 57). 
    // note how fencepost-while-loop is applied
    public static double getDouble(Scanner console, String prompt) {
        System.out.print(prompt);
        while (!console.hasNextDouble()) {
            console.next(); // discard invalid token
            System.out.print(prompt);
        }
        return console.nextDouble();
    }

    // Prompts for a temperature type and returns 'C' or 'F', re-prompting until
    // the user enters a good value. A do/while loop fits this case
    // better than the fencepost while loop, because: console.next() always
    // succeeds here (there's no risk of crashing the program by a string like that with
    // nextDouble()), so there's no separate "discard" step to push to the
    // bottom of the loop.
    public static char getTemperatureType(Scanner console, String prompt) {
        char type;
        do {
            System.out.print(prompt);
            String token = console.next();
            type = token.toUpperCase().charAt(0);
            if (type != 'C' || type != 'F') {
                System.out.println("Invalid type; please enter 'C' or 'F'.");
            }
        } while (type != 'C' || type != 'F');
        return type;
    }

      // Converts temperature according to type and prints the result.
    public static void printConversion(char type, double temperature) {
        if (type == 'C') {
            double fahrenheit = temperature * 9.0 / 5.0 + 32;
            System.out.println(temperature + " C is " + fahrenheit + " F.");
        } else {
            double celsius = (temperature - 32) * 5.0 / 9.0;
            System.out.println(temperature + " F is " + celsius + " C.");
        }
    }
}
