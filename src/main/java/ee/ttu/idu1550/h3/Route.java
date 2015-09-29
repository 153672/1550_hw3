package ee.ttu.idu1550.h3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mart Aarma on 29.09.2015.
 */
public class Route {

	private PointFactory pointFactory;
	private List<Point> route;

	public Route(){
        pointFactory = new PointFactory();
        route = new ArrayList<Point>();
	}

	public void addPoint(double x, double y, int index){
        Point p = pointFactory.getPoint(x,y);
        route.add(index,p);
	}

	public double getLength(){
        if(route.size() <= 1) {
            return 0;
        }
        double distance = 0;
        for(int i = 0; i < route.size() - 1; i++) {
            distance += route.get(i).getDistance(route.get(i+1));
        }
		return distance;
	}

	public Point removePoint(int index){
        return route.remove(index);
	}
}