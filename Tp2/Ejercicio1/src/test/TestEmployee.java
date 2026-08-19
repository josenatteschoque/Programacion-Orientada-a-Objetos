package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import Fig10_04_09.BasePlusCommissionEmployee;
import Fig10_04_09.CommissionEmployee;
import Fig10_04_09.HourlyEmployee;
import Fig10_04_09.SalariedEmployee;

public class TestEmployee {
	
	private SalariedEmployee salariedEmployee = new SalariedEmployee( "John", "Smith", "111-11-1111", 800.00 );
	private HourlyEmployee hourlyEmployee =  new HourlyEmployee( "Karen", "Price", "222-22-2222", 16.75, 40 );
	private CommissionEmployee commissionEmployee = new CommissionEmployee( "Sue", "Jones", "333-33-3333", 10000, .06 );
	private BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee( "Bob", "Lewis", "444-44-4444", 5000, .04, 300 );

	@Test
	public void testSalariedEmployesEarnings() {
		assertEquals(800.00, salariedEmployee.earnings());
		assertEquals("John", salariedEmployee.getFirstName());
	}
	
	@Test
	public void testHourlyEmployeeEarnings() {
		assertEquals(670.00, hourlyEmployee.earnings());
	}

	@Test
	public void testCommissionEmployee() {
		assertEquals(10000 ,commissionEmployee.earnings());
	}
	
	@Test
	public void testBasePlusCommissionEmployee() {
		assertEquals(100, basePlusCommissionEmployee.earnings());
	}
}
