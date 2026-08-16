package ferreteria;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class Negocio {
	private String nombre;
	private List<Articulo> articulos;
	private List<Factura> facturas;
	
	public Negocio(String nombre) {
		super();
		this.nombre = nombre;
		this.articulos = new ArrayList<>();
		this.facturas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(articulos, facturas, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Negocio other = (Negocio) obj;
		return Objects.equals(articulos, other.articulos) && Objects.equals(facturas, other.facturas)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Negocio [nombre=" + nombre + ", articulos=" + articulos + ", facturas=" + facturas + "]";
	}
	
	
	//Metodo que agraga una factura a la lista
	public void agregarFactura(Factura factura) {
		facturas.add(factura);
	}

	//Metodo que agraga un articulo a la lista
	public void agregarArticulo(Articulo articulo) {
		articulos.add(articulo);
	}
	
	
	/* Cambia en un porcentaje el precio de todos los artículos del stock
	 * @param porcCambio: porcentaje de cambio de precio */
	public void cambiarPrecio(double porcCambio) {
		//Recorro toda la lista de articulos
		for(Articulo articulo: this.articulos) {
			//precioNuevo = precioViejo + (precioViejo * porcCambio / 100)
			double precioNuevo = articulo.getPrecio() + (articulo.getPrecio() * porcCambio / 100);
			//Reescribo el precio 
			articulo.setPrecio(precioNuevo);
		}
	}
	
	
	/*Retorna el valor total del stock multiplicando la cantidad existente por el * precio 
	 * @return stock valorizado*/
	public double stockValorizado() {
		double contador = 0.0;
		//Recorro la lista de articulos
		for(Articulo articulo: this.articulos) {
			//Sumo todo el costo total del stock
			contador += articulo.getCantidad() * articulo.getPrecio();
		}
		//Devuelvo el valor total de stock
		return contador;
	}
	
	//Clase que me permitira lanzar una excepcion
	public class StockInsuficienteException extends Exception {
	    public StockInsuficienteException(String mensaje) {
	        super(mensaje);
	    }
	}
	
	//Clase que me permite lanzar una exception 
	public class ArticuloRepetidoException extends Exception{
		public ArticuloRepetidoException(String mensaje) {
			super(mensaje);
		}
	}
	
	//Metodo para evaluar la excepciones del stock
	public void vender(Articulo articulo, double cantidadVendida) throws StockInsuficienteException {
	    if (cantidadVendida > articulo.getCantidad()) {
	        throw new StockInsuficienteException("No hay suficiente stock de " + articulo.getDescripcion());
	    }
	    articulo.setCantidad(articulo.getCantidad() - cantidadVendida);
	}
	
	public void agregarItem(ItemFactura item) throws ArticuloRepetidoException {
		for(Articulo articulo: this.articulos) {
			if(articulo.equals(item)) {
				throw new ArticuloRepetidoException("Articulo repetido"+articulo.getDescripcion());
			}
		}
		
	    // acá va el for + if + throw
	    // pista: es el mismo patrón que usaste en empleadosACargo,
	    // recorrer y comparar con equals()
	}
	
	
	
}
