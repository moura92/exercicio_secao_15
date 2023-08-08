package program;

import java.util.Locale;
import java.util.Scanner;

import entidade.Conta;
import model.exceções.ExcecaoDominio;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Insira os dados da conta");
			System.out.print("Numero da conta: ");
			Integer numeroconta = sc.nextInt();
			sc.nextLine();
			System.out.print("Titular: ");
			String titular = sc.nextLine();
			System.out.print("Balanço inicial: ");
			Double balanço = sc.nextDouble();
			System.out.print("Limite de retirada: ");
			Double limitederetirada = sc.nextDouble();

			Conta conta = new Conta(numeroconta, titular, balanço, limitederetirada);

			System.out.println();
			System.out.print("Insira o valor para saque: ");
			Double saque = sc.nextDouble();
			conta.saque(saque);

			System.out.println(conta);
		} catch (ExcecaoDominio e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
