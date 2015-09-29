package ee.ttu.idu1550.h3;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;

import com.google.java.contract.Requires;
import ee.ttu.idu1550.h3.Point;
import ee.ttu.idu1550.h3.PointFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mart Aarma on 29.09.2015.
 */

public class Route {

    private PointFactory pointFactory;
    private List<Point> route;

    @Ensures({"getRoute().size() == 0"})
    public Route() {
        pointFactory = new PointFactory();
        route = new ArrayList<Point>();
    }

    @Requires("index >= 0 && index <= getRoute().size()")
    @Ensures({"getRoute().get(index).getX() == x",
            "getRoute().get(index).getY() == y",
            "getRoute().size() == old(getRoute().size()) + 1"})
    public void addPoint(double x, double y, int index) {
        Point p = pointFactory.getPoint(x, y);
        route.add(index, p);
    }

    public double getLength() {
        if (route.size() <= 1) {
            return 0;
        }
        double distance = 0;
        for (int i = 0; i < route.size() - 1; i++) {
            distance += route.get(i).getDistance(route.get(i + 1));
        }
        return distance;
    }

    @Requires("index >= 0 && index <= getRoute().size()")
    @Ensures({"getRoute().size() == old(getRoute().size()) - 1"})
    public Point removePoint(int index) {
        return route.remove(index);
    }

    public List<Point> getRoute() {
        return route;
    }
}