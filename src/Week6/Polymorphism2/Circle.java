package Week6.Polymorphism2;

import java.util.Objects;

public class Circle extends Shape {

    protected Point center;
    protected double radius;

    /**
     * Constructor.
     */
    public Circle() {
    }

    /**
     * Constructors.
     * @param radius default radius
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Constructor.
     * @param radius r
     * @param color c
     * @param filled f
     */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    /**
     * Constructor.
     * @param center c
     * @param radius r
     * @param color c
     * @param filled f
     */
    public Circle(Point center, double radius, String color, boolean filled) {
        this(radius, color, filled);
        this.center = center;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Circle)) {
            return false;
        }
        return radius == ((Circle) o).getRadius()
                && center.equals(((Circle) o).getCenter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, center);
    }

    @Override
    public String toString() {
        return String.format("Circle[center=%s,radius=%.1f,color=%s,filled=%b]",
                center.toString(), radius, color, filled);
    }
}
