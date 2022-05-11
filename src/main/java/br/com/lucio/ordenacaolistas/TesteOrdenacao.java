package br.com.lucio.ordenacaolistas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.lucio.model.Conta;
import br.com.lucio.model.Titular;

public class TesteOrdenacao {

	public static void main(String[] args) {
		
		Conta cc1 = new Conta();
		cc1.setAgencia(11);
		cc1.setNumero(111);
		cc1.setTitular(new Titular("Zulmir"));
		cc1.setSaldo(11111.0);
		
		Conta cc2 = new Conta();
		cc2.setAgencia(22);
		cc2.setNumero(222);
		cc2.setTitular(new Titular("Rodrigo"));
		cc2.setSaldo(1234332.0);
		
		Conta cc3 = new Conta();
		cc3.setAgencia(33);
		cc3.setNumero(333);
		cc3.setTitular(new Titular("Danielly"));
		cc3.setSaldo(333.0);
		
		Conta cc4 = new Conta();
		cc4.setAgencia(44);
		cc4.setNumero(444);
		cc4.setTitular(new Titular("Ana"));
		cc4.setSaldo(1.0);
		
		List<Conta> contas = new ArrayList<>();
		contas.add(cc3);
		contas.add(cc2);
		contas.add(cc4);
		contas.add(cc1);
		
		contas.sort(new ComparadorContas());
		
		System.out.println("Lista ordenada pelo numero da conta:");
		contas.forEach(conta -> {
			System.out.println(conta);
		});

		contas.sort(new ComparadorTitular());
		System.out.println("Lista ordenada pelo nome do titular:");
		contas.forEach(conta -> {
			System.out.println(conta);
		});
		
		// ou  
		//Collections.sort(contas, Comparator.comparing(Conta::getNumero));
		// ou
		// Collections.sort(contas, new ComparadorContas());
	
		//Ou (só funciona pois implementei o Comparable na classe Conta, ficando a ordem "natural")
		Collections.sort(contas);
		
		// também funcionaria:
		// Collections.sort(contas, Comparator.comparing(Conta::getSaldo));
		
		System.out.println("Lista ordenada pela ordenação 'Natural':");
		contas.forEach(conta -> {
			System.out.println(conta);
		});
		
	}
	
}

class ComparadorContas implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {
		return Integer.compare(c1.getNumero(), c2.getNumero());
	}
	
}

class ComparadorTitular implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {
		return c1.getTitular().getNome()
				.compareTo(c2.getTitular().getNome());
	}
	
}