package main.dao;

//Implementacion Factory Method

public class DAOFactory {
	protected static final DAOFactory INSTANCE = new DAOFactory();
		
	private DAOFactory() {

	}
		
	//SINGLETON --> crea una unica instancia
	public static DAOFactory getInstance() {
		return INSTANCE;
	}
	
	//Instanciacion de DAO de las entidades
	
	public ProductoDAO getProductoDao() {
		return new ProductoDAOImpl();
	}
	
	public ClienteDAO getClienteDao() {
		return new ClienteDAOImpl();
	}
	
	public FacturaDAO getFacturaDao() {
		return new FacturaDAOImpl();
	}
	
	public FacturaProductoDAO getFacturaProductoDao() {
		return new FacturaProductoDAOImpl();
	}

}
