package PTS;

public class ParkingMeter {
	private double minutesPurchased;
	
	public ParkingMeter(){}
	
	public ParkingMeter(double minutesPurchased) {
		super();
		if(minutesPurchased>=0)
			this.minutesPurchased = minutesPurchased;
		else this.minutesPurchased = 0;
	}

	public double getMinutesPurchased() {
		return minutesPurchased;
	}
	
	
	
}
