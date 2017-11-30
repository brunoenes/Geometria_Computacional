package problemas;

import java.text.DecimalFormat;

public class Troco {

	public String calculaTroco(double conta, double pago) {

		DecimalFormat formatador = new DecimalFormat("###,##0.00");

		if (pago < conta)
			return ("\nPagamento insuficiente, faltam R$" + formatador.format(conta - pago) + "\n");
		else {

			String resultado;
			double troco;

			troco = pago - conta;
			resultado = "\nTroco = R$" + formatador.format(troco) + "\n\n";

			resultado = this.calculaNotas(troco, resultado);
			resultado = this.calculaMoedas(troco, resultado);

			resultado = resultado + "\n";

			return (resultado);
		}
	}

	private String calculaNotas(final double troco, String resultado) {

		int nota[] = { 100, 50, 20, 10, 5, 2, 1 };

		int valor;
		int ct;

		int contadorNota = 0;

		valor = (int) troco;
		while (valor != 0) {
			ct = valor / nota[contadorNota]; // calculando a qtde de notas
			if (ct != 0) {
				resultado = resultado + (ct + " nota(s) de R$" + nota[contadorNota] + "\n");
				valor = valor % nota[contadorNota]; // sobra
			}
			contadorNota++; // próxima nota
		}
		return resultado;
	}

	private String calculaMoedas(final double troco, String resultado) {

		int centavos[] = { 50, 25, 10, 5, 1 };

		int contadorMoeda = 0;
		int valor;
		int ct;

		valor = (int) Math.round((troco - (int) troco) * 100);
		while (valor != 0) {
			ct = valor / centavos[contadorMoeda]; // calculando a qtde de moedas
			if (ct != 0) {
				resultado = resultado + (ct + " moeda(s) de" + centavos[contadorMoeda] + "centavo(s)\n");
				valor = valor % centavos[contadorMoeda]; // sobra
			}
			contadorMoeda++; // próximo centavo
		}
		return resultado;
	}

}