package desafio;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import desafio.Troco.ECedula;

public class Principal {

	public static void main(String[] args) {
		int op = 0;
		while (op != 3) {
			try {
				op = Integer.parseInt(JOptionPane.showInputDialog("" + "Informe a opção:\n" + "1 - Tarefa 1 - Troco\n"
						+ "2 - Tarefa 2 - Parcelas\n" + "3 - Sair\n"));

			} catch (Exception e) {
				System.out.println("entrada incorreta");
			}
			switch (op) {
			case 1:

				String strValor = "";
				double valor = 0;
				int tam = 0;
				MaquinaDinheiro m = new MaquinaDinheiro();

				do {
					try {

						strValor = JOptionPane.showInputDialog("Insira um valor de troco para separar as moedas");
						valor = Double.parseDouble(strValor);

						// separar as casas após a vírgula

						String[] splitted = strValor.split("\\.");
						try {
							tam = splitted[1].length();
						} catch (Exception e) {
							tam = 0;
						}

						if (tam > 2) {
							JOptionPane.showMessageDialog(null, "Favor inserir somente duas casa decimais");
						}
					} catch (Exception e) {
						tam = 3;
						JOptionPane.showMessageDialog(null, "Valor inválido");
					}
				} while (tam > 2);

				ArrayList<Troco> t = m.montarTroco(valor);

				for (Troco a : t) {
					if (a.getTipo().getValor() > 1) {
						System.out.println(a.getQuantidade() + " nota(s) de " + a.getTipo().getValor());
					} else {
						System.out.println(a.getQuantidade() + " moeda(s) de " + a.getTipo().getValor());
					}

				}
				System.out.println("\nTotal: " + valor);

				break;
			// Tarefa 2
			case 2:

				NotaFiscal nf = new NotaFiscal();
				String strQtd, strValorTotal;
				int qtd = 1;
				double valorTotal = 0;
				
				do {
					try {

						strValorTotal = JOptionPane.showInputDialog("Valor total");
						valorTotal = Double.parseDouble(strValorTotal);
						
						strQtd = JOptionPane.showInputDialog("Quantidade parcelas");
						qtd = Integer.parseInt(strQtd);

						// separar as casas após a vírgula

						String[] splitted = strValorTotal.split("\\.");
						try {
							tam = splitted[1].length();
						} catch (Exception e) {
							tam = 0;
						}

						if (tam > 2) {
							JOptionPane.showMessageDialog(null, "Favor inserir somente duas casa decimais");
						}
					} catch (Exception e) {
						tam = 3;
						JOptionPane.showMessageDialog(null, "Valor inválido");
					}
				} while (tam > 2);
				
				
				//--------------------------------------------------------------------
				
				ArrayList<Double> arrayParcelas = nf.geraParcelas(qtd, valorTotal);
				double total = 0;
				int count = 1;
				for (Double a : arrayParcelas) {

					System.out.println("Parcela " + count + ": " + a);
					total += a;
					count++;

				}
				System.out.println("Total " + total);

				break;
			}

		}
	}
}
