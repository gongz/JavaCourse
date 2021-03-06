package socket;

import java.io.ObjectInputStream;

import system.kbbSystem;
import model.Automobile;
import model.Option;

public class BuildCarModelOptions {
	//create a car on server side using ObjectInputStream
	public static Boolean processInput(ObjectInputStream Input) {
		Automobile car = null;
		try {
			car = (Automobile) Input.readObject();
			if (car != null) {
				Option op = car.getOptions("NAME").get(0);
				car.setModelName(op.getName());
				car.setBasePrice(op.getPrice());
				car.deleteOptionSet("NAME");
				// get make
				op = car.getOptions("MAKE").get(0);
				car.setMake(op.getName());
				car.deleteOptionSet("MAKE");
				//insert the car into kbbSystem
				new kbbSystem().insertAuto(car);
				return true;
			} else
				return false;
		} catch(NullPointerException e){
			System.out.println("the file doesn't exist");
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
