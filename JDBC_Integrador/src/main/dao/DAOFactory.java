package main.dao;

public class DAOFactory {
	protected static final DAOFactory INSTANCE = new DAOFactory();
		
	private DAOFactory() {

	}
		
	//SINGLETON --> unica instancia
	public static DAOFactory getInstance() {
		return INSTANCE;
	}
	
	//crea los daos
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
