package hw2;


public class Runner {
	public static void main(String [] args)
    {
		String [] fileNames = {"file1.txt","file2.txt","file3.txt","file4.txt","file5.txt","file6.txt","file6_2.txt","file7.txt"};
		for(int i=0;i<8;i++){
			Student students [] = new Student[Statistics.totalNumOfStudent];
			students = new Util().readFile(fileNames[i], students);
			if(students!=null){
				System.out.println("Processing "+fileNames[i]);
				Statistics stat = new Statistics();
				stat.findLow(students); 
				stat.findHigh(students);
				stat.findAvg(students);
				
			}
			else{
				System.out.println("No result because of invalid input");
			}
			System.out.println();
		}
    }
}
