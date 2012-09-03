
public class ParkingTicket {
	private ParkedCar illegalCar;
	private PoliceOfficer reportPolice;
	private ParkingMeter problemMeter;
	
	private final static int FIRST_HOUR_FINE = 25;
	private final static int ADDITIONAL_FINE = 10;
	
	public ParkingTicket(){}
	
	public ParkingTicket(ParkedCar illegalCar, PoliceOfficer reportPolice,
			ParkingMeter problemMeter) {
		super();
		this.illegalCar = illegalCar;
		this.reportPolice = reportPolice;
		this.problemMeter = problemMeter;
	}
	
	public ParkedCar getIllegalCar()
	{
		return this.illegalCar;
	}
	
	public int getFine()
	{
		double timeExpired = this.illegalCar.getParkedMinutes() - this.problemMeter.getMinutesPurchased();
		System.out.println("A fine for "+timeExpired+" minutes overparking will be generated");
		if (timeExpired < 60){
			return FIRST_HOUR_FINE;
		}
		else{
			double additionalHourExpired = (timeExpired - 60)/60;			
			return (int) (FIRST_HOUR_FINE + ADDITIONAL_FINE * Math.ceil(additionalHourExpired));
		}		
	}
	
	public PoliceOfficer getPoliceOfficer()
	{
		return this.reportPolice;
	}	
}
