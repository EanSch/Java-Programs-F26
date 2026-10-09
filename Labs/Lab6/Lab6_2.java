package Lab6;

import java.util.Scanner;

public class Lab6_2 {
    public static void process(Scanner input) {
        while (input.hasNext()) {
            String name = input.next();
            double sum = 0.0;
            while (input.hasNext()) {
                sum += input.nextDouble();
            }
            System.out.println(name + " = " + sum);
        }
    }
}
