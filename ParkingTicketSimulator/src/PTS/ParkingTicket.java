package PTS;

public class ParkingTicket {	
	
	private String carColor;
	private String carModel;
	private String carMake;
	private String carLicenseNumber;
	
	private String policeName;
	private String policeBadageNumber;
	
	
	private final static int FIRST_HOUR_FINE = 25;
	private final static int ADDITIONAL_FINE = 10;
	
	public ParkingTicket(){}
	
	public ParkingTicket(ParkedCar illegalCar, PoliceOfficer reportPolice,
			ParkingMeter problemMeter) {
		super();
		this.carColor = illegalCar.getColor();
		this.carModel = illegalCar.getModel();
		this.carMake =  illegalCar.getMake();
		this.carLicenseNumber = illegalCar.getLicenseNumber();
		this.policeName = reportPolice.getName();
		this.policeBadageNumber = reportPolice.getBadgeNumber();
	}
	
	public String getIllegalCarColor()
	{
		return this.carColor;
	}
	
	public String getIllegalCarModel()
	{
		return this.carModel;
	}
	
	public String getIllegalCarMake()
	{
		return this.carMake;
	}
	
	public String getIllegalCarLicenseNumber()
	{
		return this.carLicenseNumber;
	}
	
	public String getPoliceName()
	{
		return this.policeName;
	}
	
	public String getPoliceBadageNumber()
	{
		return this.policeBadageNumber;
	}	
	
	public int getFine(ParkedCar illegalCar,ParkingMeter problemMeter)
	{
		double timeExpired = illegalCar.getParkedMinutes() - problemMeter.getMinutesPurchased();
		System.out.println("A fine for "+timeExpired+" minutes overparking will be generated");
		if (timeExpired < 60){
			return FIRST_HOUR_FINE;
		}
		else{
			double additionalHourExpired = (timeExpired - 60)/60;			
			return (int) (FIRST_HOUR_FINE + ADDITIONAL_FINE * Math.ceil(additionalHourExpired));
		}		
	}
	
}
