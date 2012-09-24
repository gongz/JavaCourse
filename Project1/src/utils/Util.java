package utils;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import model.*;

public class Util {
	
	public Util(){}
	public void serialize(Automobile car, String fileName){
		try
		  {
		     FileOutputStream fileOut = new FileOutputStream("src/"+fileName+".ser");
		     ObjectOutputStream out = new ObjectOutputStream(fileOut);
		     out.writeObject(car);
		     out.close();
		     fileOut.close();
		  }catch(IOException i)
		  {
		      i.printStackTrace();
		  }
	}
	public Automobile readSerializedFile(String fileName){
		Automobile car = null;
        try
        {
           FileInputStream fileIn = new FileInputStream("src/"+fileName+".ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           car = (Automobile) in.readObject();
           in.close();
           fileIn.close();
       }catch(IOException i)
       {
           i.printStackTrace();
           return null;
       }catch(ClassNotFoundException c)
       {
           c.printStackTrace();
           return null;
       }
       return car;
	}
	public void writeFile(Automobile serCar, String fileName){
		Writer writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("src/"+fileName+".out"));
			for(OptionSet set : serCar.getOptionSetList()){
				writer.write("Type: "+set.getName()+"\n");
				for(Option op : set.getOptions()){
					writer.write("Name: "+op.getName()+"\nPrice: "+op.getPrice()+"\n");
				}
				writer.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public Automobile readFile(String filename)
	{
		Automobile carCreating = new Automobile();
		 try {
	            FileReader file = new FileReader("src/"+filename+".in");
	            BufferedReader buff = new BufferedReader(file);
	            boolean eof = false;
	            String begType = null;
	            String endType = null;
	            Pattern anchorBegPattern = Pattern.compile("(<([^/])(.+)>)");
            	Pattern anchorEndPattern = Pattern.compile("(<(\\/)(.+)>)");
	            OptionSet setCreating = null;
            	while (!eof) {
	                String line = buff.readLine();
	                if (line == null)
	                   eof = true;
	                else
                    {
	                	line = line.trim();
	                	Matcher m = anchorBegPattern.matcher(line);
	                	if(m.matches()){
	                		begType = line.replaceAll("(<|>|/)", "");
	                		LinkedList<OptionSet> optionSetList = carCreating.getOptionSetList();
	                		boolean flag = false;	                		
	                		for(OptionSet set: optionSetList){
	                			if(set.getName().equals(begType)){
	                				flag = true;
	                				setCreating = set;
	                			}
	                		}
	                		//the anchor doesn't exist before
	                		if(!flag){
	                			//create a OptionSet with name begType
	                			setCreating = new OptionSet(begType);
	                			optionSetList.add(setCreating);
	                		}
	                		//System.out.println(begType);
	                		continue;
	                	}
	                	m = anchorEndPattern.matcher(line);
	                	if(m.matches()){	                		 
	                		endType = line.replaceAll("(<|>|/)", "");
	                		if(begType!=null && endType.equals(begType)){
	                			
	                			//System.out.println(endType);
	                			//System.out.println("save value to model");
	                			setCreating = null;
	                			continue;
	                		}
	                	}
	                	// if not anchor, we process the options
	                	String[] splitRes = line.split("(\\s*)(,)(\\s*)");
	                	String name = splitRes[0];
	                	try{
	                		//here we need to ensure the price is presented
	                		int price;
	                		if(splitRes.length>1){
		                		price = Integer.parseInt(splitRes[1]);
	                		}
	                		else{
	                			//Otherwise, assign it as 0
	                			price = 0;
	                		}
	                		//if the option name exist, we can finally create the value
	                		if(name.length()>0){
	                			//System.out.println(name+" "+price);
	                			boolean foundFlag = false;
	                			for(Option op : setCreating.getOptions()){
	                				if(name.equals(op.getName())){
	                					foundFlag = true;
	                					op.setPrice(price);
	                				}
	                			}
	                			
	                			if(!foundFlag) setCreating.getOptions().add(new Option(name,price));
	                		}
	                	}catch(NumberFormatException e){
	                		System.out.println(name);
	                	}
                    }
	            }
	            buff.close();
	            
	        } catch (Exception e) {
	            System.out.println("Error -- " + e.toString());
	        } 
		 return carCreating;
	 }
}