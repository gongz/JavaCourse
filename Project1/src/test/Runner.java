package test;

import model.*;
import utils.*;

public class Runner implements Runnable{
	private int no;
	private static EditOptions editor;
	private static boolean DEBUG = true;
	public Runner(){}
	public Runner(int no){
		this.no = no;
	}
	public static void main(String[] args) {
		String fileName = "car";
		Util ut = new Util();
		Automobile car = ut.readFile(fileName);
		ut.serialize(car,fileName);
		Automobile serCar = ut.readSerializedFile(fileName);
		editor = new EditOptions(serCar);
		Thread t1 = new Thread(new Runner(1));
		Thread t2 = new Thread(new Runner(2));
		t1.start();
		t2.start();
		try {
			t2.join();
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		if(DEBUG==true) System.out.println(this.no+"in");
		if(this.no==1) {
			synchronized(editor){
			System.out.println("1 before"+editor.getTargetAuto().getBasePrice());
			//test for synchronization
			editor.EditBasePriceINC();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("1 after"+editor.getTargetAuto().getBasePrice());
			}
		}
		if(this.no==2){
			synchronized(editor){
			System.out.println("2 before"+editor.getTargetAuto().getBasePrice());
			editor.EditBasePriceDEC();
			System.out.println("2 after"+editor.getTargetAuto().getBasePrice());
			}
		}
		if(DEBUG==true) System.out.println(this.no+"out");
	}
	
	

}
