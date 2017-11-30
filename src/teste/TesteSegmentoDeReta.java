package teste;

import java.util.Iterator;

import controle.TAD_Conjuntos;
import controle.TAD_SegmentoReta;
import modelo.Conjunto;
import modelo.Ponto;
import modelo.SegmentoDeReta;
import modelo.SubConjunto;

public class TesteSegmentoDeReta {

	private static TAD_Conjuntos tad = new TAD_SegmentoReta();

	public static void main(String[] args) {

		SubConjunto subConjunto1 = new SubConjunto(true);

		// ************** Operação em SubConjuntos ***********************//
		
		System.out.println("*********** inserindo ***********************");
		SegmentoDeReta seg = new SegmentoDeReta(new Ponto(4, 4), new Ponto(6, 6));
		tad.insertS(subConjunto1, seg);

		seg = new SegmentoDeReta(new Ponto(2, 4), new Ponto(7, 8));
		tad.insertS(subConjunto1, seg);

		seg = new SegmentoDeReta(new Ponto(1, 1), new Ponto(2, 3));
		tad.insertS(subConjunto1, seg);

		seg = new SegmentoDeReta(new Ponto(8, 9), new Ponto(10, 10));
		tad.insertS(subConjunto1, seg);

		seg = new SegmentoDeReta(new Ponto(5, 2), new Ponto(2, 1));
		tad.insertS(subConjunto1, seg);

		Iterator<Object> iterator = subConjunto1.getLista_ordenada().iterator();
		SegmentoDeReta aux = new SegmentoDeReta();
		while (iterator.hasNext()) {
			aux = (SegmentoDeReta) iterator.next();
			System.out.print("Ponto 1: " + aux.getP1().getX() + "  Ponto Y: " + aux.getP1().getY());
			System.out.println(" -- Ponto 2: " + aux.getP2().getX() + "  Ponto Y: " + aux.getP2().getY());
		}
		System.out.println("**************************");
		System.out.println();
		System.out.println();

		// operaçao member
		aux = new SegmentoDeReta(new Ponto(8, 7), new Ponto(10, 10));
		System.out.println("Contem : " + tad.memberS(subConjunto1, aux));
		System.out.println("**************************");
		System.out.println();
		// operação delete
		System.out.println("Delete : " + tad.deleteS(subConjunto1, aux));
		System.out.println("**************************");
		System.out.println();
		
		System.out.println("***********Depois do Delete***************");
		System.out.println();
		iterator = subConjunto1.getLista_ordenada().iterator();
		while (iterator.hasNext()) {
			aux = (SegmentoDeReta) iterator.next();
			System.out.print("Ponto 1: " + aux.getP1().getX() + "  Ponto Y: " + aux.getP1().getY());
			System.out.println(" -- Ponto 2: " + aux.getP2().getX() + "  Ponto Y: " + aux.getP2().getY());
		}
		System.out.println("**************************");
		System.out.println();

		// *********** Operação em Conjuntos **********************//
		System.out.println("//*********************** Operação em Conjuntos ********************************//");

		Conjunto conjunto1 = new Conjunto();

		// operação insertC
		tad.insertC(conjunto1, subConjunto1);
		System.out.println("************Inserir no Conjunto**************");
		for (SubConjunto sub : conjunto1.getConjunto().values()) {

			System.out.println("Conjunto ");
			System.out.println("Hash Conjunto = " + sub.getHash_subconjunto());
			iterator = sub.getLista_ordenada().iterator();
			while (iterator.hasNext()) {
				aux = (SegmentoDeReta) iterator.next();
				System.out.print("Ponto 1: " + aux.getP1().getX() + "  Ponto Y: " + aux.getP1().getY());
				System.out.println(" -- Ponto 2: " + aux.getP2().getX() + "  Ponto Y: " + aux.getP2().getY());
			}
			System.out.println("**************************");
			System.out.println();
			System.out.println();
		}

		SubConjunto subConjunto2 = new SubConjunto(false);
		SegmentoDeReta seg2 = new SegmentoDeReta(new Ponto(3, 3), new Ponto(5, 6));
		tad.insertS(subConjunto2, seg2);

		seg2 = new SegmentoDeReta(new Ponto(2, 4), new Ponto(1, 6));
		tad.insertS(subConjunto2, seg2);

		seg2 = new SegmentoDeReta(new Ponto(8, 9), new Ponto(10, 10));
		tad.insertS(subConjunto2, seg2);

		seg2 = new SegmentoDeReta(new Ponto(4, 4), new Ponto(6, 6));
		tad.insertS(subConjunto2, seg2);
	
		iterator = subConjunto2.getLista().iterator();
		aux = new SegmentoDeReta();
		System.out.println("SubConjunto 2");
		while (iterator.hasNext()) {
			aux = (SegmentoDeReta) iterator.next();
			System.out.print("Ponto 1: " + aux.getP1().getX() + "  Ponto Y: " + aux.getP1().getY());
			System.out.println(" -- Ponto 2: " + aux.getP2().getX() + "  Ponto Y: " + aux.getP2().getY());
		}
		System.out.println();
		System.out.println();

		
		System.out.println("***********Insercao de 2 subConjunto***************");
		System.out.println();
		tad.insertC(conjunto1, subConjunto2);

		for (SubConjunto sub : conjunto1.getConjunto().values()) {

			System.out.println("Conjunto " );
			System.out.println("Hash Conjunto = " + sub.getHash_subconjunto());

			if (sub.ordenado)
				iterator = sub.getLista_ordenada().iterator();
			else
				iterator = sub.getLista().iterator();
			while (iterator.hasNext()) {
				aux = (SegmentoDeReta) iterator.next();
				System.out.print("Ponto 1: " + aux.getP1().getX() + "  Ponto Y: " + aux.getP1().getY());
				System.out.print(" -- Ponto 2: " + aux.getP2().getX() + "  Ponto Y: " + aux.getP2().getY());
				System.out.println(" = Distancia: " + aux.distancia());
			}
			System.out.println();
			System.out.println("**************************");
			System.out.println();
			System.out.println();
		}
		
		System.out.println("**********memberC************");
		System.out.println();
		// operação memberC
		System.out.println("Contem subConjunto = " + tad.memberC(conjunto1, subConjunto2));
		
		System.out.println();
		System.out.println("**********findC************");
		System.out.println();
		// operação findC
		aux = new SegmentoDeReta(new Ponto(4, 4), new Ponto(6, 6));
		SubConjunto sub_aux = tad.findC(conjunto1, aux);
		if (sub_aux == null)
			System.out.println("Ponto nao existe");
		else
			System.out.println("Find C = " + sub_aux.getHash_subconjunto());
		
		
		System.out.println();
		System.out.println("**********deleteC************");
		System.out.println();
		// operação deleteC
		sub_aux = new SubConjunto(false);
		aux = new SegmentoDeReta(new Ponto(4, 4), new Ponto(6, 6));
		tad.insertS(sub_aux, aux);
		System.out.println("Delete C = " + tad.deleteC(conjunto1, sub_aux));
		
		
		System.out.println();
		System.out.println();
		System.out.println("**************UNIAO************");
		// operação uniao
		sub_aux = tad.union(subConjunto1, subConjunto2);
		if (sub_aux.ordenado)
			iterator = sub_aux.getLista_ordenada().iterator();
		else
			iterator = sub_aux.getLista().iterator();

		aux = new SegmentoDeReta();
		while (iterator.hasNext()) {
			aux = (SegmentoDeReta) iterator.next();
			System.out.print("Ponto 1: " + aux.getP1().getX() + "  Ponto Y: " + aux.getP1().getY());
			System.out.print(" -- Ponto 2: " + aux.getP2().getX() + "  Ponto Y: " + aux.getP2().getY());
			System.out.println(" = Distancia: " + aux.distancia());			
		}
		System.out.println();
		System.out.println();
		
		System.out.println("*******************DIFERENCA*********************");
		// operação diferença
		sub_aux = tad.difference(subConjunto1, subConjunto2);
		if (sub_aux.ordenado)
			iterator = sub_aux.getLista_ordenada().iterator();
		else
			iterator = sub_aux.getLista().iterator();
		aux = new SegmentoDeReta();
		while (iterator.hasNext()) {
			aux = (SegmentoDeReta) iterator.next();
			System.out.print("Ponto 1: " + aux.getP1().getX() + "  Ponto Y: " + aux.getP1().getY());
			System.out.print(" -- Ponto 2: " + aux.getP2().getX() + "  Ponto Y: " + aux.getP2().getY());
			System.out.println(" = Distancia: " + aux.distancia());
		}
		System.out.println();
		System.out.println();
		
		System.out.println("****************INTERSACAO****************");
		// operação intersection
		sub_aux = tad.intersection(subConjunto1, subConjunto2);
		if (sub_aux.ordenado)
			iterator = sub_aux.getLista_ordenada().iterator();
		else
			iterator = sub_aux.getLista().iterator();
		aux = new SegmentoDeReta();
		while (iterator.hasNext()) {
			aux = (SegmentoDeReta) iterator.next();
			System.out.print("Ponto 1: " + aux.getP1().getX() + "  Ponto Y: " + aux.getP1().getY());
			System.out.print(" -- Ponto 2: " + aux.getP2().getX() + "  Ponto Y: " + aux.getP2().getY());
			System.out.println(" = Distancia: " + aux.distancia());
		}
		System.out.println();
		System.out.println();

		// minS
		System.out.println("***********minS*************");
		SegmentoDeReta x = (SegmentoDeReta) tad.minS(subConjunto1);
		if (x == null) {
			System.out.println("Desodernado");
		} else {
			System.out.print("Ponto 1: " + x.getP1().getX() + "  Ponto Y: " + x.getP1().getY());
			System.out.print(" -- Ponto 2: " + x.getP2().getX() + "  Ponto Y: " + x.getP2().getY());
			System.out.println(" = Distancia: " + x.distancia());
		}
		
		System.out.println();
		System.out.println();
		
		// split
		Conjunto c = tad.splitS(subConjunto1,new SegmentoDeReta(new Ponto(8, 9), new Ponto(10, 10)));
		System.out.println("***********split*************");
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
					aux = (SegmentoDeReta) iterator.next();
					System.out.print("Ponto 1: " + aux.getP1().getX() + "  Ponto Y: " + aux.getP1().getY());
					System.out.print(" -- Ponto 2: " + aux.getP2().getX() + "  Ponto Y: " + aux.getP2().getY());
					System.out.println(" = Distancia: " + aux.distancia());
				}
				System.out.println("**************************");
				System.out.println();
				System.out.println();
			}

		}
	}

}
