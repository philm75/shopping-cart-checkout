package com.woodmac.shopping.cart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {

	private List<Item> items;
	
	private ShoppingBasket() {
		this.items = new ArrayList<>();
	}

	public boolean addItem(Item item) {
		if (!this.items.contains(item) && item != null) {
			return this.items.add(item);
		} else {
			return false;
		}
	}
	
	public boolean removeItem(Item item) {
		return this.items.remove(item);
	}
	
	public List<Item> getItems() {
		return this.items;
	}
	
	public double totalPrice() {
		return this.items.stream().mapToDouble(Item::getPrice).sum();
	}

	public double totalDiscount() {
		return this.items.stream().mapToDouble(Item::getDiscount).sum();
	}
	
	public double total() {
		return totalPrice() - totalDiscount();
	}
		
	@Override
	public String toString() {		
		StringBuilder builder = new StringBuilder("Items: ");
		items.forEach(item -> builder.append(item.getName() + " "));
		return builder.toString();
	}

	public static ShoppingBasket newShoppingBasket() {
		return new ShoppingBasket();
	}	
}