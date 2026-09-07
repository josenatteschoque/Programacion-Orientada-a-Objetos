package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.Invoice;
import business.Payable;
import business.SalariedEmployee;
import business.Employee;

public class Test_Junit {
	private Payable payableObjects[] = new Payable[ 4 ];
	private SalariedEmployee empleado1;
	private SalariedEmployee empleado2;
	private Invoice factura1;
	private Invoice factura2;
	
	@BeforeEach
	void carga() {
	    // populate array with objects that implement Payable
	    factura1 = new Invoice( "01234", "seat", 2, 375.00 );
	    factura2 = new Invoice( "56789", "tire", 4, 79.95 );
	    empleado1 = new SalariedEmployee( "John", "Smith", "111-11-1111", 800.00 );
	    empleado2 = new SalariedEmployee( "Lisa", "Barnes", "888-88-8888", 1200.00 );
	    
	    payableObjects[0] = factura1;
	    payableObjects[1] = factura2;
	    payableObjects[2] = empleado1;
	    payableObjects[3] = empleado2;
	}
	
	//Invoice 2 * 375.00 = 750 
	//Invoice 4 * 79.95 = 319.8
	@Test
	void testInvoice() {
		assertEquals(750, payableObjects[0].getPaymentAmount());
		assertEquals(319.8, payableObjects[1].getPaymentAmount());
	}
	
   @Test
   void testSalariedEmployee() {
	   assertEquals(800.00, payableObjects[2].getPaymentAmount());
	   assertEquals(1200.00, payableObjects[3].getPaymentAmount());
   }
   
   //VErifico sus nombres
   @Test
   void testFirstName() {
	   assertEquals("John", empleado1.getFirstName());
	   assertEquals("Lisa", empleado2.getFirstName());
   }
   
   @Test
   void testLastName() {
	   assertEquals("Smith", empleado1.getLastName());
	   assertEquals("Barnes", empleado2.getLastName());
   }
   
   @Test
   void testSocialSecurityNumber() {
	   assertEquals("111-11-1111", empleado1.getSocialSecurityNumber());
	   assertEquals("888-88-8888", empleado2.getSocialSecurityNumber());
   }
 
}
