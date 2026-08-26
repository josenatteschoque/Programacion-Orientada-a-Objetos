// Poligono.java
package carlosfontela.geometria;

import java.awt.Color;
import java.awt.Graphics;

public class Poligono extends Figura {

	private Punto[] contorno;
	private Color colorBorde;	

	public Poligono(Punto[] contorno, Color colorBorde) {
		if (contorno.length < 3)
			// veremos el significado de lo que sigue en un capítulo posterior:
			throw new IllegalArgumentException();
		this.contorno = contorno;
		this.colorBorde = colorBorde;  		
	}

	static protected double areaTrapecio(Punto p1, Punto p2) {
		return (p1.getY() + p2.getY()) * (p2.getX() - p1.getX()) / 2;
	}

	public int numeroLados() {
		return contorno.length;
	}

	public double area() {
		double superficie = areaTrapecio(contorno[numeroLados() - 1],
				contorno[0]);
		for (int i = 0; i < numeroLados() - 1; i++)
			superficie += areaTrapecio(contorno[i], contorno[i + 1]);
		return superficie;
	}

	public double perimetro() {
		double longitud = contorno[numeroLados() - 1].distancia(contorno[0]);
		for (int i = 0; i < numeroLados() - 1; i++)
			longitud += contorno[i].distancia(contorno[i + 1]);
		return longitud;
	}

	private Segmento lado(int i) {
		if (i < numeroLados() - 1)
			return new Segmento(contorno[i], contorno[i + 1]);
		else
			return new Segmento(contorno[i], contorno[0]);
	}

	// verifica si es un polígono con todos sus lados iguales
	public boolean regular() {
		for (int i = 0; i < contorno.length - 1; i++) {
			if (lado(i).getLongitud() != lado(i + 1).getLongitud())
				return false;
		}
		return true;
	}

	public String tipo() {
		if (numeroLados() == 3 && regular())
			return "triángulo equilátero";
		if (numeroLados() == 4 && regular())
			return "cuadrado";
		String nombre = null;
		switch (numeroLados()) {
		case 3:
			nombre = "triángulo";
			break;
		case 4:
			nombre = "cuadrilátero";
			break;
		case 5:
			nombre = "pentágono";
			break;
		case 6:
			nombre = "hexágono";
			break;
		case 7:
			nombre = "heptágono";
			break;
		case 8:
			nombre = "octógono";
			break;
		case 9:
			nombre = "nonágono";
			break;
		case 10:
			nombre = "decágono";
			break;
		case 12:
			nombre = "dodecágono";
			break;
		case 20:
			nombre = "icoságono";
			break;
		default:
			nombre = "sin nombre";
		}
		if (regular())
			nombre += " regular";
		return nombre;
	}

	public void trasladar(double deltaX, double deltaY) {
		for (int i = 0; i < contorno.length; i++)
			contorno[i].trasladar(deltaX, deltaY);
	}

	public void dibujar(Graphics g) {
		int[] xPuntos = new int[contorno.length];
		int[] yPuntos = new int[contorno.length];

		for (int i = 0; i < contorno.length; i++) {
			xPuntos[i] = (int) contorno[i].getX();
			yPuntos[i] = (int) contorno[i].getY();
		}

		
		Color colorActual = g.getColor();
				
		g.setColor(colorBorde);
		g.drawPolygon(xPuntos, yPuntos, contorno.length);
		
		g.setColor(colorActual);
		
	}

}
