import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Node {
	
	private Board data;
	private Node child;
	
	
	public Node(Board data) {
		this.data = data;
	}
	
	public Board getData() {
		return data;
	}
	
	public void setChild(Node child) {
		this.child = child;
	}

}

class Tree{
	private Node root;
	private HashMap<Node, List<Board>> treeMap = new HashMap();
	private int MinValue = 2;
	private int MaxValue = -2;
	private int Value = 8;


	
	public Tree() {
		this.root = null;
	}
	
	public void setRoot(Node r) {
		this.root = r;
	}
	
	public HashMap<Node, List<Board>> getTreeMap(){
		return treeMap;
	}
	
	public void addToTree(Node n) {
		treeMap.putIfAbsent(n,  new ArrayList<>());
	}
	
	public void addChild(Node a,Board b) {
		treeMap.get(a).add(b);
	}
	
	public Node getNode(Board b){
		for (Entry<Node, List<Board>> e : treeMap.entrySet()) {
			if(e.getKey().getData().Equal(b)){
				return e.getKey();
			}
		}
		return null;
	}
	
	public List<Board> getList(Board b){
		for (Entry<Node, List<Board>> e : treeMap.entrySet()) {
			if(e.getKey().getData().Equal(b)){
				return e.getValue();
			}
		}
		return null;
	}
	
	public Board getLowestV(Board b) {
		int index = 0;
		int counter = -1;
		for(Board a:this.getList(b)) {
			counter++;
			if(a.getValue() < Value) {
				Value = a.getValue();
				index = counter;
			}
		}
		return this.getList(b).get(index);
	}
	
	public int getLowV(Board b) {
		for(Board a:this.getList(b)) {
			if(a.getValue() < MinValue) {
				MinValue = a.getValue();
			}
		}
		return MinValue;
	}
	
	public int getHighV(Board b) {
		for(Board a:this.getList(b)) {
			if(a.getValue() > MaxValue) {
				MaxValue = a.getValue();
			}
		}
		return MaxValue;
	}
	
}
