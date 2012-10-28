
public class A {
	static void f(A a, A d){
		System.out.println("A,D");
	}
	static void f(C b, A a){
		System.out.println("B,A");
	}
	
	
	
	
	public static void main(String[] args){
		
		f(new C(),new E());
		
	}
}
