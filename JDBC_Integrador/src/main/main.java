package main;

import main.dao.*;
import main.helpers.Helpers;

public class main {

	public static void main(String[] args) {
		ProductoDAO producto = DAOFactory.getInstance().getProductoDao();
		ClienteDAO cliente = DAOFactory.getInstance().getClienteDao();
		FacturaDAO factura = DAOFactory.getInstance().getFacturaDao();
		FacturaProductoDAO fact_prod = DAOFactory.getInstance().getFacturaProductoDao();


		cliente.insertarDesdeCSV(Helpers.leerCSV("csv/clientes.csv"));

		producto.insertarDesdeCSV(Helpers.leerCSV("csv/productos.csv"));

		factura.insertarDesdeCSV(Helpers.leerCSV("csv/facturas.csv"));
		fact_prod.insertarDesdeCSV(Helpers.leerCSV("csv/facturas-productos.csv"));

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

}
