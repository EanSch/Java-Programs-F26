package Lab4;
public class Temperature {
    public static void main(String[] args) {
        double tempf = 98.6;
        double tempc = 0.0;
        tempc = ftoc(tempf);
        System.out.println("Celcius temperature is: " + tempc);
    }

public static double ftoc(double tempf) {
        return (tempf-32) * 5 / 9;
    }
}