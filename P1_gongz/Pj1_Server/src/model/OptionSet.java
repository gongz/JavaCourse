package model;
import java.io.Serializable;
import java.util.ArrayList;

public class OptionSet implements Serializable,Find{
	
	private static final long serialVersionUID = -3864201267105874672L;
	private String name;
	private ArrayList<Option> options;
	
	//Create
	public OptionSet() {
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
	//if the option is already exist, replace it with new values	
	public void insertOption(Option opt){
		int index = findOption(opt.getName());
		if(index!=-1){
			setOption(index,opt.getName(),opt.getPrice());
		}else{
			options.add(opt);
		}
	}
	
	
	
	//Update
	public void setName(String name) {
		this.name = name;
	}
	
	public void insertOptionSet(OptionSet ops){
		this.setName(ops.getName());
		for(Option op : ops.getOptions()){
			this.insertOption(op);
		}
	}
	
	public void setOptions(ArrayList<Option> options) {
		this.options = options;
	}
	
	public void setOption(int i, String name, int price){
		Option opt = options.get(i);
		if(opt!=null){
			opt.replaceOption(new Option(name,price));
		}
	}
	
	public void setOption(String name, int price){
		int index = findOption(name);
		setOption(index,name,price);		
	}
	
	public void setOption(String oldName, String newName){
		Option opt = getOption(oldName);
		if(opt!=null){
			opt.setName(newName);
		}
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
	
	public int findOption(String name){
		for(int i = 0;i<options.size();i++){
			if(options.get(i).getName().equals(name)){
				return i;
			}
		}
		return -1;
		
	}	
	
	
	//Delete
	public void deleteOption(String name){
		int index = findOption(name);
		if(index!=-1){
			options.remove(index);
		}
	}
	//toString
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.getName());
		buffer.append("\n");
		for(Option opt:this.getOptions()){
			buffer.append(opt.toString());
		}
		return buffer.toString();
	}

	@Override
	public Object find(Object name) {
		String findName = name.toString();
		return getOption(findName);
	}
}
