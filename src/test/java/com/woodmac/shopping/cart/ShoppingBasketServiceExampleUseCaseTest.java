package com.woodmac.shopping.cart;

import org.junit.jupiter.api.Test;

/**
 * Test harness containing the example use case in the README.md.
 *
 */
public class ShoppingBasketServiceExampleUseCaseTest {

	
	@Test
	public void runTest() {		
		Item firstItem = Item.newItemWithDiscount("First item name", 10.0, 5);
		Item secondItem = Item.newItemWithDiscount("Second item name", 10.0, 5);
		Item thirdItem = Item.newItemWithDiscount("PS 4", 20.0, 4);
		
		ShoppingBasketService shoppingBasketService = new ShoppingBasketService();
		ShoppingBasket shoppingBasket = shoppingBasketService.createBasket();
		
		shoppingBasketService.addItemToBasket(shoppingBasket, firstItem);
		shoppingBasketService.addItemToBasket(shoppingBasket, secondItem);
		shoppingBasketService.addItemToBasket(shoppingBasket, thirdItem);
		shoppingBasketService.removeItemFromBasket(shoppingBasket, thirdItem);
				
		shoppingBasketService.printItems(shoppingBasket);
		shoppingBasketService.printTotals(shoppingBasket);
	}
}
