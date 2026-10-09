package Lab6;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Oops6a {
    public static void main(String[]args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("Labs/Lab6/numbers.dat"));

        int counter = 0;
        while(input.hasNext()) {
            input.next();
            counter++;
        }
        System.out.println("count = " + counter);
    }
}
