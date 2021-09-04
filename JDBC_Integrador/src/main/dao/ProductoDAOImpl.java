package main.dao;

import main.dao.entities.Producto;
import main.mysql.Conexion;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductoDAOImpl extends Conexion implements AutoCloseable, ProductoDAO  {

	//Creacion de la tabla Producto
	public ProductoDAOImpl() {
		try {
			this.abrirConexion();
			String table = "CREATE TABLE IF NOT EXISTS producto (id INT, nombre VARCHAR(500), valor DECIMAL, PRIMARY KEY(id)) " ;
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

	//Insercion de tupla en tabla
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
	
	//Obtiene el producto que mas ha recaudado
	public String getProductoMasRecaudado() throws Exception {
		try {
			this.abrirConexion();
			String select = "SELECT p.nombre as nombre, SUM(p.valor * fp.cantidad) as monto FROM producto p INNER JOIN factura_producto fp on p.id = fp.idProducto GROUP BY p.id ORDER BY monto DESC limit 1";
			PreparedStatement ps = this.conn.prepareStatement(select);
			ResultSet rs = ps.executeQuery(select);
			String valorReturn = "";
			if(rs.next())
			{
				String nombre = rs.getString("nombre");
				float monto = rs.getFloat("monto");
				valorReturn= "['"+ nombre + "'," +monto +"]";
			}
			ps.close();
			this.cerrarConexion();
			return valorReturn;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			return "";
		}
	}
	

	//	Metodos no implementados en esta instancia del trabajo
	//  correspondientes al ABM de la entidad
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

	//Override de metodo close por implementacion del AutoCloseable
	@Override
	public void close() throws Exception {
		this.cerrarConexion();		
	}


}
