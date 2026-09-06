package carlosfontela.utilidades;

public class PruebaNumerables {

	public static void main(String [ ] p) {
		Numerable dm1 = new FechaDC (11, 12, 2009);
		Numerable dm2 = new FechaDC (24, 5, 2009);
		Numerable ds1 = new DiaSemana(2);
		Numerable ds2 = new DiaSemana(5);
		
		Numerable t1 = new Tiempo(15, 38, 45);
		
		
		System.out.println (UtilidadesNumerables.mayor (dm1, ds1));
		
		System.out.println (UtilidadesNumerables.suma (dm1, ds1));

		Numerable[ ] v = new Numerable[4];
		v[0] = dm1;
		v[1] = dm2;
		v[2] = ds1;
		v[3] = ds2;
		UtilidadesNumerables.ordenar(v);
		
		//Pruebo el metodo ordenardo()
		System.out.println("Esta ordenado: "+UtilidadesNumerables.ordenardo(v));

		for(Numerable i: v) {
			System.out.println (i.toInt( ));
		}
		//Pruebo el metodo datos()
		System.out.println(dm1.mostrar());
		System.out.println(ds1.mostrar());

		//Pruebo el metodo toInt de la clase Tiempo
		System.out.println("Valor esperado = 56325 --> "+t1.toInt());

		/*
		System.out.println (v[0].toInt( ));
		System.out.println (v[1].toInt( ));
		System.out.println (v[2].toInt( ));
		System.out.println (v[3].toInt( ));
		*/

		// prueba de validacion: esto deberia lanzar IllegalArgumentException
		try {
			Numerable tInvalido = new Tiempo(24, 0, 0);
		} catch (IllegalArgumentException e) {
			System.out.println("Se detecto correctamente un Tiempo invalido (hora 24).");
		}
	}
}
