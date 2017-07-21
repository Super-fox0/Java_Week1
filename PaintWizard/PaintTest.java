package javaWork;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaintTest {
	

	@Test
	public void priceTest() 
	{

		PaintWizard x = new PaintWizard();
		x.leastWaste(1000);
		double result = x.priceGet();
		
		assertEquals(99.94999999999999, result, 0.1);
		
	}
	
	@Test
	public void wasteCheck()
	{
		PaintWizard x = new PaintWizard();
		double result = x.leastWaste(1000);
		
		assertEquals(0, result, 0.1);
	}
	
	


}
