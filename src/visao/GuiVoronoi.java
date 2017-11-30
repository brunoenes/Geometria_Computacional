/******************************************************************************
 *  Compilation:  javac Voronoi.java
 *  Execution:    java Voronoi
 *  Dependencies: Draw.java DrawListener.java
 * 
 *  Plots the points that the user clicks, and draws the Voronoi diagram.
 *  We assume the points lie on an M-by-M grid and use a brute force
 *  discretized algorithm. Each insertion takes time proportional to M^2.
 *
 *  Limitations
 *  -----------
 *    - Running time scales (badly) with M
 *    - Fortune's algorithm can compute a Voronoi diagram on N 
 *      points in time proportional to N log N, but it is 
 *      subtantially more complicated than this program which is intended
 *      to demonstrate callbacks and GUI operations.
 *
 ******************************************************************************/
package visao;

import java.awt.Color;
import edu.princeton.cs.introcs.Draw;
import edu.princeton.cs.introcs.DrawListener;
import modelo.Ponto;
import problemas.Problemas_Classicos;

public class GuiVoronoi implements DrawListener {
	private static int SIZE_X = 500;
	private static int SIZE_Y = 500;
	private Ponto[][] vetorPontos_tela = new Ponto[SIZE_X][SIZE_Y]; // matriz de pontos vazio para pegar os selecionados
	private Problemas_Classicos classicos = new Problemas_Classicos();
	private Draw draw = new Draw();

	public GuiVoronoi() {
		draw.setCanvasSize(SIZE_X, SIZE_Y);
		draw.setXscale(0, SIZE_X);
		draw.setYscale(0, SIZE_Y);
		draw.addListener(this);
		draw.show(20);
	}

	public void mousePressed(double x, double y) {
		// cria ponto pressionado pelo mouse
		Ponto pontoSelecionado = new Ponto((int) x, (int) y);

		// compara cada ponto da tela (coordX, coordY) e procura o ponto selecionado no
		// vetorPontos_Tela
		draw.setPenColor(Color.getHSBColor((float) Math.random(), .7f, .7f));

		// procura o ponto mais proximo do ponto da tela ( o meio dos 2)
		for (int coordX = 0; coordX < SIZE_X; coordX++) {
			for (int coordY = 0; coordY < SIZE_Y; coordY++) {
				Ponto ponto_tela = new Ponto(coordX, coordY);
				if ((vetorPontos_tela[coordX][coordY] == null)
						|| ((classicos.distanciaPontos(ponto_tela, pontoSelecionado)) < (classicos
								.distanciaPontos(ponto_tela, vetorPontos_tela[coordX][coordY])))) {
					vetorPontos_tela[coordX][coordY] = pontoSelecionado;
					draw.filledSquare(coordX + 0.5, coordY + 0.5, 0.5);
				}
			}
		}

		// desenha o ponto
		draw.setPenColor(Color.BLACK);
		draw.filledCircle(x, y, 4);
		draw.show(20);

	}


	// inicia a interface
	public static void main(String[] args) {
		new GuiVoronoi();
	}

	@Override
	public void mouseDragged(double x, double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(double x, double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(char c) {
		// TODO Auto-generated method stub
		
	}

}