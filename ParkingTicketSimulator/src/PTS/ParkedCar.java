package PTS;

public class ParkedCar {
	private String make;
	private String model;
	private String color;
	private String licenseNumber;		
	private double parkedMinutes;
	
		
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
		return this.parkedMinutes;
	}
	
	//FOR TESTING ONLY
	public void setParkedDuration(double duration){
		if (duration>=0)
			this.parkedMinutes = duration;
		else this.parkedMinutes = Double.MAX_VALUE;
	}

	public ParkedCar(){}
	public ParkedCar(String make, String model, String color,
			String licenseNumber) {
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.licenseNumber = licenseNumber;
	}
}
