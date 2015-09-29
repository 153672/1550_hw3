package ee.ttu.idu1550.h3;

import static java.lang.Math.*;

/**
 * Created by Mart Aarma on 29.09.2015.
 */
public class CartesianPoint implements Point {

    private double x;
    private double y;

    public CartesianPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getRho() {
        return sqrt(pow(this.getX(), 2) + pow(this.getY(), 2));
    }

    @Override
    public double getTheta() {
        return atan2(this.y, this.x);
    }

    @Override
    public double getDistance(Point other) {
        return vectorTo(other).getRho();
    }

    @Override
    public Point vectorTo(Point other) {
        return new CartesianPoint(other.getX() - this.getX(), other.getY() - this.getY());
    }

    @Override
    public void rotate(Point p, double angle) {
        translate(-p.getX(), -p.getY());
        centerRotate(angle);
        translate(p.getX(), p.getY());
    }

    @Override
    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void scale(double factor) {
        this.x *= factor;
        this.y *= factor;
    }

    @Override
    public void centerRotate(double angle) {
        double temp_x = getRho() * cos(getTheta() + angle);
        double temp_y = getRho() * sin(getTheta() + angle);
        this.x = temp_x;
        this.y = temp_y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "x: " + getX() + " y: " + getY() + " rho: " + getRho() + " theta: " + getTheta();
     }
}
