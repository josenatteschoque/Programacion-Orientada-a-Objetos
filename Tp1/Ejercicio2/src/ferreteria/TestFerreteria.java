package ferreteria;

import java.util.Date;

import ferreteria.Factura.ArticuloRepetidoException;
import ferreteria.Negocio.StockInsuficienteException;

public class TestFerreteria {

	public static void main(String args[]) {
		
		Articulo martillo = new Articulo(123, "Martillo", 1500.0, 2.0);
		Articulo clavos = new Articulo(124, "Clavos", 3500.0, 1.0);

		Negocio negocio = new Negocio("Ferreteria Pepe");
		
		negocio.agregarArticulo(martillo);
		negocio.agregarArticulo(clavos);
		
		
		Factura factura1 = new Factura(1, new Date());
		negocio.agregarFactura(factura1);
		
		
		try {
			negocio.vender(martillo, 1);
			System.out.println("Venta Realizada con exito!");
		}catch (StockInsuficienteException e) {
			System.out.println("No se pude vender: " +e.getMessage());
		}
		
		try {
            ItemFactura item1 = new ItemFactura(1, 1500.0, martillo);
            factura1.agregarItem(item1);
            System.out.println("Item agregado con exito!");

            ItemFactura item2 = new ItemFactura(1, 1500.0, martillo); // mismo articulo!
            factura1.agregarItem(item2); // esto debería lanzar la excepción
        } catch (ArticuloRepetidoException e) {
            System.out.println("No se pudo agregar el item: " + e.getMessage());
        }
		
	}
}
