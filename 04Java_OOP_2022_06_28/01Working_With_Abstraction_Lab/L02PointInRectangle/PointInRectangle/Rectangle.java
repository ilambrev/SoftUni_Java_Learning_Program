package PointInRectangle;

public class Rectangle {
    private Point A;
    private Point C;

    public Rectangle(Point A, Point C) {
        this.A = A;
        this.C = C;
    }

    public boolean contains(Point point) {

        return point.getX() >= this.A.getX() && point.getX() <= this.C.getX() &&
                point.getY() >= this.A.getY() && point.getY() <= this.C.getY();
    }

}