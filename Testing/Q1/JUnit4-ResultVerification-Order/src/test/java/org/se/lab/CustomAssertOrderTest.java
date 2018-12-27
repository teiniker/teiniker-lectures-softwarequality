package org.se.lab;

import org.junit.Before;
import org.junit.Test;

public class OrderTest
{
	private Order order;
	
	@Before
	public void setup()
	{
		order = new Order(1, "Special order");
		order.addOrderLine(new OrderLine(2, 1, new Product(3, "Pizza Frutti di Mare", 880)));
		order.addOrderLine(new OrderLine(4, 2, new Product(5, "Pizza Quattro Formaggi", 820)));		
	}
	
	
	@Test
	public void testOrder()
	{
	    Order expected = new Order(1, "Special order");
	    expected.addOrderLine(new OrderLine(2, 1, new Product(3, "Pizza Frutti di Mare", 880)));
	    expected.addOrderLine(new OrderLine(4, 2, new Product(5, "Pizza Quattro Formaggi", 820)));

	    CustomAssert.assertEquals(expected, order);
	}
}
