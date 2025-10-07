package rectangle;

public class Rectangle {
    double width;
    double height;

    public double area() {
        return width * height;
    }

    public double perimetar() {
        return 2 * (width + height);
    }

    public double diagonal() {
        double sqrt = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
        return sqrt;
    }
}
