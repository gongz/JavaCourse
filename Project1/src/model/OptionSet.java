package model;
import java.io.Serializable;
import java.util.ArrayList;

public class OptionSet implements Serializable{
	
	private static final long serialVersionUID = -3864201267105874672L;
	private String name;
	private ArrayList<Option> options;
	
	//Create
	public OptionSet(){
		this.name = null;
		this.options = new ArrayList<Option>();
	}
	
	public OptionSet(String name){
		this.name = name;
		this.options = new ArrayList<Option>();
	}
	
	public OptionSet(String name, int count){
		this.name = name;
		this.options = new ArrayList<Option>(count);
	}
	
	//Update
	public void setName(String name) {
		this.name = name;
	}
	
	public void setOptions(ArrayList<Option> options) {
		this.options = options;
	}
	
	public void setOption(int i, String name, int price){
		Option opt = options.get(i);
		opt.setName(name);
		opt.setPrice(price);
	}
	//Read
	public Option getOption(String name){
		int index = findOption(name);
		if(index!=-1){
			return options.get(index);
		}
		return null;
	}
	
	public ArrayList<Option> getOptions() {
		return options;
	}
	
	public String getName() {
		return name;
	}
	
	public int getOptionPrice(String name){
		int index = findOption(name);
		if(index!=-1){
			return options.get(index).getPrice();
		}
		return -1;
	}
	
	private int findOption(String name){
		for(int i = 0;i<options.size();i++){
			if(options.get(i).getName().equals(name)){
				return i;
			}
		}
		return -1;
		
	}
	
	//Delete
	private void deleteOption(String name){
		int index = findOption(name);
		options.remove(index);
	}
}