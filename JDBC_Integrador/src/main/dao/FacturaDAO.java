package main.dao;

import java.util.List;

import org.apache.commons.csv.CSVParser;

import main.dao.entities.Factura;

public interface FacturaDAO {
	public void agregar(Factura f) throws Exception;
	public void eliminar(Factura f) throws Exception;
	public void modificar(Factura f) throws Exception;
	public List<Factura> listar() throws Exception;
	public void insertarDesdeCSV(CSVParser leerCSV);
}
