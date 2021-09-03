package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import main.dao.ClienteDAO;
import main.dao.DAOFactory;
import main.dao.FacturaDAO;
import main.dao.FacturaProductoDAO;
import main.dao.ProductoDAO;

public class main {

	public static void main(String[] args) {
		ProductoDAO producto = DAOFactory.getInstance().getProductoDao();
		ClienteDAO cliente = DAOFactory.getInstance().getClienteDao();
		FacturaDAO factura = DAOFactory.getInstance().getFacturaDao();
		FacturaProductoDAO fact_prod = DAOFactory.getInstance().getFacturaProductoDao();
			
		
		//producto.insertarDesdeCSV(leerCSV("csv/producto.csv"));
		//cliente.insertarDesdeCSV(leerCSV("csv/clientes.csv"));
		//factura.insertarDesdeCSV(leerCSV("csv/facturas.csv"));
		fact_prod.insertarDesdeCSV(leerCSV("csv/facturas-productos.csv"));
	}
	
	public static CSVParser leerCSV(String ruta) {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(ruta));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return parser;
	}
}
