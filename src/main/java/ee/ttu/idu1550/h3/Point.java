package ee.ttu.idu1550.h3;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;

/**
 * Created by Mart Aarma on 29.09.2015.
 */
@Invariant({})
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
