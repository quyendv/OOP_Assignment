package Week6.Polymorphism1;

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
    public String toString() {
        return String.format("Week9.Exception1.Square[side=%.1f,color=%s,filled=%b]",
                width, color, filled);
    }
}
