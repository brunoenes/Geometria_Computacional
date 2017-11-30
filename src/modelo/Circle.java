package modelo;

import java.util.Collection;


public class Circle {
	
	private static final double MULTIPLICATIVE_EPSILON = 1 + 1e-14;

	public final Ponto c; // Center
	public final double r; // Radius
	
	

	public Circle(Ponto c, double r) {
		this.c = c;
		this.r = r;
	}
	
	public Circle() {
		this.c = new Ponto();
		this.r = 0; 
	}
	
	public Ponto getPonto() {
		return this.c;
	}

	public boolean contains(Ponto p) {
		return c.distance(p) <= r * MULTIPLICATIVE_EPSILON;
	}

	public boolean contains(Collection<Ponto> ps) {
		for (Ponto p : ps) {
			if (!contains(p))
				return false;
		}
		return true;
	}
	
	public double getRaio() {
		return this.r;
	}

	public String toString() {
		return String.format("Circle(x=%g, y=%g, r=%g)", c.x, c.y, r);
	}


}
