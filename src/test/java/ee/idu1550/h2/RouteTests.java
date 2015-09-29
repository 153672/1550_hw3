package ee.idu1550.h2;

import ee.ttu.idu1550.h3.Point;
import ee.ttu.idu1550.h3.Route;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mart Aarma on 13.09.2015.
 */
public class RouteTests {

    public static final double DELTA = 0.01;
    private Route route;


    @Before
    public void setUp() {
        route = new Route();
    }

    @Test
    public void testRouteCreation() {
        Route route = new Route();
        assertEquals(route.getLength(), 0, 0);
    }

    @Test
    public void testAddPoint() {
        Route route = new Route();
        route.addPoint(1,2,0);
        assertEquals(route.getLength(), 0, 0);
    }

    @Test
    public void testDistance() {
        Route route = new Route();
        route.addPoint(1,1,0);
        route.addPoint(1,20,1);
        route.addPoint(40,1,1);
        assertEquals(82.38, route.getLength(), DELTA);
    }

    @Test
    public void testOrder() {
        Route route = new Route();
        route.addPoint(1,1,0);
        route.addPoint(1,20,1);
        route.addPoint(40,1,2);

        Point p = route.removePoint(1);
        assertEquals(1, p.getX(),0);
        assertEquals(20, p.getY(),0);
        assertEquals(39, route.getLength(), DELTA);
    }
}
