public class Lab2_3 {

    public static void main(String[] args) {
       int maxOdd = 21;
       writeOdds(maxOdd);

       maxOdd = 11;
       writeOdds(maxOdd);

    }
    public static void writeOdds(int maxOdd) {
       for (int i = 1; i <= maxOdd; i += 2) {
          System.out.print(i + " ");
       }
       System.out.println();
    }
}
