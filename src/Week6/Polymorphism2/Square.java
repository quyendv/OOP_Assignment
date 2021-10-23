package Week6.Polymorphism2;

import java.util.Objects;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    /**
     * Constructor.
     * @param side s
     * @param color c
     * @param filled f
     */
    public Square(double side, String color, boolean filled) {
        super(side, side);
        this.color = color;
        this.filled = filled;
    }

    public Square(Point topLeft, double side, String color, boolean filled) {
        this(side, color, filled);
        this.topLeft = topLeft;
    }

    public double getSide() {
        return length;
    }

    public void setSide(double side) {
        this.width = side;
        this.length = side;
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Square)) {
            return false;
        }
        return topLeft.equals(((Square) o).getTopLeft())
                && width == ((Square) o).getWidth()
                && length == ((Square) o).getLength();
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, width, length);
    }

    @Override
    public String toString() {
        return String.format("Square[topLeft=%s,side=%.1f,color=%s,filled=%b]",
                topLeft.toString(), width, color, filled);
    }
}
