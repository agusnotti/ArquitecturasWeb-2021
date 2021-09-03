package main.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import main.dao.entities.FacturaProducto;
import main.dao.entities.Producto;
import main.mysql.Conexion;

public class FacturaProductoDAOImpl extends Conexion implements AutoCloseable, FacturaProductoDAO {
	
	public FacturaProductoDAOImpl() {
		try {
			this.abrirConexion();
			String table = "CREATE TABLE IF NOT EXISTS factura_producto (idFactura INT, idProducto INT, cantidad INT, PRIMARY KEY(idFactura, idProducto));";
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
			int idProducto =  Integer.parseInt(row.get("idProducto"));
			int cantidad =  Integer.parseInt(row.get("cantidad"));
			
			FacturaProducto fp = new FacturaProducto(idProducto, idFactura, cantidad);
			try {
				this.agregar(fp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}	

	@Override
	public void agregar(FacturaProducto fp) throws Exception {
		try {
			this.abrirConexion();			
			String insert = "INSERT INTO factura_producto(idFactura, idProducto, cantidad) VALUES (?, ?, ?)";
			PreparedStatement ps = this.conn.prepareStatement(insert);
			ps.setInt(1, fp.getIdFactura());
			ps.setInt(2, fp.getIdProducto());
			ps.setInt(3, fp.getCantidad());
			ps.executeUpdate();
			ps.close();
			this.cerrarConexion();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);	
		}

	}

	@Override
	public void eliminar(FacturaProducto fp) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar(FacturaProducto fp) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<FacturaProducto> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void close() throws Exception {
		this.cerrarConexion();
	}

}
