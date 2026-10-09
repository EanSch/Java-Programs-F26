package Lab4;


public class Lab4_3 {

    public static void main(String[] args){
        int n1 = 3;
        int n2 = 7;
        int n3 = 11;
        printNumOdd(n1, n2, n3);
    }

    
    public static void printNumOdd(int n1, int n2, int n3) {
        int count = 0;
        if (n1 % 2 != 0) {
            count++;
        }
        if (n2 % 2 != 0){
            count++;
        }
        if (n3 % 2 != 0){
            count++;
        }
    System.out.println(count + " of the 3 numbers are odd");
    
        
    
    }
}
