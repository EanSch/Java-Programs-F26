package Assignments.Assignment1;
public class Assignment1_2 {
    public static void main(String[] args) {
       
        // In order to create the second figure, all we have to do is change the height = 8 
        //Defining height and width
        int height = 4;

        int width = 4 * height - 2;

        //Defining formula backslashes and exclaimation marks
        for (int row = 1; row <= height; row++) {
            int bs = 2 * (row - 1);
            int ex = width - (bs * 2);

            //Printing baclslashes
            for (int i = 0; i <= bs; i++) {
                System.out.print("\\");
            }
            //Printing exclamation marks
            for (int i = 0; i < ex; i++) {
                System.out.print("!");
            }
            //Printing backslashes
            for (int i = 0; i <= bs; i++) {
                System.out.print("/");
            }
            System.out.println();
        }
    }
}
