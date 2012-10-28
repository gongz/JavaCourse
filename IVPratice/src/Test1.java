import java.util.TreeSet;

public class Test1 extends Thread{
	private int tick = 1;
	private static obj signal = new obj();
	
	private int num;
	
	
	
	public Test1(int num){
		this.num = num;
	}
	public void run(){
		//while(true){
			synchronized(signal){
				while(signal.get()!=num){
				//if(signal.get()!=num){
					try {
						signal.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				while(tick<400000){
					tick++;
					if((tick%50000)==0)
						System.out.println("Thread #"+num+", tick ="+ tick);}
				signal.inc();
				signal.notifyAll();
			}
		//}
	}

}
