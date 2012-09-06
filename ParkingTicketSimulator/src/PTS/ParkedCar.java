package PTS;
import java.util.Date;

public class ParkedCar {
	private String make;
	private String model;
	private String color;
	private String licenseNumber;
	private double ParkInTime;
	
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getLicenseNumber() {
		return licenseNumber;
	}
	
	public double getParkedMinutes(){
		return (new Date().getTime() - this.ParkInTime)/(60*1000);
	}
	
	public ParkedCar(){}
	public ParkedCar(String make, String model, String color,
			String licenseNumber) {
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.licenseNumber = licenseNumber;
		this.ParkInTime = new Date().getTime();
	}
}
