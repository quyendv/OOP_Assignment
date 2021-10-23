package Week6.Polymorphism2;

public abstract class Shape {
    protected String color;
    protected boolean filled;

    /**
     * Constructor.
     */
    public Shape() {
    }

    /**
     * Constructor.
     * @param color c
     * @param filled f
     */
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // getter, setter.
    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return this.filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }


    /**
     * Abstract S.
     * @return Area
     */
    public abstract double getArea();

    /**
     * Abstract P.
     * @return perimeter
     */
    public abstract double getPerimeter();

    /**
     * Convert shape toString.
     * @return string
     */
    public String toString() {
        return "Shape[color=" + color + ",filled=" + filled + "]";
    }
}
