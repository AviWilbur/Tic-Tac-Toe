//This code implements a simple AI for playing Tic-Tac-Toe using a Minimax algorithm without pruning. The AI (AI class) explores possible
//game moves recursively by generating a game tree, where each node represents a game state, and evaluates each move to determine the optimal
//next move. The Board class represents the Tic-Tac-Toe board, with methods to check if the game is terminated and to calculate the score. 
//The main loop in the Main class alternates between the user and the AI, with the AI making its moves based on the Minimax evaluation, and 
//the game concludes when there is a winner or a draw.

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		AI ai = new AI();
		Board board = new Board();
		
		boolean turn = false;
		while (board.isTerminated() == 'T') {
			
			board.print();
			
			if (!turn) {
				System.out.println("choose row (0-2)");
				int row = Integer.parseInt(sc.next());
				System.out.println("choose column (0-2)");
				int col = Integer.parseInt(sc.next());
				board.set(row, col, 'X');
			} else {
				System.out.println("AI plays...");
				board = ai.play(board);
				board.print();
			}
			turn = !turn;
		}
		sc.close();

		board.print();
		switch (board.score()) {
		case 0:
			System.out.println("DRAW");
			break;
		case 1:
			System.out.println("AI WIN");
			break;
		case -1:
			System.out.println("USER WIN");
			break;
		}
		System.out.println("number of vosited nodes (without pruning): " + ai.getNodesWithoutPruning());
	}
}

