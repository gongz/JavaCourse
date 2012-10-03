public class Node{
	private int value;
	Node left;
	Node right;
	Node (){}
	Node (int inValue) {
		this.value = inValue;
		this.left = null;
		this.right = null;
	}
	public int getValue(){return this.value;}
}	