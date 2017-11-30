package modelo;

import java.util.Vector;

public class Poligono {

	public Vector<Ponto> pontos;

	public Poligono() {
		pontos = new Vector<>();
	}

	public Poligono(Ponto pts[]) {
		this();
		for (int i = 0; i < pts.length; i++)
			pontos.addElement(new Ponto(pts[i].x, pts[i].y));
	}

	/** Constroi um poligono a partir de um vetor (Vector) de pontos. */
	public Poligono(Vector<Ponto> v) {
		this();
		for (int i = 0; i < v.size(); i++)
			pontos.addElement(new Ponto(v.get(i).x,v.get(i).y));
	}

	/** Insere um ponto como ultimo vertice do poligono. */
	public void insereVertice(Ponto a) {
		pontos.addElement(new Ponto(a.x, a.y));
	}

	/** Insere um ponto a partir de suas coordenadas. */
	public void insereVertice(int x, int y) {
		insereVertice(new Ponto(x, y));
	}

	/** Insere um ponto em uma dada posicao do poligono. */
	public void insereVerticeEm(Ponto p, int ind) {
		pontos.insertElementAt(p, ind);
	}

	/** Remove vertice de uma dada posicao do poligono, devolvendo-o. */
	public Ponto removeVerticeDe(int ind) {
		Ponto x = new Ponto(pontos.elementAt(ind).x, pontos.elementAt(ind).y);
		pontos.removeElementAt(ind);
		return x;
	}

	/** Remove o ultimo vertice do poligono, devolvendo-o. */
	public Ponto removeVertice() {
		return pontos.remove(pontos.size());
	}

	/** Retorna um vertice de uma dada posicao do poligono. */
	public Ponto verticeDe(int ind) {
		return pontos.get(ind);
	}

	/** Retorna o ultimo vertice do poligono. */
	public Ponto ultimoVertice() {
		return (verticeDe(tamanho() - 1));
	}

	/** Retorna a quantidade de vertices do poligono. */
	public int tamanho() {
		return pontos.size();
	}

	public Vector<Ponto> getPontos() {
		return pontos;
	}

	/** Constroi um poligono a partir de um vetor (array) de pontos. */
	public void setPontos(Vector<Ponto> pontos) {
		this.pontos = pontos;
	}

}
