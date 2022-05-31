package controllers;

import entities.Cliente;
import helpers.ClienteHelper;
import repositories.ClienteRepository;

public class ClienteController {

	public void cadastrar() {

		try {
			System.out.println("\n === CADASTRO DE CLIENTE === \n");
			
			Cliente cliente = new Cliente();
			cliente.setNome(ClienteHelper.lerNome());
			cliente.setEmail(ClienteHelper.lerEmail());
			cliente.setCelular(ClienteHelper.lerCelular());
			
			ClienteRepository clienteRepository = new ClienteRepository();
			clienteRepository.create(cliente);
			
			System.out.println("Cliente cadastrado com sucesso!");

		} catch (Exception e) {
			System.out.println("Ocorreu um erro: " + e.getMessage());

		}
	}


	public void atualizar() {
		
		try {
			System.out.println("\n === ATUALIZAÇÃO DE PESSOA === \n");
			
			Integer idCliente = ClienteHelper.lerIdCliente();
			
			// consultando do cliente no banco
			// de dados atraves do id
			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(idCliente);
			
			
			if (cliente != null) {
				cliente.setNome(ClienteHelper.lerNome());
				cliente.setEmail(ClienteHelper.lerEmail());
				cliente.setCelular(ClienteHelper.lerCelular());
				clienteRepository.update(cliente);
				System.out.println("Cliente atualizado com sucesso!");
			} else {
				System.out.println("Cliente não foi encontrado!");
			}
		
		} catch (Exception e) {
			System.out.println("Ocorreu um erro: " + e.getMessage());
		}
	}

	public void excluir() {
		
		try {
			System.out.println("\n === EXCLUSÃO DE CLIENTE === \n");
			Integer idCliente = ClienteHelper.lerIdCliente();
			
			ClienteRepository clienteRepository = new ClienteRepository();
			Cliente cliente = clienteRepository.findById(idCliente);
			
			if (cliente != null) {
				clienteRepository.delete(cliente);
				System.out.println("Cliente excluído com sucesso!");

			} else {
				System.out.println("Cliente não foi encontrado!");

			}
			
		} catch (Exception e) {
			System.out.println("Ocorreu um erro: " + e.getMessage());

		}
	}

	public void consultar() {
		
		try {
			System.out.println("\n === CONSULTA DE CLIENTES === \n");
			ClienteRepository clienteRepository = new ClienteRepository();
			for (Cliente cliente : clienteRepository.findAll()) {
				System.out.println(cliente.toString());
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro: " + e.getMessage());

		}
	}
}