// Figura.java
package geometria;

import java.awt.Graphics;

public abstract class Figura {
	public abstract double area ( );
	public abstract double perimetro ( );
	public abstract String tipo( );
	public abstract void trasladar (double deltaX, double deltaY);
	public abstract void dibujar(Graphics g);
	
	/**
	 * Una forma ecuable bidimensional, es aquella cuya área es
	 * numéricamente igual a su perímetro
	 * 
	 * @return true si el area de la figura es igual al perímetro
	 */
	 public boolean figuraEquable() {
		 //Margen de tolerancia
		 final double EPSILON = 1E-6;
		 if(Math.abs(area() - perimetro()) < EPSILON) {
			 return true;
		 }
		 return false;
	 }


}
