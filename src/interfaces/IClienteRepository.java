package interfaces;

import java.util.List;

import entities.Cliente;

public interface IClienteRepository {

	void create(Cliente cliente) throws Exception;
	
	void update(Cliente cliente) throws Exception;
	
	void delete(Cliente cliente) throws Exception;
	
	List<Cliente> findAll() throws Exception;
	
	Cliente findById(Integer idCliente) throws Exception;
}
