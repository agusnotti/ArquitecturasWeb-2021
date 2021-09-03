package main.dao;

import java.util.List;

import org.apache.commons.csv.CSVParser;

import main.dao.entities.Cliente;

public interface ClienteDAO extends AutoCloseable{
	public void agregar(Cliente c) throws Exception;
	public void eliminar(Cliente c) throws Exception;
	public void modificar(Cliente c) throws Exception;
	public List<Cliente> listar() throws Exception;
	public void insertarDesdeCSV(CSVParser parser);
}
