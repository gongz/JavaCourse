package utils;

import java.io.*;
import java.util.regex.*;

import exceptionHandler.illegalFormat;
import exceptionHandler.illegalName;
import exceptionHandler.illgalInputFormat;
import exceptionHandler.illgalPrice;
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
	public ObjectInputStream getoutSocketSerializedFile(String fileName,Automobile car){
		try
        {
			
			FileInputStream fileOut = new FileInputStream("src/"+fileName+".ser");
			ObjectInputStream out = new ObjectInputStream(fileOut);
			fileOut.close();
			return out;
       }catch(IOException i)
       {
           i.printStackTrace();
           
       }catch(Exception e){
    	   System.out.println("Error Serialize -- "+e.toString());
       }
		return null;
	}
	
	public Automobile readSerializedFile(String fileName){
		Automobile car = null;
        try
        {
           FileInputStream fileIn = new FileInputStream("src/"+fileName+".ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           car = (Automobile) in.readObject();
           //get model and base price
           
           Option op = car.getOptions("NAME").get(0);
           
           car.setModelName(op.getName());
           car.setBasePrice(op.getPrice());
           car.deleteOptionSet("NAME");
           //get make
           op = car.getOptions("MAKE").get(0);
           
           car.setMake(op.getName());
           car.deleteOptionSet("MAKE");
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
        catch(Exception e){
    	   System.out.println("Error Serialize -- "+e.toString());
           return null;
       }
       return car;
	}
	
	public void writeFile(Automobile serCar, String fileName){
		Writer writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("src/"+fileName+".out"));
			writer.write(serCar.toString());			
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("Error writeFile -- "+e.toString());
		}
		finally{
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@SuppressWarnings({ "null", "finally" })
	public Automobile readFile(String filename)
	{
		Automobile carCreating = new Automobile();
		 try {
	            FileReader file = new FileReader("src/"+filename+".in");
	            BufferedReader buff = new BufferedReader(file);
	            boolean eof = false;
	            String begType = null;
	            String endType = null;
	            
	            //regex pattern <type>
	            Pattern anchorBegPattern = Pattern.compile("(<([^/])(.+)>)");
            	//regex pattern </type>
	            Pattern anchorEndPattern = Pattern.compile("(<(\\/)(.+)>)");
	            
	            OptionSet setCreating = null;
            	while (!eof) {
	                String line = buff.readLine();
	                if (line == null){
	                   eof = true;	                   
	                }
	                else
                    {
	                	//get rid of space at beginning and ending
	                	line = line.trim();
	                	Matcher m = anchorBegPattern.matcher(line);
	                	if(m.matches()){
	                		//regex replace <, > and / with nothing
	                		begType = line.replaceAll("(<|>|/)", "");
	                		try{
	                			if(begType.length()<1) 
	                				throw new illegalFormat();
		                		setCreating = (OptionSet) carCreating.find(begType);
		                		if(setCreating==null){
		                			setCreating = new OptionSet(begType);
		                			carCreating.insertOptionSet(setCreating);
		                		}
		                	}catch(illegalFormat e){
	                			System.out.println("Invalid anchor --"+e.toString());
	                		}finally{
	                			continue;
	                		}
	                	}
	                	m = anchorEndPattern.matcher(line);
	                	if(m.matches()){	                		 
	                		endType = line.replaceAll("(<|>|/)", "");
	                		if(begType!=null){
	                			if(endType.equals(begType)){
	                				setCreating = null;
	                				continue;
	                			}else{
	                				throw new illgalInputFormat();
	                			}
	                		}else{
	                			throw new illgalInputFormat();
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
	                			throw new illgalPrice();
	                			
	                		}
	                		//if the option name exist, we can finally create the value
	                		if(name.length()>0){
	                			setCreating.insertOption(new Option(name,price));
	                		}
	                	}catch(NumberFormatException e){
	                		System.out.println(name);
	                	}catch(illgalPrice e){
	                		System.out.println("Invalid Price, set to 0 instead --"+e.toString());
	                		try{
	                			if(name.length()>0){
	                				setCreating.insertOption(new Option(name,0));
	                			}else{ 
	                				throw new illegalName();
	                			}
	                		}catch(illegalName e1){
	                			System.out.println("Invalid Name --"+e1.toString());
	                		}
	                	}
                    }
	            }
	            buff.close();	            
	        }catch(illgalInputFormat e){
	        	System.out.println("Invalid Input Format, Not match anchor --"+e.toString());
	        }
		 	catch (Exception e) {
	            System.out.println("Error -- " + e.toString());
	        } 
		 return carCreating;
	 }
}
