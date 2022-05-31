package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import factories.ConnectionFactory;
import interfaces.IClienteRepository;

public class ClienteRepository implements IClienteRepository {

	@Override
	public void create(Cliente cliente) throws Exception {

		// abrir conexão com banco de dados
		Connection connection = ConnectionFactory.getConnection();

		// executar um comando SQL para cadastrar Cliente
		PreparedStatement statement = connection
				.prepareStatement("insert into cliente(nome, email, celular) values(?, ?, ?)");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getCelular());
		statement.execute();

		// fechar a conexão
		connection.close();
	}

	@Override
	public void update(Cliente cliente) throws Exception {

		// abrir conexão com banco de dados
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("update cliente set nome = ?, email = ?, celular = ? where idcliente = ?");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getCelular());
		statement.setInt(4, cliente.getIdCliente());
		statement.execute();

		// fechar a conexão
		connection.close();

	}

	@Override
	public void delete(Cliente cliente) throws Exception {

		// abrir conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("delete from cliente where idcliente = ?");
		statement.setInt(1, cliente.getIdCliente());
		statement.execute();
		// fechar a conexão
		connection.close();
	}

	@Override
	public List<Cliente> findAll() throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from cliente");
		ResultSet resultSet = statement.executeQuery();
		
		List<Cliente> lista = new ArrayList<Cliente>();
		
		while (resultSet.next()) {
			Cliente cliente = new Cliente(resultSet.getInt("idcliente"), resultSet.getString("nome"),
					resultSet.getString("email"), resultSet.getString("celular"));
			lista.add(cliente);
		}
		connection.close();
		return lista;

	}

	@Override
	public Cliente findById(Integer idCliente) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from cliente where idcliente = ?");
		statement.setInt(1, idCliente);
		ResultSet resultSet = statement.executeQuery();
		Cliente cliente = null;

		if (resultSet.next()) {
			cliente = new Cliente(resultSet.getInt("idcliente"), resultSet.getString("nome"),
					resultSet.getString("email"), resultSet.getString("celular"));

		}
		connection.close();
		return cliente;
	}
}