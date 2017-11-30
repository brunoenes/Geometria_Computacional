package modelo;

public class Reta {
	
	public Ponto p1;
	public Ponto p2;
	public double a;
	public double b;
	public double c;
	
	public Reta() {
		// TODO Auto-generated constructor stub
	}
	
	public Reta(Ponto p1, Ponto p2) {
		this.p1 = p1;
		this.p2 = p2;
		
		this.a = p1.y - p2.y;
		this.b = p2.x - p1.x;
		this.c = (p1.x * p2.y ) - (p2.x * p1.y );		
		
	}
	
	

}
