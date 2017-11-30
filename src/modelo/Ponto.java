package modelo;

public class Ponto implements Comparable<Ponto> {

	public double x;
	public double y;
	public double hash_ponto;

	public Ponto() {

	}

	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
		this.hash_ponto = this.geraHashPonto(x, y);
	}

	public double getX() {
		return x;
	}

	public void setX(double d) {
		this.x = d;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getHash_ponto() {
		return hash_ponto;
	}

	public void setHash_ponto(double hash_ponto) {
		this.hash_ponto = hash_ponto;
	}

	public double distance(Ponto p) {
		return Math.hypot(x - p.x, y - p.y);
	}

	// Signed area / determinant thing
	public double cross(Ponto p) {
		return x * p.y - y * p.x;
	}

	public Ponto subtract(Ponto p) {
		return new Ponto(x - p.x, y - p.y);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(hash_ponto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ponto other = (Ponto) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	public double geraHashPonto(double x, double y) {

		double resultado = x * 7 + y * 3;

		return resultado % 13;

	}

	@Override
	public int compareTo(Ponto o) {

		if (x < o.x) {
			return -1;
		} else if (x == o.x) {
			if (y < o.y) {
				return -1;
			} else if (y == o.y) {
				return 0;
			} else
				return 1;
		} else
			return 1;

	}

}
