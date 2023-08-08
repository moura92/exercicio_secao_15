package entidade;

import model.exceções.ExcecaoDominio;

public class Conta {

	private Integer numero;
	private String titular;
	private Double balanço;
	private Double limitederetirada;

	public Conta() {
		super();
	}

	public Conta(Integer numero, String titular, Double balanço, Double limitederetirada) {
		this.numero = numero;
		this.titular = titular;
		this.balanço = balanço;
		this.limitederetirada = limitederetirada;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getBalanço() {
		return balanço;
	}

	public Double getLimitederetirada() {
		return limitederetirada;
	}

	public void setLimitederetira(Double limitederetirada) {
		this.limitederetirada = limitederetirada;
	}

	public void deposito(Double quantidade) {
		balanço += quantidade;
	}

	public void saque(Double quantidade) {
		if (quantidade >= limitederetirada) {
			throw new ExcecaoDominio("Erro de retirada: o valor excede o limite de retirada");
		}
		if (balanço < quantidade || balanço < limitederetirada) {
			throw new ExcecaoDominio("Erro de saque: saldo insuficiente");
		}

		balanço -= quantidade;

	}

	public String toString() {
		return "Novo Balanço: " + String.format("%.2f", balanço);
	}
}
