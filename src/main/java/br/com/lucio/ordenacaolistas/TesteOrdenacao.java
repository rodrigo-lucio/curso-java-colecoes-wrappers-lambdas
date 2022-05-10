package br.com.lucio.ordenacaolistas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.lucio.model.Conta;

public class TesteOrdenacao {

	public static void main(String[] args) {
		
		Conta cc1 = new Conta();
		cc1.setAgencia(11);
		cc1.setNumero(111);
		
		Conta cc2 = new Conta();
		cc2.setAgencia(22);
		cc2.setNumero(222);
		
		Conta cc3 = new Conta();
		cc3.setAgencia(33);
		cc3.setNumero(333);
		
		Conta cc4 = new Conta();
		cc4.setAgencia(44);
		cc4.setNumero(444);
		
		
		List<Conta> contas = new ArrayList<>();
		contas.add(cc3);
		contas.add(cc2);
		contas.add(cc4);
		contas.add(cc1);
		
		ComparadorContas comparador = new ComparadorContas();
		
		contas.sort(comparador);

		
		//Lista ordenada pelo numero da conta
		contas.forEach(conta -> {
			System.out.println(conta);
		});
		
		
		// ou 
		//Collections.sort(contas, Comparator.comparing(Conta::getNumero));
		// ou
		// Collections.sort(contas, comparador);
		
	}
	
}

class ComparadorContas implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {

		if(c1.getNumero() < c2.getNumero()) {
			return -1;
		}

		if(c1.getNumero() > c2.getNumero()) {
			return 1;
		}
		
		return 0;
	}
	
}