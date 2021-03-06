package model;

public abstract class Product {
	//private Product(){};
	protected String make;
	protected int price;
	
	public abstract int calculatePrice();
	
	public synchronized int getBasePrice(){
		return this.price;
	}	
	
	public void setBasePriceINC(){
		this.price += 1;
	}
	
	public void setBasePriceDEC(){
		this.price -= 1;
	}
	public void setBasePrice(int price){
		this.price = price;
	}
	
	
}
