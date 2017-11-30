package teste;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import controle.TAD_Conjuntos;
import controle.TAD_Ponto;
import modelo.Conjunto;
import modelo.Poligono;
import modelo.Ponto;
import modelo.SubConjunto;
import problemas.Problemas_Classicos;

public class TestePonto {

	private static TAD_Conjuntos tad = new TAD_Ponto();
	private static Problemas_Classicos classicos = new Problemas_Classicos();

	public static void ordena(String[] vetor) {
		Arrays.sort(vetor);
		System.out.println("Passou");
	}

	public static void main(String[] args) {

		/*
		 * TAD_Conjuntos ordenado = new TAD_Ponto_Ordenado();
		 * 
		 * try { Method metodo = Principal.class.getDeclaredMethod("ordena",
		 * String[].class);
		 * 
		 * Method[] m = Principal.class.getDeclaredMethods();
		 * 
		 * for (Method m1 : m) { System.out.println(m1.getName());
		 * 
		 * }
		 * 
		 * String[] vetor = { "Maria", "José" };
		 * 
		 * ordenado.chamada(m,"ordena" , vetor);
		 * 
		 * ordenado.chamada(metodo, vetor);
		 * 
		 * } catch (NoSuchMethodException | SecurityException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		SubConjunto subConjunto1 = new SubConjunto(true);

		// ************** Operação em SubConjuntos ***********************//

		Ponto ponto = new Ponto(2.1, 1);
		tad.insertS(subConjunto1, ponto);

		ponto = new Ponto(2, 1);
		tad.insertS(subConjunto1, ponto);

		ponto = new Ponto(4, 2);
		tad.insertS(subConjunto1, ponto);

		ponto = new Ponto(3, 3);
		tad.insertS(subConjunto1, ponto);

		ponto = new Ponto(1, 1);
		tad.insertS(subConjunto1, ponto);

		Iterator<Object> iterator = subConjunto1.getLista_ordenada().iterator();
		Ponto aux = new Ponto();
		while (iterator.hasNext()) {
			aux = (Ponto) iterator.next();
			System.out.println("Ponto X: " + aux.getX() + "  Ponto Y: " + aux.getY());
		}
		System.out.println();
		System.out.println();

		// operaçao member
		aux = new Ponto(4, 2);
		System.out.println("Contem : " + tad.memberS(subConjunto1, aux));

		// operação delete
		System.out.println("Delete : " + tad.deleteS(subConjunto1, aux));

		iterator = subConjunto1.getLista_ordenada().iterator();
		while (iterator.hasNext()) {
			aux = (Ponto) iterator.next();
			System.out.println("Ponto X: " + aux.getX() + "  Ponto Y: " + aux.getY());
		}
		System.out.println();

		// *********************** Operação em Conjuntos
		// ********************************//
		System.out.println("//*********************** Operação em Conjuntos ********************************//");

		Conjunto conjunto1 = new Conjunto();

		// operação insertC
		tad.insertC(conjunto1, subConjunto1);

		for (SubConjunto sub : conjunto1.getConjunto().values()) {

			System.out.println("Conjunto ");
			System.out.println("Hash Conjunto = " + sub.getHash_subconjunto());
			iterator = sub.getLista_ordenada().iterator();
			while (iterator.hasNext()) {
				aux = (Ponto) iterator.next();
				System.out.println("Ponto X: " + aux.getX() + "  Ponto Y: " + aux.getY());
			}
			System.out.println("**************************");
			System.out.println();
			System.out.println();
		}

		SubConjunto subConjunto2 = new SubConjunto(false);

		Ponto ponto2 = new Ponto(2.1, 1);
		tad.insertS(subConjunto2, ponto2);

		ponto2 = new Ponto(2, 1);
		tad.insertS(subConjunto2, ponto2);

		ponto2 = new Ponto(4, 3);
		tad.insertS(subConjunto2, ponto2);

		ponto2 = new Ponto(3, 3);
		tad.insertS(subConjunto2, ponto2);

		ponto2 = new Ponto(6, 3);
		tad.insertS(subConjunto2, ponto2);

		iterator = subConjunto2.getLista().iterator();
		aux = new Ponto();
		System.out.println("SubConjunto 2");
		while (iterator.hasNext()) {
			aux = (Ponto) iterator.next();
			// System.out.println(iterator.next().getY());
			System.out.println("Ponto X: " + aux.getX() + "  Ponto Y: " + aux.getY());
		}
		System.out.println();
		System.out.println();

		tad.insertC(conjunto1, subConjunto2);

		for (SubConjunto sub : conjunto1.getConjunto().values()) {

			System.out.println("Conjunto ");
			System.out.println("Hash Conjunto = " + sub.getHash_subconjunto());

			if (sub.ordenado)
				iterator = sub.getLista_ordenada().iterator();
			else
				iterator = sub.getLista().iterator();
			while (iterator.hasNext()) {
				aux = (Ponto) iterator.next();
				System.out.println("Ponto X: " + aux.getX() + "  Ponto Y: " + aux.getY());
			}
			System.out.println("**************************");
			System.out.println();
			System.out.println();
		}

		// operação memberC
		System.out.println("Contem subConjunto = " + tad.memberC(conjunto1, subConjunto2));

		// operação findC
		aux = new Ponto(3, 3);
		SubConjunto sub_aux = tad.findC(conjunto1, aux);
		if (sub_aux == null)
			System.out.println("Ponto nao existe");
		else
			System.out.println("Find C = " + sub_aux.getHash_subconjunto());

		// operação deleteC
		sub_aux = new SubConjunto(false);
		aux = new Ponto(2, 1);
		tad.insertS(sub_aux, aux);
		System.out.println("Delete C = " + tad.deleteC(conjunto1, sub_aux));

		// operação uniao
		sub_aux = tad.union(subConjunto1, subConjunto2);
		if (sub_aux.ordenado)
			iterator = sub_aux.getLista_ordenada().iterator();
		else
			iterator = sub_aux.getLista().iterator();

		aux = new Ponto();
		System.out.println("SubConjunto 2");
		while (iterator.hasNext()) {
			aux = (Ponto) iterator.next();
			// System.out.println(iterator.next().getY());
			System.out.println("Ponto X: " + aux.getX() + "  Ponto Y: " + aux.getY());
		}
		System.out.println();
		System.out.println();

		// operação diferença
		sub_aux = tad.difference(subConjunto1, subConjunto2);
		if (sub_aux.ordenado)
			iterator = sub_aux.getLista_ordenada().iterator();
		else
			iterator = sub_aux.getLista().iterator();
		aux = new Ponto();
		System.out.println("SubConjunto 2");
		while (iterator.hasNext()) {
			aux = (Ponto) iterator.next();
			// System.out.println(iterator.next().getY());
			System.out.println("Ponto X: " + aux.getX() + "  Ponto Y: " + aux.getY());
		}
		System.out.println();
		System.out.println();

		// operação intersection
		sub_aux = tad.intersection(subConjunto1, subConjunto2);
		if (sub_aux.ordenado)
			iterator = sub_aux.getLista_ordenada().iterator();
		else
			iterator = sub_aux.getLista().iterator();
		aux = new Ponto();
		System.out.println("SubConjunto 2");
		while (iterator.hasNext()) {
			aux = (Ponto) iterator.next();
			// System.out.println(iterator.next().getY());
			System.out.println("Ponto X: " + aux.getX() + "  Ponto Y: " + aux.getY());
		}
		System.out.println();
		System.out.println();

		// minS
		Ponto x = (Ponto) tad.minS(subConjunto2);
		if (x == null) {
			System.out.println("Desodernado");
		} else {
			System.out.println(x.x + " - " + x.y);
		}

		// split
		Conjunto c = tad.splitS(subConjunto1, new Ponto(2.1,1));

		if (c == null) {
			System.out.println("Ponto nao encontrado");
		} else {

			for (SubConjunto sub : c.getConjunto().values()) {

				System.out.println("Conjunto ");
				System.out.println("Hash Conjunto = " + sub.getHash_subconjunto());

				if (sub.ordenado)
					iterator = sub.getLista_ordenada().iterator();
				else
					iterator = sub.getLista().iterator();

				while (iterator.hasNext()) {
					aux = (Ponto) iterator.next();
					System.out.println("Ponto X: " + aux.getX() + "  Ponto Y: " + aux.getY());
				}
				System.out.println("**************************");
				System.out.println();
				System.out.println();
			}

		}
		// problemas classicos
		
		// predicado orientacao 2D
		System.out.println(classicos.predicadoOrientacao(new Ponto(1,1),new Ponto(3,3),new Ponto(2,1) ));
		
		
		
		// distancia entre 2 pontos
		System.out.println(classicos.distanciaPontos(new Ponto(-2, 4), new Ponto(1,2)));

		Vector<Ponto> vetor = new Vector<Ponto>();

		ponto2 = new Ponto(2, 5);
		vetor.addElement(ponto2);

		ponto2 = new Ponto(6, 2);
		vetor.addElement(ponto2);

		ponto2 = new Ponto(-3, -4);
		vetor.addElement(ponto2);

		ponto2 = new Ponto(-2, 4);
		vetor.addElement(ponto2);

		ponto2 = new Ponto(2, 5);
		vetor.addElement(ponto2);

		ponto2 = new Ponto(-1, -2);
		vetor.addElement(ponto2);

		ponto2 = new Ponto(-3, -5);
		vetor.addElement(ponto2);

		ponto2 = new Ponto(3, -3);
		vetor.addElement(ponto2);

		Poligono poligono = new Poligono(vetor);

		System.out.println(classicos.areaPoligono(poligono));

		System.out.println(classicos.pontoDentroPoligono(poligono, new Ponto(6, 2)));

		System.out.println(classicos.convexidadePoligono(new Ponto(1, 7), new Ponto(7, 7), new Ponto(3, 8)));

	}

	public void nome(String nome) {
		System.out.println(nome);
	}

}
