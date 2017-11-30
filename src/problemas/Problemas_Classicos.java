package problemas;

import java.util.ArrayList;
import controle.TAD_SegmentoReta;
import modelo.Circulo;
import modelo.Poligono;
import modelo.Ponto;
import modelo.Reta;

public class Problemas_Classicos {

	public static double PI = 3.141516;
	TAD_SegmentoReta tad = new TAD_SegmentoReta();

	public Problemas_Classicos() {
		// TODO Auto-generated constructor stub

	}

	public double distanciaPontos(Ponto A, Ponto B) {
		return Math.sqrt(Math.pow((B.x - A.x), 2) + Math.pow((B.y - A.y), 2));
	}

	public double areaCriculo(Circulo c) {
		return PI * c.raio * c.raio;
	}

	public double areaPoligono(Poligono p) {

		double soma = 0;

		ArrayList<Ponto> aux = new ArrayList<>();

		aux.addAll(p.getPontos());

		for (int i = 0; i < aux.size() - 1; i++) {
			soma += (aux.get(i).x * aux.get(i + 1).y) - (aux.get(i + 1).x * aux.get(i).y);
		}
		soma /= 2;

		return Math.abs(soma);
	}

	public int convexidadePoligono(Ponto a, Ponto b, Ponto c) {
		// negativo = direita; positivo = esquerda; na reta = zero
		return (int) (a.x * b.y - a.y * b.x + a.y * c.x - a.x * c.y + b.x * c.y - c.x * b.y);
	}

	public boolean pontoDentroPoligono(Poligono p, Ponto c) {

		int i, j = p.getPontos().size() - 1;
		boolean oddNodes = false;

		for (i = 0; i < p.getPontos().size(); i++) {

			if ((p.getPontos().get(i).y < c.y) && (p.getPontos().get(j).y >= c.y)
					|| (p.getPontos().get(j).y < c.y) && (p.getPontos().get(i).y >= c.y)) {

				if (p.getPontos().get(i).x
						+ (c.y - p.getPontos().get(i).y) / (p.getPontos().get(j).y - p.getPontos().get(i).y)
								* (p.getPontos().get(j).x - p.getPontos().get(i).x) < c.x) {
					oddNodes = !oddNodes;
				}
			}
			j = i;

		}
		return oddNodes;
	}

	public int ladoCirculo(Circulo circulo, Ponto p) {

		double calculo = Math
				.sqrt((Math.pow((p.x - circulo.getCentro().x), 2) + Math.pow((p.y - circulo.getCentro().y), 2)));

		if (calculo > circulo.raio)
			return -1; // ponto externo
		else if (calculo < circulo.raio)
			return 1; // ponto interno
		else
			return 0; // ponto esta na circunferencia
	}

	public double distanciaPontoReta(Ponto p, Reta r) {

		double a = r.a;
		double b = r.b;
		double c = r.c;
		double x = p.x;
		double y = p.y;

		double resultado = (Math.abs((a * x) + (b * y) + (c))) / Math.sqrt((Math.pow(a, 2)) + (Math.pow(b, 2)));
		return resultado;

		/*
		 * double aux = (r.a * p.x) + (r.b * p.y) + r.c;
		 * 
		 * if (aux < 0) { aux = aux * -1; }
		 * 
		 * aux = aux / Math.sqrt(r.a * r.a + r.b * r.b);
		 * 
		 * return aux;
		 */
	}

	/*
	 * public Ponto pontoMaisProximoSegmentoReta(Ponto p, Reta r) {
	 * 
	 * double x; double y;
	 * 
	 * x = (-r.c + (r.a * p.x) - (p.y * r.b)) / (2 * r.a); y = -(r.a / r.b) * x -
	 * (r.c / r.b);
	 * 
	 * Ponto Ponto_X = new Ponto(x, y);
	 * 
	 * if ((Ponto_X.x > r.p1.x) && (Ponto_X.x < r.p2.y)) { return Ponto_X; } else if
	 * ((Ponto_X.x > r.p1.x) && (Ponto_X.x > r.p2.y)) { return r.p2; } else { return
	 * r.p1; }
	 * 
	 * }
	 */

	/*
	 * public Ponto pontoMaisProximoSegmentoReta(Ponto p, Reta r) {
	 * 
	 * Ponto A = tad.distanciaReta(r.p1, r.p2); Ponto B = tad.distanciaReta(r.p1,
	 * p);
	 * 
	 * double numerador = (A.x * B.x) + (A.y * B.y);
	 * 
	 * double t = numerador / Math.pow(Math.sqrt((A.x * A.x) + (B.x * B.x)), 2);
	 * 
	 * Ponto resultado = new Ponto();
	 * 
	 * resultado.x = r.p1.x + t * A.x; resultado.y = r.p1.y + t * A.y;
	 * 
	 * return resultado; }
	 */

	public Ponto pontoMaisProximoSegmentoReta(Ponto p, Reta r) {

		Reta r2 = new Reta(new Ponto(p.x, 0), new Ponto(p.x, 1));
		Reta r3 = new Reta(new Ponto(0, p.y), new Ponto(1, p.y));

		Ponto p1 = this.intersecaoSegmentosDeReta(r, r2);
		Ponto p2 = this.intersecaoSegmentosDeReta(r, r3);
		Ponto resultado = new Ponto();

		double a = Math.pow(10, 600) - Math.pow(10, 600);

		if (p1.x == a) {
			resultado = p2;
		} else if (p2.x == a) {
			resultado = p1;
		} else {
			resultado.x = (p1.x + p2.x) / 2;
			resultado.y = (p1.y + p2.y) / 2;
		}

		if (resultado.x > r.p2.x) {
			resultado.x = r.p2.x;
			resultado.y = r.p2.y;
		} else if (resultado.x < r.p1.x) {
			resultado.x = r.p1.x;
			resultado.y = r.p1.y;
		}

		return resultado;

	}

	public Ponto intersecaoSegmentosDeReta(Reta A, Reta B) {

		double det;

		det = (B.p2.x - B.p1.x) * (A.p2.y - A.p1.y) - (B.p2.y - B.p1.y) * (A.p2.x - A.p1.x);

		if (det == 0.0)
			return null; // não há intersecção
		else {

			double s, t;

			s = ((B.p2.x - B.p1.x) * (B.p1.y - A.p1.y) - (B.p2.y - B.p1.y) * (B.p1.x - A.p1.x)) / det;
			t = ((A.p2.x - A.p1.x) * (B.p1.y - A.p1.y) - (A.p2.y - A.p1.y) * (B.p1.x - A.p1.x)) / det;

			Ponto intersecao = new Ponto();
			intersecao.x = A.p1.x + (A.p2.x - A.p1.x) * s;
			intersecao.y = A.p1.y + (A.p2.y - A.p1.y) * s;

			return intersecao;

		}
	}

	public double predicadoOrientacao(Ponto A, Ponto B, Ponto C) {

		double soma = (A.x * B.y * 1) + (B.x * C.y * 1) + (C.x * A.y * 1);
		double sub = -(C.x * B.y * 1) - (A.x * C.y * 1) - (B.x * A.y * 1);
		return (soma + sub);

	}

}
