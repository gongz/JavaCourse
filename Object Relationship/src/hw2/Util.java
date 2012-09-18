package hw2;

import java.io.*;
import java.util.StringTokenizer;

public class Util implements Validate{
	public Util(){}
	public Student [] readFile(String filename, Student [] students)
	{
		 try {
	            FileReader file = new FileReader("src/"+filename);
	            BufferedReader buff = new BufferedReader(file);	                
	            boolean eof = false;
	            int studentCnt = 0;
	            while (!eof) {
	                String line = buff.readLine();	                
	                if (line == null)
	                   eof = true;
	                else
                    {
                		StringTokenizer tokenizer = new StringTokenizer(line);
                		int id = -1;
                		int[] score = new int[5];
                		int scoreCnt = 0;
                		while(tokenizer.hasMoreTokens()){
                			String tmpString = tokenizer.nextToken();
                			scoreCnt++;
                			try{
                				if(scoreCnt == 1){
                					id = Integer.parseInt(tmpString);                					
                				}
                				else if(scoreCnt >= 2){
                					score[scoreCnt-2] = Integer.parseInt(tmpString);   
                				
                				}
                				else break;
                			} catch(NumberFormatException e) {
                				if(scoreCnt == 1) id = -1;
                				else{
                					score[scoreCnt - 2] = -1;
                				}
                				continue;
                			} catch(Exception e){
                				if(scoreCnt == 1) id = -1;
                				else{
                					score[scoreCnt - 2] = -1;
                				}
                				continue;
                			}
                		}
                		if(id != -1){
	                		Student tmpStudent = new Student(id,score);
	                		if(studentCnt < Statistics.totalNumOfStudent)
	                			students[studentCnt++] = tmpStudent;
	                		else{
	                			studentCnt++;	                			
	                		}
	                		//System.out.println(tmpStudent.getSID()+" "+ tmpStudent.getScores()[0]+tmpStudent.getScores()[1]+tmpStudent.getScores()[2]+tmpStudent.getScores()[3]+tmpStudent.getScores()[4]);
                		}                		
                	}
	            }
	            buff.close();
	            if(!isValid(studentCnt)) {
	            	System.out.println("Number of student is Not Valid!");
	            	return null;
	            }
	            
	        } catch (Exception e) {
	            System.out.println("Error -- " + e.toString());
	        } 
		 return students;
	 }
	public boolean isValid(int value) {
		if(value <= Statistics.totalNumOfStudent && value > 0) return true;
		else{
			System.out.println("Invalid number = "+ value);
			return false;
		}
	}

}
