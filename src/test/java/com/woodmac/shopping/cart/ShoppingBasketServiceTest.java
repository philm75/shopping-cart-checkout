package com.woodmac.shopping.cart;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(value="Shopping Basket Service")
public class ShoppingBasketServiceTest {

	@DisplayName(value="Create Shopping Basket")
	@Test
	public void testCreate() {
		ShoppingBasketService sbs = new ShoppingBasketService();
		ShoppingBasket shoppingBasket = sbs.createBasket();
		
		assertNotNull(shoppingBasket);
		assertTrue(shoppingBasket.getItems().isEmpty());
	}
	
	@DisplayName(value="Add item to null shopping basket")
	@Test
	public void testAddItemToBasket_Null_Basket() {
		ShoppingBasketService sbs = new ShoppingBasketService();
		sbs.addItemToBasket(null, Item.newItem("PS4", 10d));
	}

	@DisplayName(value="Add item to shopping basket")
	@Test
	public void testAddItemToBasket_Ok() {
		ShoppingBasketService sbs = new ShoppingBasketService();
		ShoppingBasket shoppingBasket = sbs.createBasket();
		sbs.addItemToBasket(shoppingBasket, Item.newItem("PS4", 10d));

		assertTrue(shoppingBasket.getItems().size() == 1);		
	}

	@DisplayName(value="Add null item to shopping basket")
	@Test
	public void testAddItemToBasket_Null_Item() {
		ShoppingBasketService sbs = new ShoppingBasketService();
		ShoppingBasket shoppingBasket = sbs.createBasket();
		sbs.addItemToBasket(shoppingBasket, null);

		assertTrue(shoppingBasket.getItems().isEmpty());		
	}

	@DisplayName(value="Remove item from null shopping basket")
	@Test
	public void testRemoveItemFromBasket_Null_Basket() {
		ShoppingBasketService sbs = new ShoppingBasketService();
		sbs.removeItemFromBasket(null, Item.newItem("PS4", 10d));
	}

	@DisplayName(value="Remove item from shopping basket")
	@Test
	public void testRemoveItemFromBasket_Ok() {
		ShoppingBasketService sbs = new ShoppingBasketService();
		ShoppingBasket basket = sbs.createBasket();
		Item item = Item.newItem("PS4", 10d);
		
		sbs.addItemToBasket(basket, item);
		sbs.removeItemFromBasket(basket, item);

		assertTrue(basket.getItems().isEmpty());		
	}
}