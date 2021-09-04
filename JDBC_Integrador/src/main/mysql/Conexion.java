package main.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
		//contiene los datos requeridos para establecer una conexion
		//configura el Driver
		//utiliza protocolo jdbc y crea una base de datos en caso de no existir
		protected Connection conn;
		private final String JDBCDriver = "com.mysql.cj.jdbc.Driver";
		private final String dbUri = "jdbc:mysql://localhost:3306/db_jdbc_integrador?createDatabaseIfNotExist=true";
		private final String user = "root";
		private final String pass = "password";


		
		//ABRE LA CONEXION
		public Connection abrirConexion() throws SQLException {
			try {
				conn = DriverManager.getConnection(dbUri, user, pass);
				Class.forName(JDBCDriver);
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			return conn;
		}

		
		//CIERRA LA CONEXION
		public void cerrarConexion() throws SQLException {
			if(conn != null) {
				if(!conn.isClosed()) {
					conn.close();
				}
			}
		}
}
