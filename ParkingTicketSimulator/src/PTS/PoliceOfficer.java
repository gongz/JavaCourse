package PTS;

public class PoliceOfficer {
	private String name;
	private String badgeNumber;
	
	public String getName() {
		return name;
	}
	
	public String getBadgeNumber() {
		return badgeNumber;
	}

	public PoliceOfficer(){}
	
	public PoliceOfficer(String name, String badgeNumber) {
		super();
		this.name = name;
		this.badgeNumber = badgeNumber;
	}

	public ParkingTicket issueTicket(ParkedCar car, ParkingMeter meter){
		System.out.println("system log:\nA ticket is issued");
		return new ParkingTicket(car,this,meter);		
	}
	
	public boolean isExpired(ParkedCar car, ParkingMeter meter){
		System.out.println("system log:\nPolice Badage Number: "+this.getBadgeNumber()+ "\nname: "+this.getName()+" is checking car License Number: "+car.getLicenseNumber());
		if ((car.getParkedMinutes() - meter.getMinutesPurchased()) > 0){
			System.out.println("system log:\nThe car being checked is expired");
			return true;
		}
		System.out.println("system log:\nThe car being checked is still valid");
		return false;
	}
	
}
