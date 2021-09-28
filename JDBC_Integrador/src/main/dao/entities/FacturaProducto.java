package main.dao.entities;

//Entidad FacturaProducto
public class FacturaProducto {
	private int idProducto;
	private int idFactura;
	private int cantidad;
	
	public FacturaProducto() {
		super();
	}

	public FacturaProducto(int idProducto, int idFactura, int cantidad) {
		super();
		this.idProducto = idProducto;
		this.idFactura = idFactura;
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdFactura() {
		return idFactura;
	}
	
	public int getIdProducto() {
		return idProducto;
	}

	@Override
	public String toString() {
		return "FacturaProducto [idProducto=" + idProducto + ", idFactura=" + idFactura + ", cantidad=" + cantidad
				+ "]";
	}	

}
