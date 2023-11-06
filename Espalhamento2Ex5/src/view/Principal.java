package view;

import javax.swing.JOptionPane;

import controller.BancoController;
import model.ContaBancaria;

public class Principal {
    public static void main(String[] args) throws Exception {
    	BancoController banco = new BancoController();

    	int opcao;
    	do {
    		String opcaoString = JOptionPane.showInputDialog("Escolha uma opção:\n" +
                    "1. Inserir conta\n" +
                    "2. Consultar conta\n" +
                    "3. Remover conta\n" +
                    "0. Sair");
            opcao = Integer.parseInt(opcaoString);

            switch (opcao) {
            case 1:
            	int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
            	String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
            	double saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo da conta:"));
            	ContaBancaria conta = new ContaBancaria(numeroConta, nomeCliente, saldo);
            	banco.inserirConta(conta);
            	break;
            	
            case 2:
            	int numeroContaConsulta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta a ser consultada:"));
            	ContaBancaria contaConsultada = banco.consultarConta(numeroContaConsulta);
            	if (contaConsultada != null) {
            		JOptionPane.showMessageDialog(null, contaConsultada.toString());
            	} else {
            		JOptionPane.showMessageDialog(null, "Conta não encontrada!");
            	}
            	break;

            case 3:
            	int numeroContaRemover = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta a ser removida:"));
            	banco.removerConta(numeroContaRemover);
            	break;

            case 0:
            	JOptionPane.showMessageDialog(null, "Saindo...");
            	break;

            default:
            	JOptionPane.showMessageDialog(null, "Opção inválida!");
            	break;
            }
        } while (opcao != 0);
    }	
}

