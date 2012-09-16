package hw2;

public class Statistics {
	private int [] lowscores = new int [5];
	private int [] highscores = new int [5];
	private float [] avgscores = new float [5];
	static final int totalNumOfStudent = 40;
	
	public Statistics(){
		for(int i = 0; i<5 ; i++){
			lowscores[i] = Integer.MAX_VALUE;
			highscores[i] = Integer.MIN_VALUE;
			avgscores[i] = 0;
		}
	}
	static boolean isScoreValid(int score){
		if(score > 100 || score < 0)
			return false;
		return true;
	}
	void findLow(Student [] a){
		//This method will find lowest score and store it in an array names lowscores
		int studentCnt = 0;		
		while(studentCnt < Statistics.totalNumOfStudent && a[studentCnt]!=null){
			if(a[studentCnt].getScores()[0] < this.lowscores[0])
				if(isScoreValid(a[studentCnt].getScores()[0]))
					this.lowscores[0] = a[studentCnt].getScores()[0];
			if(a[studentCnt].getScores()[1] < this.lowscores[1])
				if(isScoreValid(a[studentCnt].getScores()[1]))
					this.lowscores[1] = a[studentCnt].getScores()[1];
			if(a[studentCnt].getScores()[2] < this.lowscores[2])
				if(isScoreValid(a[studentCnt].getScores()[2]))
					this.lowscores[2] = a[studentCnt].getScores()[2];
			if(a[studentCnt].getScores()[3] < this.lowscores[3])
				if(isScoreValid(a[studentCnt].getScores()[3]))
					this.lowscores[3] = a[studentCnt].getScores()[3];
			if(a[studentCnt].getScores()[4] < this.lowscores[4])
				if(isScoreValid(a[studentCnt].getScores()[4]))	
					this.lowscores[4] = a[studentCnt].getScores()[4];
			studentCnt++;
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append("Low Score ");
		buffer.append(lowscores[0]+" ");
		buffer.append(lowscores[1]+" ");
		buffer.append(lowscores[2]+" ");
		buffer.append(lowscores[3]+" ");
		buffer.append(lowscores[4]+" ");
		System.out.println(buffer);
		
	}
		 
	void findHigh(Student [] a){
		//This method will find highest score and store it in an array names highscores
		int studentCnt = 0;		
		while(studentCnt < Statistics.totalNumOfStudent && a[studentCnt]!=null){
			if(a[studentCnt].getScores()[0] > this.highscores[0])
				if(isScoreValid(a[studentCnt].getScores()[0]))
					this.highscores[0] = a[studentCnt].getScores()[0];				
			if(a[studentCnt].getScores()[1] > this.highscores[1])
				if(isScoreValid(a[studentCnt].getScores()[1]))
					this.highscores[1] = a[studentCnt].getScores()[1];
			if(a[studentCnt].getScores()[2] > this.highscores[2])
				if(isScoreValid(a[studentCnt].getScores()[2]))	
					this.highscores[2] = a[studentCnt].getScores()[2];
			if(a[studentCnt].getScores()[3] > this.highscores[3])
				if(isScoreValid(a[studentCnt].getScores()[3]))
					this.highscores[3] = a[studentCnt].getScores()[3];
			if(a[studentCnt].getScores()[4] > this.highscores[4])
				if(isScoreValid(a[studentCnt].getScores()[4]))
					this.highscores[4] = a[studentCnt].getScores()[4];
			studentCnt++;
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append("High Score ");
		buffer.append(highscores[0]+" ");
		buffer.append(highscores[1]+" ");
		buffer.append(highscores[2]+" ");
		buffer.append(highscores[3]+" ");
		buffer.append(highscores[4]);
		System.out.println(buffer);
		
	}	

	void findAvg(Student [] a){
		//This method will find avg score for each quiz and store it in an array names avgscores
		int studentCnt = 0;	
		int [] scoreCnt = new int[5];
		while(studentCnt < Statistics.totalNumOfStudent && a[studentCnt]!=null){
			if(isScoreValid(a[studentCnt].getScores()[0])){
				this.avgscores[0] += a[studentCnt].getScores()[0];
				scoreCnt[0]++;
			}
			if(isScoreValid(a[studentCnt].getScores()[1])){
				this.avgscores[1] += a[studentCnt].getScores()[1];
				scoreCnt[1]++;
			}
			if(isScoreValid(a[studentCnt].getScores()[2])){
				this.avgscores[2] += a[studentCnt].getScores()[2];
				scoreCnt[2]++;
			}
			if(isScoreValid(a[studentCnt].getScores()[3])){
				this.avgscores[3] += a[studentCnt].getScores()[3];
				scoreCnt[3]++;
			}
			if(isScoreValid(a[studentCnt].getScores()[4])){
				this.avgscores[4] += a[studentCnt].getScores()[4];
				scoreCnt[4]++;
			}
			studentCnt++;
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append("Average ");
		buffer.append(avgscores[0]/scoreCnt[0]+" ");
		buffer.append(avgscores[1]/scoreCnt[1]+" ");
		buffer.append(avgscores[2]/scoreCnt[2]+" ");
		buffer.append(avgscores[3]/scoreCnt[3]+" ");
		buffer.append(avgscores[4]/scoreCnt[4]+" ");
		System.out.println(buffer);
		
	}
	
}
