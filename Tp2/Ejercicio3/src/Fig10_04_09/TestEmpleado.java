package Fig10_04_09;

import java.time.LocalDate;
import java.time.Month;

public class TestEmpleado {
	public static void main(String[] args) {
		SalariedEmployee salariedEmployee = new SalariedEmployee( "John", "Smith", "111-11-1111", 800.00 );
		HourlyEmployee hourlyEmployee = new HourlyEmployee( "Karen", "Price", "222-22-2222", 16.75, 40 );
		CommissionEmployee commissionEmployee =new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06 );
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300 );
	
		salariedEmployee.setBirthDate(LocalDate.of(2006, Month.JANUARY, 4));
		hourlyEmployee.setBirthDate(LocalDate.of(2006, Month.OCTOBER, 12));
		commissionEmployee.setBirthDate(LocalDate.of(2003, Month.APRIL, 13));
		basePlusCommissionEmployee.setBirthDate(LocalDate.of(1990, Month.AUGUST, 20));
		
		Employee[] empleados = { salariedEmployee, hourlyEmployee, commissionEmployee,basePlusCommissionEmployee};
		for(Employee e: empleados) {
			System.out.println(e.getFirstName());
			System.out.printf("Mes de cumpleaños de: "+e.getBirthDate().getMonthValue());
			
			LocalDate mesLiquidacion = LocalDate.of(2000, Month.JANUARY, 12);
			System.out.printf(" Liquidacion en mes de cumpleaños: "+ mesLiquidacion, e.salary(mesLiquidacion));
			//System.out.println(" "+ e.earnings());
		}
		
		
	}
}
