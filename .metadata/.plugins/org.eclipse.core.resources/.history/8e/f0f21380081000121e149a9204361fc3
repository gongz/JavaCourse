package system;

import java.util.Iterator;
import java.util.LinkedHashMap;

import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

import exceptionHandler.duplicateModelName;

import model.Automobile;
import model.Find;

public class kbbSystem implements Find{
	private static LinkedHashMap<String,Automobile> autoLinkedHashMap;
	private static int insertionCount = 0;
	public kbbSystem(){
		autoLinkedHashMap = getAutos();
	}
	public LinkedHashMap<String, Automobile> getAutos(){
		if(autoLinkedHashMap!=null)
			return autoLinkedHashMap;
		else{
			autoLinkedHashMap = new LinkedHashMap<String, Automobile>();
			return autoLinkedHashMap;
		}
	}
	public void insertAuto(Automobile auto){
		try{
			insertionCount++;
			StringBuffer buffer = new StringBuffer();
			buffer.append(auto.getMake());
			buffer.append(auto.getModelName());		
			autoLinkedHashMap.put(buffer.toString(), auto);
			if(insertionCount!=autoLinkedHashMap.size())
				throw new duplicateModelName();
		}catch(duplicateModelName e){
			StringBuffer buffer = new StringBuffer();
			buffer.append("duplicated car model inserted, inserted ");
			buffer.append(insertionCount);
			buffer.append(" times, currently have ");
			buffer.append(autoLinkedHashMap.size());
			System.out.println(buffer+e.toString());
		}
	}	
		
	public String toString(){
		Iterator<Automobile> it = autoLinkedHashMap.values().iterator();
		StringBuffer buffer = new StringBuffer();
		while(it.hasNext()){
			buffer.append(it.next().toString());			
		}
		return buffer.toString();
	}
	@Override
	public Object find(Object o) {
		// TODO Auto-generated method stub		
		Iterator<Automobile> it = autoLinkedHashMap.values().iterator();
		while(it.hasNext()){
			Automobile tmp = it.next();
			if((tmp.getMake()+tmp.getModelName()).equals(o.toString()))	
				return tmp;
		}
		return null;
	}
}
