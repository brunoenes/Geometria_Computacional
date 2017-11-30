package modelo;

public class Circulo {

	public Ponto centro;
	public int raio;

	public Circulo() {
		
	}

	public Circulo(Ponto centro, int raio) {
		this.centro = centro;
		this.raio = raio;
	}

	// ver classe Quadrado
	public String toString() {
		return "C:" + centro + " R:" + raio;
	}

	public Ponto getCentro() {
		return centro;
	}

	public void setCentro(Ponto centro) {
		this.centro = centro;
	}

	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}

}
