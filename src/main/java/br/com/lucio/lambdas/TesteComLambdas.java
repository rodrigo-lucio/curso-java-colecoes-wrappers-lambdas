package br.com.lucio.lambdas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import br.com.lucio.model.Conta;
import br.com.lucio.model.Titular;

public class TesteComLambdas {

	private static final class ComparatorImplementation implements Comparator<Conta> {
		@Override
		public int compare(Conta c1, Conta c2) {
			return Integer.compare(c1.getNumero(), c2.getNumero());
		}
	}

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
		
		
		
		//Jeito com classes anonimas, verboso e sem lambda
		contas.sort(new ComparatorImplementation());
		
		//Evoluindo para lambda do jeito 1
		contas.sort((Conta c1, Conta c2) -> {
				return Integer.compare(c1.getNumero(), c2.getNumero());
		});
		
		//Evoluindo para lambda do jeito 2
		contas.sort((Conta c1, Conta c2) -> Integer.compare(c1.getNumero(), c2.getNumero()));

		//Chamando com lambda bem enxuto, agora menos verboso
		contas.sort((c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()));

		System.out.println("Lista ordenada pelo numero da conta:");
		contas.forEach(conta -> {
			System.out.println(conta);
		});

		//Chamando com lambda, agora menos verboso, de um outro jeito
		Comparator<Conta> comparatorTitular = (Conta c1, Conta c2) -> {
			return c1.getTitular().getNome().compareTo(c2.getTitular().getNome());
		};

		contas.sort(comparatorTitular);
		
		System.out.println("Lista ordenada pelo nome do titular:");
		contas.forEach(conta -> {
			System.out.println(conta);
		});
		
		System.out.println("Lista ordenada pela ordenação 'Natural':");
		contas.forEach(conta -> {
			System.out.println(conta);
		});
		
		
		//O forEach tbm usa lambda:
		//Vejamos o foreach de um jeito verboso:
		contas.forEach(new Consumer<Conta>() {

			@Override
			public void accept(Conta t) {
				System.out.println(t);
			}
		});
		
		//Variações
		contas.forEach((Conta conta) -> {
			System.out.println(conta);
		});
		
		contas.forEach((conta) -> {
			System.out.println(conta);
		});
		
		contas.forEach(conta -> System.out.println(conta));
		
		contas.forEach(System.out::println);
		
		
	}
	
}


