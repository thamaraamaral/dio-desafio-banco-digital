package principal;

import java.util.Scanner;

import controllers.ClienteController;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("\n==== GERENCIAMENTO DE CLIENTES === \n");
		System.out.println("(1) Cadastrar Cliente");
		System.out.println("(2) Atualizar Cliente");
		System.out.println("(3) Excluir Cliente");
		System.out.println("(4) Consultar Cliente");

		System.out.println("\nEscolha a opção desejada");
		Integer opcao = Integer.parseInt(scanner.nextLine());

		ClienteController clienteController = new ClienteController();

		switch (opcao) {
		case 1:
			clienteController.cadastrar();
			break;

		case 2:
			clienteController.atualizar();
			break;

		case 3:
			clienteController.excluir();
			break;

		case 4:
			clienteController.consultar();
			break;

		default:
			System.out.println("\nOpção inválida!");

		}

	}
}
