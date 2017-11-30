package modelo;

import java.util.HashMap;

public class Conjunto {

	public HashMap<Double, SubConjunto> conjunto;

	public Conjunto() {
		this.conjunto = new HashMap<>();
	}

	public HashMap<Double, SubConjunto> getConjunto() {
		return conjunto;
	}

	public void setConjunto(HashMap<Double, SubConjunto> conjunto) {
		this.conjunto = conjunto;
	}
}
