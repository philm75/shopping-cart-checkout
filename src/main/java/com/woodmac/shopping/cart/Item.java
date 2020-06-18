package com.woodmac.shopping.cart;

public class Item {

	private static final double DEFAULT_DISCOUNT = 0d;
	
	private final String name;
		
	private final double price;

	private final double discount;
	
	private Item(String name, double price, double discount) {	
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("Name is required");			
		}
		
		if (price < 0) {
			throw new IllegalArgumentException("Price cannot be negative");	
		}

		if (discount < 0) {
			throw new IllegalArgumentException("Discount cannot be negative");	
		}
		
		this.name = name;
		this.price = price;
		this.discount = discount;
	}
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public double getDiscount() {
		return discount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Item other = (Item) obj;
		if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
	
	public static Item newItemWithDiscount(String name, double price, double discount) {
		return new Item(name, price, discount);
	}

	public static Item newItem(String name, double price) {
		return new Item(name, price, DEFAULT_DISCOUNT);
	}
}