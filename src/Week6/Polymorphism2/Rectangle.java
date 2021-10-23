package Week6.Polymorphism2;

import java.util.Objects;

public class Rectangle extends Shape {
    protected Point topLeft;
    protected double width;
    protected double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /**
     * Constructor.
     *
     * @param width  w
     * @param length l
     * @param color  c
     * @param filled f
     */
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public Rectangle(Point topLeft, double width, double length, String color, boolean filled) {
        this(width, length, color, filled);
        this.topLeft = topLeft;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Rectangle)) {
            return false;
        }
        return topLeft.equals(((Rectangle) other).getTopLeft())
                && width  == ((Rectangle) other).getWidth()
                && length == ((Rectangle) other).getLength();
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, width, length);
    }

    @Override
    public String toString() {
        return String.format("Rectangle[topLeft=%s,width=%.1f,length=%.1f,color=%s,filled=%b]",
                topLeft.toString(), width, length, color, filled);
    }
}
