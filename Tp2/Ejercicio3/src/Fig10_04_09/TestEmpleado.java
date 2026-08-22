package Fig10_04_09;

import java.time.LocalDate;
import java.time.Month;

public class TestEmpleado {
	public static void main(String[] args) {
		//Creamos los empleados
		SalariedEmployee empleadoSalariado = new SalariedEmployee("Jose", "Smith", "111-11-1111", 800.00);
		HourlyEmployee empleadoPorHora = new HourlyEmployee("Wilder", "Price", "222-22-2222", 16.75, 40);
		CommissionEmployee empleadoPorComision = new CommissionEmployee("Karen", "Jones", "333-33-3333", 10000, .06);
		BasePlusCommissionEmployee empleadoMasBasePlusComision = new BasePlusCommissionEmployee("Bob", "Lewis",
				"444-44-4444", 5000, .04, 300);

		// Cargamos la fecha de compleaños de los empleados
		empleadoSalariado.setBirthDate(LocalDate.of(2006, Month.JANUARY, 4));
		empleadoPorHora.setBirthDate(LocalDate.of(2006, Month.OCTOBER, 12));
		empleadoPorComision.setBirthDate(LocalDate.of(2003, Month.APRIL, 13));
		empleadoMasBasePlusComision.setBirthDate(LocalDate.of(1990, Month.AUGUST, 20));

		Employee[] empleados = { empleadoSalariado, empleadoPorHora, empleadoPorComision, empleadoMasBasePlusComision };
		
		LocalDate mesLiquidacion = LocalDate.of(2000, Month.JANUARY, 12);
		LocalDate mesDistinto = LocalDate.of(2007, Month.DECEMBER, 1);
		System.out.printf("Adicional en mes de cumpleaños: " + mesLiquidacion.getMonthValue()+"\n");
		
		for (Employee e : empleados) {
			System.out.println(e.getFirstName());
			System.out.print("Mes de cumpleaños: " + e.getBirthDate().getMonthValue()+"\n");
			//Caso 1
			System.out.println("Liquidacion en su mes de cumpleaños ("+mesLiquidacion+"): $"+ e.salary(mesLiquidacion));
			
			//Caso 2
			System.out.println("Liquidacion fuera de su mes de cumpleaños ("+mesDistinto+"): $"+e.salary(mesDistinto));
		}

	}
}
