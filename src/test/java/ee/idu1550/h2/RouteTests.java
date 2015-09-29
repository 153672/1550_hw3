package ee.idu1550.h2;

import ee.ttu.idu1550.h3.Point;
import ee.ttu.idu1550.h3.Route;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Mart Aarma on 13.09.2015.
 */
public class RouteTests {

    public static final double DELTA = 0.01;

    @Before
    public void setUp() {

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
        Point p = route.removePoint(0);
        assertEquals(1, p.getX(), 0);
        assertEquals(2, p.getY(), 0);
    }

    @Test
    public void testOrder() {
        Route routeA = new Route();
        routeA.addPoint(1, 1, 0);
        routeA.addPoint(1, 20, 1);
        routeA.addPoint(40, 1, 2);

        Route routeB = new Route();
        routeB.addPoint(1, 1, 0);
        routeB.addPoint(40, 1, 1);
        routeB.addPoint(1, 20, 2);

        assertNotEquals(routeA.getLength(), routeB.getLength(), DELTA);
    }

    @Test
    public void testDistance() {
        Route route = new Route();
        route.addPoint(1,1,0);
        route.addPoint(40,1,1);
        assertEquals(39, route.getLength(), DELTA);
    }
}
