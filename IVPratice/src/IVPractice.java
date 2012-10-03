import java.io.*;
import java.util.*;


public class IVPractice {
	/**
	 * @param args 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Tree testTree = new Tree(new Node(5));
		
		try{
			FileReader file = new FileReader("src/in.txt");
			BufferedReader buf = new BufferedReader(file);
			boolean eof = false;
			while(!eof){
				String read = buf.readLine();
				if(read == null) eof = true;
				else{
					StringTokenizer token = new StringTokenizer(read);
					try{
						while(token.hasMoreTokens()){
							int tmpInt = Integer.parseInt(token.nextToken());
							
							testTree.insert(tmpInt, testTree.getHead());
						}
					}catch(NumberFormatException e){
						;
					}
				}
			}
		}catch(IOException e){
			System.out.print(e);
		}
		//testTree.inOrder(testTree.getHead());
		testTree.printLongestPath(testTree.getHead());
	}

}
