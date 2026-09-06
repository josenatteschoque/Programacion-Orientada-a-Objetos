package carlosfontela.utilidades;

public class Tiempo implements Numerable{
	private int hora;
	private int minuto;
	private int segundos;
	
	
	public Tiempo(int hora, int minuto, int segundos) {
		super();
		if(!valida(hora,minuto,segundos)) {
			throw new IllegalArgumentException ();
		}
		this.hora = hora;		
		this.minuto = minuto;
		this.segundos = segundos;
	}
	
	public boolean valida(int h, int m, int s) {
		if(h < 0 || h > 23 ) {
			return false;
		}
		
		if(m < 0 || m > 59) {
			return false;
		}
		
		if(s < 0 || s > 59) {
			return false;
		}
		
		return true;
	}
	@Override
	public int toInt() {
		return this.hora * 3600 + this.minuto * 60 + this.segundos;
	}

	@Override
	public String toString() {
		return "Tiempo [hora=" + hora + ", minuto=" + minuto + ", segundos=" + segundos + "]";
	}

	@Override
	public String mostrar() {
		return this.toString();
	}

}
