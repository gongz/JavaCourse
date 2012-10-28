import java.util.TreeSet;

public class Myfile<T> {
	private TreeSet<T> mySet;
	public Myfile(){
		mySet = new TreeSet<T>();
	}
	public Myfile (String fileName) throws Exceptional {
		if(isNumeric(fileName)||isAlphabet(fileName))
			throw new Exceptional();
	}
	public Boolean isNumeric(String input){
		if(input == null) return false;
		for(int i = 0;i<input.length(); i++){
			if(!Character.isDigit(input.charAt(i))) return false;
		}
		return true;
	}
	
	public Boolean isAlphabet(String input){
		if(input == null) return false;
		for(int i = 0;i<input.length(); i++){
			if(!Character.isLetter(input.charAt(i))) return false;
		}
		return true;
	}
	public T get(){
		return this.mySet.first();
	}
	public void set(T input){
		this.mySet.add(input);
	}
	
//	public static void main(String[] args){
//		Myfile<Double> mf = new Myfile<Double>();
//		mf.set(1.11);
//		System.out.print(mf.get());
//		
//		
//	}
}
