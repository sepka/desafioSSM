package desafio;

import java.util.ArrayList;

interface IMaquina {

	ArrayList<Troco> montarTroco(double troco);

}
interface INotaFiscal {

ArrayList<Double> geraParcelas(int nrParcelas, double valorTotal);

}