package main.dao;

import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import main.dao.entities.Factura;
import main.dao.entities.Producto;
import main.mysql.Conexion;

public class FacturaDAOImpl extends Conexion implements AutoCloseable, FacturaDAO {


	public FacturaDAOImpl() {
		try {
			this.abrirConexion();
			String table = "CREATE TABLE IF NOT EXISTS factura (idFactura INT, idCliente INT,  PRIMARY KEY(idFactura),"
					+ "FOREIGN KEY (idCliente) REFERENCES cliente(idCliente) ON DELETE CASCADE)";
			PreparedStatement ps = this.conn.prepareStatement(table);
			ps.execute();
			ps.close();
			this.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	@Override
	public void insertarDesdeCSV(CSVParser csv) {
		for(CSVRecord row: csv) {
			int idFactura =  Integer.parseInt(row.get("idFactura"));
			int idCliente =  Integer.parseInt(row.get("idCliente"));
			
			Factura f = new Factura(idFactura, idCliente);
			try {
				this.agregar(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}	

	@Override
	public void agregar(Factura f) throws Exception {
		try {
			this.abrirConexion();			
			String insert = "INSERT INTO factura(idFactura, idCliente ) VALUES (?, ?)";
			PreparedStatement ps = this.conn.prepareStatement(insert);
			ps.setInt(1, f.getIdFactura());
			ps.setInt(2, f.getIdCliente());
			ps.executeUpdate();
			ps.close();
			this.cerrarConexion();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);	
		}

	}

	@Override
	public void eliminar(Factura f) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar(Factura f) throws Exception {
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<Factura> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() throws Exception {
		this.cerrarConexion();
	}
}
