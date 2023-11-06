package model;

public class ContaBancaria {
    private int numeroConta;
    private String nomeCliente;
    private double saldo;

    public ContaBancaria(int numeroConta, String nomeCliente, double saldo) {
        this.numeroConta = numeroConta;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

	@Override
	public String toString() {
		return "ContaBancaria [numeroConta=" + numeroConta + ", nomeCliente=" + nomeCliente + ", saldo=" + saldo + "]";
	}
    
}

