package model;

import java.io.Serializable;
import java.util.ArrayList;


import exceptionHandler.illgalPrice;

public class Automobile extends Product 
						implements Serializable,Find  {
	
	private static final long serialVersionUID = -2379187095790289816L;
	private String modelName;
	private ArrayList<OptionSet> optionSetList;
	
	//Create
	public Automobile(){
		this.optionSetList = new ArrayList<OptionSet>();
	}
	public String getMake(){
		return this.make;
	}
	public void setMake(String make){
		this.make = make;
	}
	
	//insertOptionSet
	public void insertOptionSet(OptionSet ops){
		OptionSet target = (OptionSet) find(ops.getName());
		if(target!=null){
			target.insertOptionSet(ops);
		}else{
			optionSetList.add(ops);
		}
	}
	
	//insert Option to OptionSet	
	public void insertOption(String opsName, Option op){
		OptionSet target = (OptionSet) find(opsName);
		if(target!=null){
			target.insertOption(op);
		}else{
			OptionSet ops = new OptionSet(opsName);
			optionSetList.add(ops);
			ops.insertOption(op);
		}	
	}
	
	//Read
	public ArrayList<OptionSet> getOptionSetList(){
		return this.optionSetList;
	}
		
	//read OptionSet
	public ArrayList<Option> getOptions(String optionSetName){
		OptionSet target = (OptionSet) find(optionSetName);
		if(target!=null){
			return target.getOptions();
		}
		else return null;
	}
	
	//read Option in OptionSet
	public Option getOption(String optionSetName, String optionName){
		OptionSet target = (OptionSet) find(optionSetName);
		if(target!=null){
			return target.getOption(optionName);
		}else{
			return null;
		}
	}
	
	//get model name
	public String getModelName(){
		return this.modelName;
	}
	
	//update modelName
	public void setModelName(String modelName){
		this.modelName = modelName;
	}	
	
	//Update option set list
	public void setOptionSetList(ArrayList<OptionSet> osl){
		this.optionSetList = osl;
	}
		
	//Update an optionSet's Name set in list
	public void setOptionNameInOptionSet(OptionSet os, String newOptionSetName){
		OptionSet osTarget = (OptionSet) find(os.getName());
		if(osTarget!=null){
			osTarget.setName(newOptionSetName);
		}		
	}
	
	//update all options in option set
	public void setOptionsInOptionSet(OptionSet optionSet, ArrayList<Option> options){
		optionSet.setOptions(options);		
	}
	
	//update an option's name in option set
	public void updateOption(OptionSet optionSet, String oldOptionName, String newOptionName){
		optionSet.setOption(oldOptionName, newOptionName);		
	}	
	
	//update an option's price in option set
	public void updateOption(OptionSet optionSet, String optionName, int newPrice){
		optionSet.setOption(optionName,newPrice);		
	}
	
	//Delete
	//	public void deleteOptionSetList(){
	//		this.optionSetList = null;
	//		this.optionSetList = new ArrayList<OptionSet>();
	//	}
	
	public void deleteOptionSet(String optionSetName){
		OptionSet os = (OptionSet) find(optionSetName);
		this.getOptionSetList().remove(os);
	}
	
	public void deleteOption(String optionSetName, String optionName){
		OptionSet os = (OptionSet) find(optionSetName);
		os.deleteOption(optionName);		
	}
	
	@Override
	public Object find(Object osName){
		String findName = osName.toString();
		for(OptionSet os: this.getOptionSetList()){
			if(os.getName().equals(findName))
				return os;
		}
		return null;
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.getMake());
		buffer.append("\n");
		buffer.append(this.getModelName());
		buffer.append(" ");		
		buffer.append(this.getBasePrice());
		buffer.append("\n");
		for(OptionSet ops:this.getOptionSetList()){
			buffer.append(ops.toString());
		}
		return buffer.toString();
	}
	
	public int getTotalPrice() throws illgalPrice{
		int totalPrice = 0;
		totalPrice = this.getBasePrice();
		if(totalPrice<0) throw new illgalPrice();
		return this.getBasePrice();
	}
	
	@Override
	public int calculatePrice() {
		try {
			return this.getTotalPrice();
		} catch (illgalPrice e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("Not valid price, basePrice is returned");
			return this.getBasePrice();
		}
		
	}
	
	
}
