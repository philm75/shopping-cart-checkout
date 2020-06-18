package com.woodmac.shopping.cart;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName(value="Item")
public class ItemTest {

	private final String name = "PS4";
	private final double price = 10.5d;
	private final double discount = 1d;

	@DisplayName(value="New Instance - With Null Name")
	@Test
	public void testNewInstance_NoName_Null() {			
		try {
			Item.newItem(null, price);			
		} catch (IllegalArgumentException e) {
			String expectedResult = "Name is required";
			assertEquals(expectedResult, e.getMessage());
		}		
	}
	
	@DisplayName(value="New Instance - With Blank Name")
	@Test
	public void testNewInstance_NoName_Blank() {			
		try {
			Item.newItem("", price);			
		} catch (IllegalArgumentException e) {
			String expectedResult = "Name is required";
			assertEquals(expectedResult, e.getMessage());
		}		
	}

	@DisplayName(value="New Instance - No Discount")
	@Test
	public void testNewInstance_NoDiscount() {				
		Item actualItem = Item.newItem(name, price);

		String expectedName = "PS4";
		double expectedPrice = 10.50d;
		
		assertSame(expectedName, actualItem.getName());
		assertEquals(expectedPrice, actualItem.getPrice());
	}

	@DisplayName(value="New Instance - With Discount")
	@Test
	public void testNewInstance_WithDiscount() {
		Item actualItem = Item.newItemWithDiscount(name, price, discount);

		String expectedName = "PS4";
		double expectedPrice = 10.50d;
		double expectedDiscount = 1d;
		
		assertSame(expectedName, actualItem.getName());
		assertEquals(expectedPrice, actualItem.getPrice());
		assertEquals(expectedDiscount, actualItem.getDiscount());		
	}

	@DisplayName(value="New Instance - Negative Price")
	@Test
	public void testNewInstance_WithNegativePrice() {
		try {
			Item.newItem(name, -0.5d);			
		} catch (IllegalArgumentException e) {
			String expectedResult = "Price cannot be negative";
			assertEquals(expectedResult, e.getMessage());
		}	
	}
	
	@DisplayName(value="New Instance - Negative Discount")
	@Test
	public void testNewInstance_WithNegativeDiscount() {
		try {
			Item.newItemWithDiscount(name, 10.50d, -0.5d);			
		} catch (IllegalArgumentException e) {
			String expectedResult = "Discount cannot be negative";
			assertEquals(expectedResult, e.getMessage());
		}		
	}
	
	@DisplayName(value="Get Name - Ok")
	@Test
	public void testGetName_Ok() {		
		Item actualItem = Item.newItem(name, price);
		String expectedName = "PS4";		

		assertSame(expectedName, actualItem.getName());
	}
	
	@DisplayName(value="Get Discount - Ok")
	@Test
	public void testGetDiscount_Ok() {		
		Item actualItem = Item.newItemWithDiscount(name, price, discount);
		double expectedDiscount = 1d;
		
		assertEquals(expectedDiscount, actualItem.getDiscount());	
	}

	@DisplayName(value="Get Price - Ok")
	@Test
	public void testGetPrice_Ok() {		
		Item actualItem = Item.newItemWithDiscount(name, price, discount);
		double expectedPrice = 10.50d;
		
		assertEquals(expectedPrice, actualItem.getPrice());
	}
	
	@DisplayName(value="Equals - When Is Equal To Self")
	@Test
	public void testEquals_isEqualToSelf() {		
		Item item = Item.newItem(name, price);
		
		assertTrue(item.equals(item));
	}		

	@DisplayName(value="Equals - When Other Is Null")
	@Test
	public void testEquals_NullObj_false() {		
		Item item = Item.newItem(name, price);
		
		assertFalse(item.equals(null));
	}
	
	@DisplayName(value="Equals - When Other Is Not An Item")
	@Test
	public void testEquals_NotAnItem_false() {		
		Item item = Item.newItem(name, price);

		assertFalse(item.equals(new String("")));
	}	
	
	@DisplayName(value="Equals - When Items are Different")
	@Test
	public void testEquals_DifferentItems_false() {		
		Item item = Item.newItem(name, price);
		Item other = Item.newItem("PS5", price);
		
		assertFalse(item.equals(other));
	}

	@DisplayName(value="Equals - When Items are Equal")
	@Test
	public void testEquals_SameItems_true() {		
		Item item = Item.newItem(name, price);
		Item other = Item.newItem(name, price);
		
		assertTrue(item.equals(other));
	}	
	
	@DisplayName(value="HashCode")
	@Test
	public void testHashCode() {		
		Item item = Item.newItem(name, price);
		int actualResult = item.hashCode();
		int expectedResult = 79536;
		
		assertEquals(expectedResult, actualResult);
	}	
}