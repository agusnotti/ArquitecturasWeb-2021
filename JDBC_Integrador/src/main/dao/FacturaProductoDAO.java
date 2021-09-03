package main.dao;

import java.util.List;

import org.apache.commons.csv.CSVParser;

import main.dao.entities.FacturaProducto;

public interface FacturaProductoDAO {
	public void agregar(FacturaProducto fp) throws Exception;
	public void eliminar(FacturaProducto fp) throws Exception;
	public void modificar(FacturaProducto fp) throws Exception;
	public List<FacturaProducto> listar() throws Exception;
	public void insertarDesdeCSV(CSVParser leerCSV);
}
