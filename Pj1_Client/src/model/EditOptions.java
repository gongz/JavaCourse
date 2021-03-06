package model;

import java.util.ArrayList;

public class EditOptions {
	
	private static Automobile targetAuto;
	public EditOptions(){}
	public EditOptions(Automobile auto){
		EditOptions.targetAuto = auto;
	}
	
	public Automobile getTargetAuto(){
		return EditOptions.targetAuto;
	}
	
	synchronized public void SetTargetMobile(Automobile auto){
		EditOptions.targetAuto = auto;
	}
	
	//Edit automobile: model name
	synchronized public void EditModelName(String newName){
		EditOptions.targetAuto.setModelName(newName);
	}
	
	//Edit automobile: make
	synchronized public void EditMake(String newMake){
		EditOptions.targetAuto.setMake(newMake);
	}
	
	//Edit automobile: price
	synchronized public void EditBasePrice(int newPrice){
		EditOptions.targetAuto.setBasePrice(newPrice);
	}
	
	//Test INC
	synchronized public void EditBasePriceINC(){
		EditOptions.targetAuto.setBasePriceINC();
	}
	
	//Test DEC
	synchronized public void EditBasePriceDEC(){
		EditOptions.targetAuto.setBasePriceDEC();
	}
	
	
	
	//Edit automobile: optionSetList
	synchronized public void EditOptionSetList(ArrayList<OptionSet> osl){
		EditOptions.targetAuto.setOptionSetList(osl);
	}
	
	//insert automobile: optionSet
	synchronized public void AddOptionSetToOptionSetList(OptionSet ops){
		EditOptions.targetAuto.insertOptionSet(ops);
	}
	
	//update automobile: optionSet
	synchronized public void UpdateOptionSetInOptionSetList(OptionSet ops){
		EditOptions.targetAuto.insertOptionSet(ops);
	}
	
	//delete automobile: optionSet
	synchronized public void DelOptionSetInOptionSetList(String optionSetName){
		EditOptions.targetAuto.deleteOptionSet(optionSetName);
	}
	
	//Edit OptionSet: name 
	synchronized public void EditOptionNameInOptionSet(String newName, OptionSet os){
		EditOptions.targetAuto.setOptionNameInOptionSet(os, newName);
	}
	
	//Edit OptionSet: optionsList
	synchronized public void EditOptionsInOptionSet(ArrayList<Option> ops, OptionSet os){
		EditOptions.targetAuto.setOptionsInOptionSet(os, ops);
	}
	
	//insert OptionSet: option
	synchronized public void AddOptionToOptionSet(String opsName,Option op){
		EditOptions.targetAuto.insertOption(opsName, op);
	}
	
	//update Option: option
	synchronized public void UpdateOptionInOptionSet(String opsName, Option op){
		EditOptions.targetAuto.insertOption(opsName, op);
	}
	
	//delete OptionSet: option
	synchronized public void DelOptionInOptionSet(String opsName,String opName){
		EditOptions.targetAuto.deleteOption(opsName, opName);
	}
}
