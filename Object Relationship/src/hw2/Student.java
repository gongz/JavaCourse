package hw2;

public class Student{
	
	private int SID;
	private int scores[] = new int[5];
	
	public int getSID() {
		return SID;
	}

	public int[] getScores() {
		return scores;
	}
	

	public Student(){}
	public Student(int id, int [] scores){
		this.SID = id;
		this.scores = scores;
	}
	//write public get and set methods for
	//SID and scores
}
