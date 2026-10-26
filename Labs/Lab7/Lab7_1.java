package Lab7;

import java.util.Scanner;

public class Lab7_1 {
     public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Howm any days?: ");
        int numDays = console.nextInt();
        int[] temps = new int[numDays];
        int sum = 0;
        for (int i = 0; i <= numDays; i++) {
            System.out.print("high temp: ");
            temps[i] = console.nextInt();
            sum += temps[i];
        }
        System.out.println("Average = " + (double) sum / numDays);
}
}