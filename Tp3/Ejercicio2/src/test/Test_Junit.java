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
	
	@BeforeEach
	void carga() {
	    // populate array with objects that implement Payable
	    payableObjects[ 0 ] = new Invoice( "01234", "seat", 2, 375.00 );
	    payableObjects[ 1 ] = new Invoice( "56789", "tire", 4, 79.95 );
	    payableObjects[ 2 ] = new SalariedEmployee( "John", "Smith", "111-11-1111", 800.00 );
	    payableObjects[ 3 ] = new SalariedEmployee( "Lisa", "Barnes", "888-88-8888", 1200.00 );
	}
	
	@Test
	void test() {
		asserEquals();
	}
   
}
