package ferreteria;

import java.util.Date;

import ferreteria.Negocio.StockInsuficienteException;

public class TestFerreteria {

	public static void main(String args[]) {
		
		Articulo martillo = new Articulo(123, "Martillo", 1.500, 2.0);
		Articulo clavos = new Articulo(124, "Clavos", 3.500, 1.0);

		Negocio negocio = new Negocio("Ferreteria Pepe");
		negocio.agregarArticulo(martillo);
		
		Factura factura1 = new Factura(1, new Date());
		
		try {
			negocio.vender(martillo, 1);
			System.out.print("Venta Realizada con exito!");
		}catch (StockInsuficienteException e) {
			System.out.print("No se pude vender: " +e.getMessage());
		}
		
		ItemFactura item1 = new ItemFactura(2, 1200);
		factura1.agragarItem(item1);
		
		
		
	}
}
