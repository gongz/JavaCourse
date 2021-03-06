import java.util.ArrayList;
import java.util.LinkedList;

public class Tree{
		public Tree(){}
		public Tree(Node inHead){this.head = inHead;}
			
		private Node head;
		public Node insert(int inValue, Node curHead){
			if(curHead==null){
				return new Node(inValue);
			}
			if(inValue < curHead.getValue())
				curHead.left = insert(inValue,curHead.left);
			if(inValue > curHead.getValue())
				curHead.right = insert(inValue,curHead.right);
			return curHead;
			
		}
		public Node getHead(){return this.head;}
		public void inOrder(Node curHead){
			if(curHead == null)
				return;
			else{
				inOrder(curHead.left);
				System.out.println(curHead.getValue());
				inOrder(curHead.right);
			}
			
		}
		public void printLongestPath(Node head){
			ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
			LinkedList<Node> list = new LinkedList<Node>();
			if(head == null) return;
			list.add(head);
			lists.add(list);
			int cur = 1;
			while(true){
				Node tmp = list.getLast();
				if(tmp!=null){
					if(tmp.left!=null){
						LinkedList<Node> nextList = (LinkedList<Node>) list.clone();
						nextList.add(tmp.left);
						lists.add(nextList);
					}
					if(tmp.right!=null){
						LinkedList<Node> nextList = (LinkedList<Node>) list.clone();
						nextList.add(tmp.right);
						lists.add(nextList);
					}					
				}
				if(cur<lists.size()){
					list = lists.get(cur);
					cur++;
				}
				else break;
			}
			int printIndex = lists.size()-1;
			int maxLen = lists.get(printIndex).size();
			while(printIndex>0){
				if(lists.get(printIndex).size()>=maxLen){					
					for(Node tmpNode:lists.get(printIndex)){
						System.out.print(tmpNode.getValue());
					}
					System.out.println();
					printIndex--;
				}
				else break;
			}			
		}
	}