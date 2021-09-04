package main;

import main.dao.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {

	public static void main(String[] args) {
		ProductoDAO producto = DAOFactory.getInstance().getProductoDao();
		ClienteDAO cliente = DAOFactory.getInstance().getClienteDao();
		FacturaDAO factura = DAOFactory.getInstance().getFacturaDao();
		FacturaProductoDAO fact_prod = DAOFactory.getInstance().getFacturaProductoDao();


//		cliente.insertarDesdeCSV(leerCSV("csv/clientes.csv"));
//
//		producto.insertarDesdeCSV(leerCSV("csv/productos.csv"));
//
//		factura.insertarDesdeCSV(leerCSV("csv/facturas.csv"));
//		fact_prod.insertarDesdeCSV(leerCSV("csv/facturas-productos.csv"));

		/* Ejercicio 3*/
		try {
			System.out.println(producto.getProductoMasRecaudador());
		} catch (Exception e) {
			e.printStackTrace();
		}


		/* Ejercicio 4*/
		try {
			System.out.println(cliente.getClienteMasRecaudador());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
