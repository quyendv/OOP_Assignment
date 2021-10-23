package Week8.Interface;

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

    public String getInfo() {
        return String.format("Week8.Interface.Point[%.2f,%.2f]", pointX, pointY);
    }

    public double distance(Point other) {
        return Math.sqrt(Math.pow(pointX - other.getPointX(), 2)
                + Math.pow(pointY - other.getPointY(), 2));
    }
}
