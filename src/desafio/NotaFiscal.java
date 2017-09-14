package desafio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import desafio.Troco.ECedula;

class NotaFiscal implements INotaFiscal {
	private ArrayList<Double> arrayParcelas = new ArrayList<>();

	@Override
	public ArrayList<Double> geraParcelas(int nrParcelas, double valorTotal) {

		double valorParcela = valorTotal / nrParcelas;
		double valorRestante = valorTotal;
		double soma = 0;

		BigDecimal valorExato = new BigDecimal(valorParcela).setScale(2, RoundingMode.HALF_EVEN);
		valorParcela = Double.parseDouble(String.valueOf(valorExato));

		for (int i = 0; i < nrParcelas; i++) {
			
			System.out.println("Valor restante " + valorRestante);
			
			if (i == nrParcelas -1) {
				valorParcela = valorRestante;
			}else {
			valorRestante -= valorParcela;
			}
			
			valorExato = new BigDecimal(valorRestante).setScale(2, RoundingMode.HALF_UP);
			valorRestante = Double.parseDouble(String.valueOf(valorExato));
			
			

			arrayParcelas.add(valorParcela);

		}

		return arrayParcelas;
	}

}