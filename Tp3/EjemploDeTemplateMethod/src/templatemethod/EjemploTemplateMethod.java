package templatemethod;

// ============================================================
// EJEMPLO DE PATRON TEMPLATE METHOD
// ============================================================
// Idea del patron:
// - En la clase abstracta se define el "esqueleto" del algoritmo
//   (el orden de los pasos), en un metodo que NO se puede
//   sobreescribir (por eso es "final").
// - Algunos pasos ya vienen implementados (son iguales para
//   todas las subclases).
// - Otros pasos son abstractos: cada subclase decide COMO
//   hacer ese paso, pero no puede cambiar el ORDEN general.
// ============================================================

abstract class PreparadorBebida {

    // Este es el "template method": define el algoritmo general.
    // Es "final" para que ninguna subclase pueda cambiar el orden
    // de los pasos.
    public final void prepararBebida() {
        hervirAgua();
        verterEnTaza();
        agregarCondimentos(); // paso variable -> lo define cada subclase
        if (deseaExtras()) {  // "hook": paso opcional
            agregarExtras();
        }
        System.out.println("Bebida lista para tomar!");
        System.out.println("-------------------------------");
    }

    // Pasos comunes a todas las bebidas (ya implementados aca):
    private void hervirAgua() {
        System.out.println("Hirviendo agua...");
    }

    private void verterEnTaza() {
        System.out.println("Sirviendo en la taza...");
    }

    // Paso abstracto: cada subclase LO TIENE que implementar.
    protected abstract void agregarCondimentos();

    // "Hook" (gancho): metodo opcional con implementacion por
    // defecto, que las subclases PUEDEN sobreescribir si quieren,
    // pero no es obligatorio.
    protected boolean deseaExtras() {
        return false;
    }

    protected void agregarExtras() {
        // por defecto no hace nada
    }
}

// ------------------------------------------------------------
// Subclase 1: Te
// ------------------------------------------------------------
class Te extends PreparadorBebida {

    @Override
    protected void agregarCondimentos() {
        System.out.println("Agregando una bolsita de te...");
    }

    @Override
    protected boolean deseaExtras() {
        return true; // el te lleva extra
    }

    @Override
    protected void agregarExtras() {
        System.out.println("Agregando una rodaja de limon...");
    }
}

// ------------------------------------------------------------
// Subclase 2: Cafe
// ------------------------------------------------------------
class Cafe extends PreparadorBebida {

    @Override
    protected void agregarCondimentos() {
        System.out.println("Agregando cafe molido y azucar...");
    }
    // Cafe no sobreescribe deseaExtras(), asi que usa el valor
    // por defecto (false) y no agrega nada extra.
}

// ------------------------------------------------------------
// Clase principal para probar el ejemplo
// ------------------------------------------------------------
public class EjemploTemplateMethod {	

    public static void main(String[] args) {
        System.out.println("Preparando un TE:");
        PreparadorBebida bebida1 = new Te();
        bebida1.prepararBebida();

        System.out.println("Preparando un CAFE:");
        PreparadorBebida bebida2 = new Cafe();
        bebida2.prepararBebida();
    }
}
