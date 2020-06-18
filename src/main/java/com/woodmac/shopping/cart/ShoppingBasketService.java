package com.woodmac.shopping.cart;

public class ShoppingBasketService {

	public ShoppingBasket createBasket() {
		return ShoppingBasket.newShoppingBasket();
	}

	public void printItems(ShoppingBasket basket) {
		System.out.println(basket.toString());
	}
	
	public void printTotals(ShoppingBasket basket) {
		System.out.println(String.format("Price: £%.2f", basket.totalPrice()));
		System.out.println(String.format("Discount: £%.2f", basket.totalDiscount()));
		System.out.println(String.format("Total: £%.2f", basket.total()));	
	}
	
	public void addItemToBasket(ShoppingBasket basket, Item item) {
		if (basket != null && item != null) {
			basket.addItem(item);			
		}
	}
	
	public void removeItemFromBasket(ShoppingBasket basket, Item item) {
		if (basket != null) {
			basket.removeItem(item);			
		}
	}		
}