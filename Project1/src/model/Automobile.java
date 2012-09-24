package model;

import java.io.Serializable;
import java.util.LinkedList;

public class Automobile implements Serializable {
	
	private static final long serialVersionUID = -2379187095790289816L;
	
	private LinkedList<OptionSet> optionSetList;
	//Create
	public Automobile(){
		this.optionSetList = new LinkedList<OptionSet>();
	}
	//Read
	public LinkedList<OptionSet> getOptionSetList(){
		return this.optionSetList;
	}
	
	//Update
	public void setOptionSetList(LinkedList<OptionSet> osl){
		this.optionSetList = osl;
	}
	
	//Delete
	public void deleteOptionSetList(){
		this.optionSetList = null;
		this.optionSetList = new LinkedList<OptionSet>();
	}
}
