public class Oops4 {

  public static void main(String[] args) {
  int a = 7, b = 42;
          int min = minimum(a, b);
           if (min == a) {
               System.out.println("a is the smallest!");
           }else{
              System.out.print("b is smaller");
           }
            }
      

      public static int minimum(int a, int b) {
        if (a < b) {
          return a;
        }
        return b;
     }
    }
