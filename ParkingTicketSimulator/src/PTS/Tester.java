package PTS;

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
			System.out.println("Following amount fine is issued: $"+ ticket.getFine(car,meter));
			StringBuffer buf = new StringBuffer();
			buf.append("to ");
			buf.append(ticket.getIllegalCarColor());
			buf.append(" ");
			buf.append(ticket.getIllegalCarMake());
			buf.append(" ");
			buf.append(ticket.getIllegalCarModel());
			buf.append(" ");
			buf.append(ticket.getIllegalCarLicenseNumber());
			buf.append("\nby police name: ");
			buf.append(ticket.getPoliceName());
			buf.append(" number: ");
			buf.append(ticket.getPoliceBadageNumber());			
			System.out.println(buf);
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
		ParkedCar car3 = new ParkedCar("Toyota","Camry","Green","C1C2C3");
		
		car1.setParkedDuration(61.1);
		car2.setParkedDuration(60.999);
		car3.setParkedDuration(-1);
		
		ParkingMeter meter1 = new ParkingMeter(1);		
		ParkingMeter meter2 = new ParkingMeter(1);
		
		ParkingMeter meter3 = new ParkingMeter(62);
		ParkingMeter meter4 = new ParkingMeter(60);
		ParkingMeter meter5 = new ParkingMeter(10);
		ParkingMeter meter6 = new ParkingMeter(-10);
		
		PoliceOfficer officer1 = new PoliceOfficer("Tom","189742178912");
		PoliceOfficer officer2 = new PoliceOfficer("Jerry","14750174380517");
		
		testRunner(car1,meter1,officer1);
		testRunner(car2,meter2,officer2);
		testRunner(car1,meter3,officer2);
		testRunner(car2,meter4,officer1);
		testRunner(car3,meter5,officer1);
		car3.setParkedDuration(10);
		testRunner(car3,meter6,officer2);		
		}
	}