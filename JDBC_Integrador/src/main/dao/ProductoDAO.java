package main.dao;

import main.dao.entities.Producto;
import org.apache.commons.csv.CSVParser;

import java.util.List;

public interface ProductoDAO {
	public void agregar(Producto p) throws Exception;
	public void eliminar(Producto p) throws Exception;
	public void modificar(Producto p) throws Exception;
	public List<Producto> listar() throws Exception;
	public void insertarDesdeCSV(CSVParser csv);
	public String getProductoMasRecaudador()  throws Exception;
}
