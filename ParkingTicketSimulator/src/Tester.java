
public class Tester {
	//source code
	//2-3 good test cases txt file
	//pdf format graph design
	//instruction for running
	//to cislabs04@gmail.com
	/**
	 * @param args
	 */
	public static void testRunner(ParkedCar car, ParkingMeter meter,PoliceOfficer officer){
		if(officer.isExpired(car, meter)){
			ParkingTicket ticket = officer.issueTicket(car, meter);
			System.out.println("Following amount fine is issued: $"+ ticket.getFine());
			System.out.println("to "+ ticket.getIllegalCar().getColor()+" "+ticket.getIllegalCar().getMake()+
					" "+ticket.getIllegalCar().getModel()+" "+ticket.getIllegalCar().getLicenseNumber());
			System.out.println("by name:"+ ticket.getPoliceOfficer().getName()+" number: "+ticket.getPoliceOfficer().getBadgeNumber());
		}
		else{
			System.out.println("Time of the car parked in minutes is "+car.getParkedMinutes()+"\nminutes purchased is: "+meter.getMinutesPurchased());
		}
		System.out.println("**********************************************");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParkedCar car1 = new ParkedCar("Honda","Civic","Red","A1A2A3");
		ParkedCar car2 = new ParkedCar("Toyota","Corolla","Black","B1B2B3");
		
		ParkingMeter meter1 = new ParkingMeter(-60);		
		ParkingMeter meter2 = new ParkingMeter(-59);
		ParkingMeter meter3 = new ParkingMeter(0);
		ParkingMeter meter4 = new ParkingMeter(1);
		ParkingMeter meter5 = new ParkingMeter(-120);
		ParkingMeter meter6 = new ParkingMeter(-119);
		
		PoliceOfficer officer1 = new PoliceOfficer("Tom","189742178912");
		PoliceOfficer officer2 = new PoliceOfficer("Jerry","14750174380517");
		
		testRunner(car1,meter1,officer1);
		testRunner(car2,meter2,officer2);
		testRunner(car1,meter3,officer2);
		testRunner(car2,meter4,officer1);
		testRunner(car1,meter5,officer1);
		testRunner(car2,meter6,officer2);		
		}
	}