package carlosfontela.utilidades;

import java.util.Arrays;

public class DiaSemana implements Numerable {
	
	private String nombreDia;
	private int numeroDia;
	private String[ ] numerosNombres =
		{"", "lunes", "martes", "mi�rcoles", "jueves", "viernes", "s�bado", "domingo"};
	
	public DiaSemana (int numeroDia) {
		if (numeroDia > 0 && numeroDia < 8) {
			this.numeroDia = numeroDia;
			this.nombreDia = numerosNombres[numeroDia];
		}
		else throw new IllegalArgumentException ( );
	}
	
	/*
	public int ToInt( ) {
		return numeroDia;
	}
	*/

	@Override
	public int toInt() {
		return numeroDia;
	}

	@Override
	public String toString() {
		return "DiaSemana = " + nombreDia+" ";
	}

	@Override
	public String mostrar() {
		return this.toString()+ this.numeroDia;
	}

	
}

