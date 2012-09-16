package hw2;


public class Runner {
	public static void main(String [] args)
    {
		Student students [] = new Student[Statistics.totalNumOfStudent];
		students = Util.readFile("filename.txt", students); 
		Statistics stat = new Statistics();
		stat.findLow(students); 
		stat.findHigh(students);
		stat.findAvg(students);
    }
}
