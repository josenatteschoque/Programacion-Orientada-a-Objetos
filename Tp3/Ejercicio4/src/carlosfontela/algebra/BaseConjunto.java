// BaseConjunto.java
package carlosfontela.algebra;

public abstract class BaseConjunto implements Conjunto {
	
	public Conjunto union (Conjunto b) {
		int baseNuevo = Math.max (this.getBase( ), b.getBase( ));
		Conjunto c = new ConjuntoArreglo (baseNuevo);
		if (this.getBase( ) > b.getBase( )) {
			int x = 0;
			// recorremos ambos conjuntos hasta que termine el m�s corto (b)
			while (x < b.getBase( )) {
				if (this.pertenece(x) || b.pertenece(x)) 
					c.agregarElemento(x);
				x++;
			}
			// recorremos el m�s largo (a) hasta que termine
			while (x < this.getBase( )) {
				if (this.pertenece(x))
					c.agregarElemento(x);
				x++;
			}
		}
		else {	// el b es m�s largo que el a
			int x = 0;
			// recorremos ambos conjuntos hasta que termine el m�s corto (a)
			while (x < this.getBase( )) {
				if (this.pertenece(x) || b.pertenece(x))
					c.agregarElemento(x);
				x++;
			}
			// recorremos el m�s largo (b) hasta que termine
			while (x < b.getBase( )) {
				if (b.pertenece(x))
					c.agregarElemento(x);
				x++;
			}
		}
		return c;
	}

	public Conjunto interseccion (Conjunto b) {
		int baseNuevo = Math.max (this.getBase( ), b.getBase( ));
		Conjunto c = new ConjuntoArreglo (baseNuevo);
		int x = 0;
		// recorremos ambos conjuntos hasta que termine el m�s corto
		while (x < Math.min(this.getBase( ),b.getBase( ))) {
			if (this.pertenece(x) && b.pertenece(x)) 
				c.agregarElemento(x);
			x++;
		}
		return c;
	}

	public Conjunto diferencia (Conjunto b) {
		int baseNuevo = Math.max (this.getBase( ), b.getBase( ));
		Conjunto c = new ConjuntoArreglo (baseNuevo);
		
		for(int i = 0; i < baseNuevo; i++) {
			if(this.pertenece(i) && !b.pertenece(i)) {
				c.agregarElemento(i);
			}
		}
		return c;
	}

	public boolean incluido (Conjunto b) {
		boolean incluido = true;
		for (int x = 0; x < this.getBase( ); x++)
			if (this.pertenece(x) && !b.pertenece(x))
				incluido = false;
		return incluido;
	}

	public boolean igual (Conjunto b) {
		boolean iguales = true;
		
		if(this.cardinalidad() != b.cardinalidad()) {
			return false;
		}
		
		//Agregue esta nueva variable para que compare los elementos hasta la maxima base de un conjunto
		int maxBase = Math.max(this.getBase(), b.getBase()); 
		for (int x = 0; x < maxBase; x++) {
			if (this.pertenece(x) != b.pertenece(x)) {
				iguales = false;
				break;
			}
		}
		return iguales;
	}

	@Override
	public String toString() {
		return "BaseConjunto [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	public Conjunto diferenciaSimetrica(Conjunto b) {
		//(A - B) U (B - A) 
		Conjunto c= this.diferencia(b).union(b.diferencia(this));
		return c;
	}
	
	
}
