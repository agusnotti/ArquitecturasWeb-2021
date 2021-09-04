package main.dao;

import main.dao.entities.FacturaProducto;
import main.mysql.Conexion;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FacturaProductoDAOImpl extends Conexion implements AutoCloseable, FacturaProductoDAO {
	
	//Creacion de la tabla Factura
	public FacturaProductoDAOImpl() {
		try {
			this.abrirConexion();
			String table = "CREATE TABLE IF NOT EXISTS factura_producto (idFactura INT, idProducto INT, cantidad INT, PRIMARY KEY(idFactura, idProducto)," +
					"FOREIGN KEY (idFactura) REFERENCES factura(idFactura) ON DELETE CASCADE," +
					"FOREIGN KEY (idProducto) REFERENCES producto(id) ON DELETE CASCADE" +
					");";
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

	//Insercion de tupla en tabla
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

	//	Metodos no implementados en esta instancia del trabajo
	//  correspondientes al ABM de la entidad
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

	
	//Override de metodo close por implementacion del AutoCloseable
	@Override
	public void close() throws Exception {
		this.cerrarConexion();
	}

}
