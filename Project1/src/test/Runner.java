package test;

import model.*;
import utils.*;



public class Runner {
	public static void main(String[] args) {
		String fileName = "car";
		Util ut = new Util();
		Automobile car = ut.readFile(fileName);
		ut.serialize(car,fileName);
		Automobile serCar = ut.readSerializedFile(fileName);
		ut.writeFile(serCar,fileName);
	}

}
