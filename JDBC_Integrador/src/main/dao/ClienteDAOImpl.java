package main.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import main.dao.entities.Cliente;
import main.dao.entities.Producto;
import main.mysql.Conexion;

public class ClienteDAOImpl extends Conexion implements AutoCloseable, ClienteDAO {
	
	public ClienteDAOImpl() {
		try {
			this.abrirConexion();
			String table = "CREATE TABLE IF NOT EXISTS cliente (idCliente INT, nombre VARCHAR(500), email VARCHAR(500), PRIMARY KEY(idCliente))";
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
			int id =  Integer.parseInt(row.get("idCliente"));
			String nombre = row.get("nombre");
			String email = row.get("email");
			
			System.out.println(row.get("idCliente"));
			System.out.println(row.get("nombre"));
			System.out.println(row.get("email"));
			
			
			Cliente c = new Cliente(id, nombre, email);
			try {
				this.agregar(c);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}

	@Override
	public void agregar(Cliente c) throws Exception {
		try {
			this.abrirConexion();			
			String insert = "INSERT INTO cliente(idCliente, nombre, email) VALUES (?, ?, ?)";
			PreparedStatement ps = this.conn.prepareStatement(insert);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getNombre());
			ps.setString(3, c.getEmail());
			ps.executeUpdate();
			ps.close();
			this.cerrarConexion();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);	
		}
	}

	@Override
	public void eliminar(Cliente c) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar(Cliente c) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cliente> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void close() throws Exception {
		this.cerrarConexion();

	}

}
