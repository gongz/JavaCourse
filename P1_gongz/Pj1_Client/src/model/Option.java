package model;

import java.io.Serializable;

public class Option implements Serializable{
	private static final long serialVersionUID = -7998462992948450809L;
	private String name;
	private int price;
	
	//Create
	public Option(){}
	public Option(String name, int price) {
		
		this.name = name;
		this.price = price;
	}
	
	public void replaceOption(Option opt){
		this.setName(opt.getName());
		this.setPrice(opt.getPrice());
	}
	
	//Read
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	//Update
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	//delete
	//N/A
	
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.getName());
		buffer.append(" ");
		buffer.append(this.getPrice());
		buffer.append("\n");
		return buffer.toString();
	}
	
}
