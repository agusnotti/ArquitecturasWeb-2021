package main.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import main.dao.entities.Producto;
import main.mysql.Conexion;

public class ProductoDAOImpl extends Conexion implements AutoCloseable, ProductoDAO  {


	public ProductoDAOImpl() {
		try {
			this.abrirConexion();
			String table = "CREATE TABLE IF NOT EXISTS producto (id INT, nombre VARCHAR(500), valor DECIMAL, PRIMARY KEY(id))";
			PreparedStatement ps = this.conn.prepareStatement(table);
			ps.execute();
			ps.close();
			this.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	
	public void insertarDesdeCSV(CSVParser csv) {
		for(CSVRecord row: csv) {
			int id =  Integer.parseInt(row.get("idProducto"));
			String nombre = row.get("nombre");
			Float valor = Float.parseFloat(row.get("valor"));
			
			Producto p = new Producto(id, nombre, valor);
			try {
				this.agregar(p);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void agregar(Producto p) throws Exception {
		try {
			this.abrirConexion();			
			String insert = "INSERT INTO producto(id, nombre, valor) VALUES (?, ?, ?)";
			PreparedStatement ps = this.conn.prepareStatement(insert);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNombre());
			ps.setFloat(3, p.getValor());
			ps.executeUpdate();
			ps.close();
			this.cerrarConexion();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);	
		}	

	}	

	@Override
	public void eliminar(Producto p) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar(Producto p) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Producto> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() throws Exception {
		this.cerrarConexion();		
	}

}
