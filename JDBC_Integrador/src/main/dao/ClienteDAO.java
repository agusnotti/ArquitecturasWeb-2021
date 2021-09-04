package main.dao;

import main.dao.entities.Cliente;
import org.apache.commons.csv.CSVParser;

import java.util.ArrayList;
import java.util.List;

// DAO maneja la relacion de la entidad Cliente con la DDBB

public interface ClienteDAO extends AutoCloseable{
	public void agregar(Cliente c) throws Exception;
	public void eliminar(Cliente c) throws Exception;
	public void modificar(Cliente c) throws Exception;
	public List<Cliente> listar() throws Exception;
	public void insertarDesdeCSV(CSVParser parser);
	public ArrayList<Cliente> getClienteMasRecaudador();
}
