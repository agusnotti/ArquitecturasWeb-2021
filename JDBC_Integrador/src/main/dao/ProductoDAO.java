package main.dao;

import java.util.List;

import org.apache.commons.csv.CSVParser;

import main.dao.entities.Producto;

public interface ProductoDAO {
	public void agregar(Producto p) throws Exception;
	public void eliminar(Producto p) throws Exception;
	public void modificar(Producto p) throws Exception;
	public List<Producto> listar() throws Exception;
	public void insertarDesdeCSV(CSVParser csv);
}
