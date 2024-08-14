

public class AI {

	private int nodesWithoutPruning = 0;
	private Tree myTree = new Tree();

	
	public Board play(Board board) {
		// YOUR IMPLEMENTATION
		myTree = new Tree();
		Node root = new Node(board);
		myTree.setRoot(root);
		myTree.addToTree(root);
		Min(board);
		Board myMove = myTree.getLowestV(board);
		return myMove;
	}

	public int getNodesWithoutPruning() {
		return nodesWithoutPruning;
	}
	
	
	
	public int Min(Board b) {
		if(b.isTerminated() != 'T') {
			return b.score();
		}
		for (int i = 0 ; i<3; i++) {
			for (int j= 0 ; j<3; j++) {
				if(b.get(i,j) == '_') {
					nodesWithoutPruning++;
					Board child = new Board();
					Board son = new Board();
					Node node1 = new Node(child);
					Node node2 = new Node(son);
					child.duplicate(b);
					son.duplicate(b);
					if(son.OneToWin_O() == -100) {
						myTree.addChild(myTree.getNode(b),son);
						myTree.addToTree(node2);
						b.setValue(-100);
						Max(son);
				    }else {
						child.set(i, j, 'O');
						myTree.addChild(myTree.getNode(b),child);
						myTree.addToTree(node1);
						Max(child);
						b.setValue(myTree.getLowV(b));
				    }
				}
			}
		}
		return b.getValue();
	}

	
	
	public int Max(Board b) {
		if(b.isTerminated() != 'T') {
			return b.score();
		}
		for (int i = 0 ; i<3; i++) {
			for (int j= 0 ; j<3; j++) {
				if(b.get(i,j) == '_') {
					nodesWithoutPruning++;
					Board child = new Board();
					Board son = new Board();
					Node node1 = new Node(child);
					Node node2 = new Node(son);
					child.duplicate(b);
					son.duplicate(b);
					if(child.OneToWin_X() == 100) {
						myTree.addChild(myTree.getNode(b),son);
						myTree.addToTree(node2);
						son.setValue(100);
						Min(son);
					}else {
						child.set(i, j, 'X');
						myTree.addChild(myTree.getNode(b),child);
						myTree.addToTree(node1);
						Min(child);
						b.setValue(myTree.getHighV(b));
					}
				}
			}
		}
		return b.getValue();
	}
}
