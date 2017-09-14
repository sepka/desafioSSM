package desafio;

import java.awt.List;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import desafio.Troco.ECedula;

class Troco implements IMaquina {

	public enum ECedula {

		NOTA100(100), NOTA50(50), NOTA20(20), NOTA10(10), NOTA5(5), NOTA2(2), MOEDA100(

				1), MOEDA50(0.5), MOEDA25(0.25), MOEDA10(0.1), MOEDA5(0.05), MOEDA1(0.01);

		ECedula(double valor) {

			this.valor = valor;

		}

		private double valor;

		public double getValor() {
			return valor;
		}

	}

	private ECedula tipo;

	private int quantidade;

	public void adicionaQuantidade(int qtde) {
		quantidade += qtde;
	}

	public Troco(ECedula tipo, int quantidade) {

		super();

		this.tipo = tipo;

		this.quantidade = quantidade;

	}

	public ECedula getTipo() {
		return tipo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	@Override
	public ArrayList<Troco> montarTroco(double troco) {
		// TODO Auto-generated method stub
		return null;
	}

}

class MaquinaDinheiro implements IMaquina {
	private ArrayList<Troco> arrayTroco = new ArrayList<>();

	@Override
	public ArrayList<Troco> montarTroco(double troco) {

		Double resto = troco;

		while (resto > 0.) {
			BigDecimal valorExato = new BigDecimal(resto).setScale(2, RoundingMode.HALF_DOWN);
			resto = Double.parseDouble(String.valueOf(valorExato));

			resto = returnResto(resto);

		}

		return arrayTroco;
	}

	private double returnResto(double resto) {
		int qtd = 0;
		Troco t;

		if (resto >= ECedula.NOTA100.getValor()) {
			qtd = (int) (resto / ECedula.NOTA100.getValor());
			t = new Troco(ECedula.NOTA100, qtd);
			arrayTroco.add(t);
			resto = resto % ECedula.NOTA100.getValor();

		} else if (resto >= ECedula.NOTA50.getValor()) {
			qtd = (int) (resto / ECedula.NOTA50.getValor());
			t = new Troco(ECedula.NOTA50, qtd);
			arrayTroco.add(t);
			resto = resto % ECedula.NOTA50.getValor();

		} else if (resto >= ECedula.NOTA20.getValor()) {
			qtd = (int) (resto / ECedula.NOTA20.getValor());
			t = new Troco(ECedula.NOTA20, qtd);
			arrayTroco.add(t);
			resto = resto % ECedula.NOTA20.getValor();

		} else if (resto >= ECedula.NOTA10.getValor()) {
			qtd = (int) (resto / ECedula.NOTA10.getValor());
			t = new Troco(ECedula.NOTA10, qtd);
			arrayTroco.add(t);
			resto = resto % ECedula.NOTA10.getValor();

		} else if (resto >= ECedula.NOTA5.getValor()) {
			qtd = (int) (resto / ECedula.NOTA5.getValor());
			t = new Troco(ECedula.NOTA5, qtd);
			arrayTroco.add(t);
			resto = resto % ECedula.NOTA5.getValor();

		} else if (resto >= ECedula.NOTA2.getValor()) {
			qtd = (int) (resto / ECedula.NOTA2.getValor());
			t = new Troco(ECedula.NOTA2, qtd);
			arrayTroco.add(t);
			resto = resto % ECedula.NOTA2.getValor();

		} else if (resto >= ECedula.MOEDA100.getValor()) {
			qtd = (int) (resto / ECedula.MOEDA100.getValor());
			t = new Troco(ECedula.MOEDA100, qtd);
			arrayTroco.add(t);
			resto = resto % ECedula.MOEDA100.getValor();

		} else if (resto >= ECedula.MOEDA50.getValor()) {
			qtd = (int) (resto / ECedula.MOEDA50.getValor());
			t = new Troco(ECedula.MOEDA50, qtd);
			arrayTroco.add(t);
			resto = resto % ECedula.MOEDA50.getValor();

		} else if (resto >= ECedula.MOEDA25.getValor()) {
			qtd = (int) (resto / ECedula.MOEDA25.getValor());
			t = new Troco(ECedula.MOEDA25, qtd);
			arrayTroco.add(t);
			resto = resto % ECedula.MOEDA25.getValor();

		} else if (resto >= ECedula.MOEDA10.getValor()) {
			qtd = (int) (resto / ECedula.MOEDA10.getValor());
			t = new Troco(ECedula.MOEDA10, qtd);
			arrayTroco.add(t);
			resto = resto % ECedula.MOEDA10.getValor();

		} else if (resto >= ECedula.MOEDA5.getValor()) {
			qtd = (int) (resto / ECedula.MOEDA5.getValor());
			t = new Troco(ECedula.MOEDA5, qtd);
			arrayTroco.add(t);
			resto = resto % ECedula.MOEDA5.getValor();

		} else if (resto >= ECedula.MOEDA1.getValor()) {
			qtd = (int) (resto / ECedula.MOEDA1.getValor());
			t = new Troco(ECedula.MOEDA1, qtd);
			arrayTroco.add(t);
			// resto = resto % ECedula.MOEDA1.getValor();
			resto = 0;
		}

		return resto;
	}

}
