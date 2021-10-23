package Week8.Interface;

public class Triangle implements GeometricObject {
    private Point p1;
    private Point p2;
    private Point p3;

    /**
     * Constructor.
     *
     * @param p1 p1
     * @param p2 p2
     * @param p3 p3
     */
    public Triangle(Point p1, Point p2, Point p3) throws RuntimeException {
        // double a = p1.distance(p2);
        // double b = p2.distance(p3);
        // double c = p3.distance(p1);
        // if (a == 0 || b == 0 || c == 0 || a + b == c || c + b == a || a + c == b) {
        //     throw new RuntimeException();
        // }

        double a = p3.getPointY() - p2.getPointY();
        double b = p2.getPointY() - p1.getPointY();
        double c = p3.getPointX() - p2.getPointX();
        double d = p2.getPointX() - p1.getPointX();
        if (p1 == p2 || p2 == p3 || p3 == p1
                || a * d == b * c) {
            throw new RuntimeException();
        }

        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    @Override
    public double getArea() {
        return Math.abs(p1.getPointX() * (p2.getPointY() - p3.getPointY())
                + p2.getPointX() * (p3.getPointY() - p1.getPointY())
                + p3.getPointX() * (p1.getPointY() - p2.getPointY())) / 2;
    }

    @Override
    public double getPerimeter() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    @Override
    public String getInfo() {
        return String.format("Week8.Interface.Triangle[(%.2f,%.2f),(%.2f,%.2f),(%.2f,%.2f)]",
                p1.getPointX(), p1.getPointY(),
                p2.getPointX(), p2.getPointY(),
                p3.getPointX(), p3.getPointY());
    }
}
