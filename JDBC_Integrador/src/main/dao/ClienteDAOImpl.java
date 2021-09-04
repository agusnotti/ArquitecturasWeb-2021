package main.dao;

import main.dao.entities.Cliente;
import main.mysql.Conexion;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl extends Conexion implements AutoCloseable, ClienteDAO {
	
	//Creacion de la tabla Cliente
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
	
	//Insercion de tuplas en tabla por medio de archivo CSV
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

	//Insercion de tupla en tabla
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

	//Obtiene un listado de los clientes ordenados en funcion del monto que se les ha facturado
	public ArrayList<Cliente> getClienteMasRecaudador() {
		ArrayList<Cliente> clientes = new ArrayList<>();
		try {
			this.abrirConexion();
			String select = "SELECT c.*, monto FROM cliente c INNER JOIN (\n" +
					"SELECT f.idCliente, sum(p.valor * fp.cantidad) monto FROM factura F \n" +
					"INNER JOIN factura_producto fp ON f.idFactura = fp.idFactura \n" +
					"INNER JOIN producto p on p.id = fp.idProducto\n" +
					"group by f.idCliente ) SC ON c.idCliente = SC.idCliente order by monto desc";
			PreparedStatement ps = this.conn.prepareStatement(select);
			ResultSet rs = ps.executeQuery(select);

			while (rs.next()) {
				clientes.add(new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			ps.close();
			this.cerrarConexion();
		}
		catch (SQLException e) {
		e.printStackTrace();
		}
		return clientes;
	}

	
//	Metodos no implementados en esta instancia del trabajo
//  correspondientes al ABM de la entidad
	
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
	
	//Override de metodo close por implementacion del AutoCloseable
	@Override
	public void close() throws Exception {
		this.cerrarConexion();

	}

}
