public class Circle {
    private double radius = 1.0;
    private String color = "red";

    protected static final double PI = 3.14;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getArea() {
        return PI * radius * radius;
    }

    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color;
    }

    // getter, setter
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
