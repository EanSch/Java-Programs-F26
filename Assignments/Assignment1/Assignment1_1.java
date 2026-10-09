package Assignments.Assignment1;
public class Assignment1_1 {
    
    public static void main(String[] args) {
        for(int i = 1; i <= 9; i+= 2) {

            //Print dashes on left
            for(int j = 1; j <= (5 - i / 2); j++) {
                System.out.print("-");
            }
            //Print the numbers
            for(int j = 1; j <= i; j++) {
                System.out.print(i);
            }

            //Print dashes on right
            for(int j = 1; j <= (5 - i / 2); j++) {
                System.out.print("-");
        }
            System.out.println();
        }
    }
    
}