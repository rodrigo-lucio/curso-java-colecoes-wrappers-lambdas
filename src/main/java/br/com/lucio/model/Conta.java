package br.com.lucio.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Conta implements Comparable<Conta>{

	private Integer numero;
	private Integer agencia;
	private Titular titular;
	private Double saldo;
	
	@Override
	public int compareTo(Conta conta) {
		return Double.compare(this.saldo, conta.saldo);
	}
	
}
