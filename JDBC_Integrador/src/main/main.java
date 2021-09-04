package main;

import main.dao.*;
import main.helpers.Helpers;

public class main {

	public static void main(String[] args) {
		
		//Instanciacion de los DAOS de las diferentes entidades
		ProductoDAO producto = DAOFactory.getInstance().getProductoDao();
		ClienteDAO cliente = DAOFactory.getInstance().getClienteDao();
		FacturaDAO factura = DAOFactory.getInstance().getFacturaDao();
		FacturaProductoDAO fact_prod = DAOFactory.getInstance().getFacturaProductoDao();

		//Llama al metodo de insercion de tuplas por medio de archivos CSV
		cliente.insertarDesdeCSV(Helpers.leerCSV("csv/clientes.csv"));
		producto.insertarDesdeCSV(Helpers.leerCSV("csv/productos.csv"));
		factura.insertarDesdeCSV(Helpers.leerCSV("csv/facturas.csv"));
		fact_prod.insertarDesdeCSV(Helpers.leerCSV("csv/facturas-productos.csv"));

		/* Ejercicio 3*/
		try {
			System.out.println("El producto que mas recaudo: ");
			System.out.println(producto.getProductoMasRecaudado()+"\n");
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Ejercicio 4*/
		try {
			System.out.println("Lista de clientes ordenada por volumen de facturacion: ");
			System.out.println(cliente.getClienteMasRecaudador());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
