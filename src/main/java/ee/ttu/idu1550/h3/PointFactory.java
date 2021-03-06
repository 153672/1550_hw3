package ee.ttu.idu1550.h3;

import com.google.java.contract.Invariant;

/**
 * Created by Mart Aarma on 29.09.2015.
 */
@Invariant({})
public class PointFactory {

	public PointFactory(){

	}

	public Point getPoint(double x, double y){
		return new CartesianPoint(x,y);
	}

	public Point getPointByRhoAndTheta(double rho, double theta){
		return new PolarPoint(rho, theta);
	}

}