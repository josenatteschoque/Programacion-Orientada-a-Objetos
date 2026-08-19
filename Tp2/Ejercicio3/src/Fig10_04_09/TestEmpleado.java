package Fig10_04_09;

public class TestEmpleado {
	public static void main(String[] args) {
		SalariedEmployee salariedEmployee = new SalariedEmployee( "John", "Smith", "111-11-1111", 800.00 );
		HourlyEmployee hourlyEmployee = new HourlyEmployee( "Karen", "Price", "222-22-2222", 16.75, 40 );
		CommissionEmployee commissionEmployee =new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06 );
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300 );
	
	}
}
