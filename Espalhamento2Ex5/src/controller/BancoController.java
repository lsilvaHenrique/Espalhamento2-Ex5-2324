package controller;

import model.ContaBancaria;
import sp.fateczl.lucas.listaObj.Lista;

public class BancoController {
    private Lista[] tabelaEspalhamento;

    public BancoController() {
        tabelaEspalhamento = new Lista[100];
        for (int i = 0; i < 100; i++) {
            tabelaEspalhamento[i] = new Lista();
        }
    }

    public void inserirConta(ContaBancaria conta) throws Exception {
        int posicao = hash(conta.getNumeroConta());
        tabelaEspalhamento[posicao].add(conta, 0);
    }

    public ContaBancaria consultarConta(int numeroConta) throws Exception {
        int posicao = hash(numeroConta);
        Lista lista = tabelaEspalhamento[posicao];
        for (int i = 0; i < lista.size(); i++) {
            ContaBancaria conta = (ContaBancaria) lista.get(i);
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    public void removerConta(int numeroConta) throws Exception {
        int posicao = hash(numeroConta);
        Lista lista = tabelaEspalhamento[posicao];
        for (int i = 0; i < lista.size(); i++) {
            ContaBancaria conta = (ContaBancaria) lista.get(i);
            if (conta.getNumeroConta() == numeroConta) {
                lista.remove(i);
                break;
            }
        }
    }

    private int hash(int numeroConta) {
        return numeroConta % 100;
    }
}

