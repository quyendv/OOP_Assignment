package Week6.Polymorphism2;

import java.util.Objects;

public class Point {
    private double pointX;
    private double pointY;

    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }


    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public double distance(Point other) {
        return Math.sqrt(pointX * other.getPointX() + pointY * other.getPointY());
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Point)) {
            return false;
        }
        return pointX == ((Point) other).getPointX() && pointY == ((Point) other).getPointY();
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(pointX, pointY);
    }

    public String toString() {
        return String.format("(%.1f,%.1f)", pointX, pointY);
    }
}
