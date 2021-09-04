package main.dao;

import main.dao.entities.Factura;
import main.mysql.Conexion;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FacturaDAOImpl extends Conexion implements AutoCloseable, FacturaDAO {

	//Creacion de la tabla Factura
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
	
	//Insercion de tuplas en tabla por medio de archivo CSV
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

	//Insercion de tupla en tabla
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

	//	Metodos no implementados en esta instancia del trabajo
	//  correspondientes al ABM de la entidad
	
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

	//Override de metodo close por implementacion del AutoCloseable
	@Override
	public void close() throws Exception {
		this.cerrarConexion();
	}
}
