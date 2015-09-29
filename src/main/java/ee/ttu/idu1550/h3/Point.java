package ee.ttu.idu1550.h3;

/**
 * Created by Mart Aarma on 29.09.2015.
 */
public interface Point {

    double getX();

    double getY();

    double getRho();

    double getTheta();

    double getDistance(Point other);

    Point vectorTo(Point other);

    void rotate(Point p, double angle);

    void translate(double dx, double dy);

    void centerRotate(double angle);

    void scale(double factor);
}
