package br.com.lucio.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Conta {

	private Integer numero;
	private Integer agencia;
	private Titular titular;
	
}
