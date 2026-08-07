package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Negocio {

	private String cuit;
	private String nombre;
	private List<Articulo> articulos = new ArrayList<>();
	private List<Factura> facturas = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();

	public Negocio(String cuit, String nombre) {
		this.cuit = cuit;
		this.nombre = nombre;
	}

	public String getCuit() {
		return cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public Cliente agregarCliente(String nombre, String telefono) {
		Cliente cliente = new Cliente(nombre, telefono);
		clientes.add(cliente);
		return cliente;
	}

	public Articulo agregarArticulo(int codigo, String descripcion, double precio, double cantidad) {
		Articulo articulo = new Articulo(codigo, descripcion, precio, cantidad);
		articulos.add(articulo);
		return articulo;
	}

	// Crea la factura con su primer item, tal como se usa en el test
	public Factura agregarFactura(int numero, LocalDate fecha, Articulo articulo, double cantidad) {
		Factura factura = new Factura(numero, fecha);
		factura.agregarItem(articulo, cantidad);
		facturas.add(factura);
		return factura;
	}
}
