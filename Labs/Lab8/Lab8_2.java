package Lab8;

public class Lab8_2 {
    int x;
    int y;

    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }
    public void translate (int dx, int dy) {
        x = dx;
        y = dy;
    }
}
