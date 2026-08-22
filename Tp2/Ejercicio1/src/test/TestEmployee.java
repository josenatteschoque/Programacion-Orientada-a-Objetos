package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import Fig10_04_09.BasePlusCommissionEmployee;
import Fig10_04_09.CommissionEmployee;
import Fig10_04_09.Employee;
import Fig10_04_09.HourlyEmployee;
import Fig10_04_09.SalariedEmployee;

public class TestEmployee {

	private SalariedEmployee salariedEmployee;
	private HourlyEmployee hourlyEmployee;
	private CommissionEmployee commissionEmployee;
	private BasePlusCommissionEmployee basePlusCommissionEmployee;

	// se ejecuta ANTES de cada test, así cada uno arranca con objetos frescos
	@BeforeEach
	void setup() {
		salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
		hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
		commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
		basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300);
	}

	@Test
	void testSalariedEmployeeEarnings() {
		assertEquals(800.00, salariedEmployee.earnings());
	}

	@Test
	void testHourlyEmployeeEarnings() {
		// 16.75 x 40 = 670.00
		assertEquals(670.00, hourlyEmployee.earnings());
	}

	@Test
	void testCommissionEmployeeEarnings() {
		// 10000 x 0.60 = 600.00
		assertEquals(600.00, commissionEmployee.earnings());
	}

	@Test
	void testBasePlusCommissionEmployeeEarnings() {
		// 300 + (5000 × 0.04) = 300 + 200 = 500.00
		assertEquals(500.00, basePlusCommissionEmployee.earnings());
	}

	// --- Test de procesamiento polimórfico ---

	@Test
	void testPolymorphicArray() {
		Employee employees[] = new Employee[4];
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;

		// verifica que cada elemento sea del tipo correcto
		assertTrue(employees[0] instanceof SalariedEmployee);
		assertTrue(employees[1] instanceof HourlyEmployee);
		assertTrue(employees[2] instanceof CommissionEmployee);
		assertTrue(employees[3] instanceof BasePlusCommissionEmployee);

	}

	// --- Test del downcast e incremento de baseSalary ---
	@Test
	void testBaseSalaryIncrease() {
		double oldBaseSalary = basePlusCommissionEmployee.getBaseSalary(); // 300
		basePlusCommissionEmployee.setBaseSalary(1.10 * oldBaseSalary);

		assertEquals(330.00, basePlusCommissionEmployee.getBaseSalary(), 0.01);
	}

}