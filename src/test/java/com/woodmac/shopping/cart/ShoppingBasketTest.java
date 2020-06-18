package com.woodmac.shopping.cart;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

@DisplayName(value="Shopping Basket")
public class ShoppingBasketTest {

	private final Item testItem = Item.newItem("PS4", 10.50d);
	
	@DisplayName(value="Add Item - Ok")
	@Test
	public void testAddItem_Ok() {
		ShoppingBasket shoppingBasket = ShoppingBasket.newShoppingBasket();
		boolean actualResult = shoppingBasket.addItem(testItem);
		
		assertTrue(actualResult);
	}
	
	@DisplayName(value="Add Item - Null")
	@Test
	public void testAddItem_Null() {
		ShoppingBasket shoppingBasket = ShoppingBasket.newShoppingBasket();
		boolean actualResult = shoppingBasket.addItem(null);
				
		assertFalse(actualResult);
	}
	
	@DisplayName(value="Add Item - Duplicate")
	@Test
	public void testAddItem_DuplicateItem() {
		ShoppingBasket shoppingBasket = ShoppingBasket.newShoppingBasket();
		shoppingBasket.addItem(testItem);
		
		Item duplicateItem = Item.newItem("PS4", 10.50d);		
		boolean actualResult = shoppingBasket.addItem(duplicateItem);
		
		assertFalse(actualResult);
	}

	@DisplayName(value="Remove Item - Ok")
	@Test
	public void testRemoveItem_Ok() {
		ShoppingBasket shoppingBasket = ShoppingBasket.newShoppingBasket();
		shoppingBasket.addItem(testItem);
		Item currentItem = shoppingBasket.getItems().get(0);
		
		boolean actualResult = shoppingBasket.removeItem(currentItem);
		assertTrue(actualResult);	
	}

	@DisplayName(value="Remove Item - Item does not exist")
	@Test
	public void testRemoveItem_ItemDoesNotExist() {
		ShoppingBasket shoppingBasket = ShoppingBasket.newShoppingBasket();
		
		boolean actualResult = shoppingBasket.removeItem(testItem);
		assertFalse(actualResult);
	}	

	@DisplayName(value="Get Items - With Items")
	@Test
	public void testGetItems_WithItems() {
		ShoppingBasket shoppingBasket = ShoppingBasket.newShoppingBasket();
		shoppingBasket.addItem(testItem);
		
		List<Item> actualResult = shoppingBasket.getItems();
		
		assertFalse(actualResult.isEmpty());
	}
	
	@DisplayName(value="Get Items - Empty List")
	@Test
	public void testGetItems_EmptyList() {
		ShoppingBasket shoppingBasket = ShoppingBasket.newShoppingBasket();
		List<Item> actualResult = shoppingBasket.getItems();
		
		assertTrue(actualResult.isEmpty());
	}		
	
	@DisplayName(value="To String - No Items")
	@Test
	public void testToString_NoItems() {
		ShoppingBasket shoppingBasket = ShoppingBasket.newShoppingBasket();
		String expectedResult = "Items: ";
		
		assertEquals(expectedResult, shoppingBasket.toString());
	}

	@DisplayName(value="To String - With Items")
	@Test
	public void testToString_WithItems() {
		ShoppingBasket shoppingBasket = ShoppingBasket.newShoppingBasket();		
		shoppingBasket.addItem(testItem);
		
		String expectedResult = "Items: PS4 ";
		
		assertEquals(expectedResult, shoppingBasket.toString());	
	}
	
	@DisplayName(value="Calculate Basket Total Price")
	@Test
	public void testCalculateBasketTotalPrice_Ok() {
		ShoppingBasket basket = ShoppingBasket.newShoppingBasket();
		
		basket.addItem(Item.newItem("PS1", 1d));
		basket.addItem(Item.newItem("PS2", 10d));				
		basket.addItem(Item.newItem("PS3", 299.99d));
		basket.addItem(Item.newItem("PS4", 399.2d));
		basket.addItem(Item.newItem("PS5", 999.5d));
		
		double totalPrice = basket.totalPrice();
		double expectedResult = 1709.69d;
		assertEquals(expectedResult, totalPrice);		
	}	

	@DisplayName(value="Calculate Basket Total Price - Empty Basket")
	@Test
	public void testCalculateBasketTotalPrice_EmptyBasket() {
		ShoppingBasket basket = ShoppingBasket.newShoppingBasket();		
		double totalPrice = basket.totalPrice();
		
		double expectedResult = 0.00d;
		assertEquals(expectedResult, totalPrice);		
	}	
	
	@DisplayName(value="Calculate Basket Total Discount")
	@Test
	public void testCalculateTotalDiscount_Ok() {
		ShoppingBasket basket = ShoppingBasket.newShoppingBasket();
		
		basket.addItem(Item.newItem("PS1", 1d));
		basket.addItem(Item.newItem("PS2", 10d));				
		basket.addItem(Item.newItemWithDiscount("PS3", 299.99d, 50d));
		basket.addItem(Item.newItemWithDiscount("PS4", 399.2d, 35.35d));
		basket.addItem(Item.newItem("PS5", 999.5d));
		
		double totalDiscount = basket.totalDiscount();
		double expectedResult = 85.35d;
		assertEquals(expectedResult, totalDiscount);		
	}	
	
	@DisplayName(value="Calculate Basket Total Discount - No Discount")
	@Test
	public void testCalculateTotalDiscount_NoDiscount() {
		ShoppingBasket basket = ShoppingBasket.newShoppingBasket();
		
		basket.addItem(Item.newItem("PS1", 1d));
		basket.addItem(Item.newItem("PS2", 10d));				
		
		double totalPrice = basket.totalDiscount();
		double expectedResult = 0.00d;
		assertEquals(expectedResult, totalPrice);		
	}	
	
	@DisplayName(value="Calculate Basket Total Apply Discount")
	@Test
	public void testCalculateTotalApplyDiscount() {
		ShoppingBasket basket = ShoppingBasket.newShoppingBasket();
		
		basket.addItem(Item.newItem("PS1", 1));
		basket.addItem(Item.newItem("PS2", 10));				
		basket.addItem(Item.newItemWithDiscount("PS3", 299.99, 50.00));
		basket.addItem(Item.newItemWithDiscount("PS4", 399.2, 35.00));
		basket.addItem(Item.newItem("PS5", 999.5));		
		
		double total = basket.total();
		double expectedResult = 1624.69;
		assertEquals(expectedResult, total);
	}

	@DisplayName(value="Calculate Basket Total Apply Discount - No discount")
	@Test
	public void testCalculateTotalApplyDiscount_NoDiscount() {
		ShoppingBasket basket = ShoppingBasket.newShoppingBasket();
		
		basket.addItem(Item.newItem("PS1", 1d));
		basket.addItem(Item.newItem("PS2", 10d));				
		basket.addItem(Item.newItem("PS3", 299.99d));
		basket.addItem(Item.newItem("PS4", 399.2d));
		basket.addItem(Item.newItem("PS5", 999.5d));			
		
		double total = basket.total();
		double expectedResult = 1709.69d;
		assertEquals(expectedResult, total);		
	}

	@DisplayName(value="Calculate Basket Total Apply Discount - Empty Basket")
	@Test
	public void testCalculateTotalApplyDiscount_EmptyBasket() {
		ShoppingBasket basket = ShoppingBasket.newShoppingBasket();
		
		double total = basket.total();
		double expectedResult = 0.00d;
		assertEquals(expectedResult, total);		
	}	
	
}
