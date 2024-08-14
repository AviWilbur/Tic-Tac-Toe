
public class Board {

	private final int SIZE = 3;
	private char[][] board = new char[SIZE][SIZE];
	private int value = 8;
	
	public Board() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = '_';
			}
		}
	}	

	public void print() {
		System.out.println("board:");
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void set(int row, int col, char c) {
		board[row][col] = c;
	}
	
	public char get(int row, int col) {
		return board[row][col];
	}
	
	// returns a char -
	// 'X' if the user wins
	// 'O' if the AI wins
	// 'D' in case of a draw
	// 'T' if the game is not over yet
	public char isTerminated() {
		
		for (int i = 0; i < SIZE; i++) {
			if (board[i][0] != '_' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return board[i][0];
			}
			if (board[0][i] != '_' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return board[0][i];
			}
		}
		
		if (board[0][0] != '_' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return board[0][0];
		}
		if (board[0][2] != '_' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return board[0][2];
		}
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (board[i][j] == '_') {
					return 'T';
				}
			}
		}
		
		return 'D';
	}
	
	public int score() {
		switch(isTerminated()) {
			case 'X':
				return -1;
			case 'O':
				return 1;
			case 'D':
				return 0;
			default:
				return 0/0;
		}
	}
	
	public void duplicate(Board b) {
		for (int i = 0 ; i<3; i++) {
			for (int j= 0 ; j<3; j++) {
				this.set(i, j, b.get(i, j));
			}
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
	public int OneToWin_O() {
		int a,b = 5;
		int counter1,counter2 = 0;
		for(int i =0;i<3;i++) {
			a = 5;
			b = 5;
			counter1 = 0;
			counter2 = 0;
			for(int j=0;j<3;j++) {
				if (board[i][j] == '_'){
					a = i;
					b = j;
				}
				if(board[i][j] == 'X') {
					counter1++;
				}
				if(board[i][j] == 'O') {
					counter2++;
				}
			}
			if(a != 5 && (counter2 == 2 || counter1== 2)) {
				this.board[a][b] = 'O';
				return -100;
			}
		}
		for(int i =0;i<3;i++) {
			a = 5;
			b = 5;
			counter1 = 0;
			counter2 = 0;
			for(int j=0;j<3;j++) {
				if (board[j][i] == '_'){
					a = i;
					b = j;
				}
				if(board[j][i] == 'O') {
					counter2++;
				}
				if(board[j][i] == 'X') {
					counter1++;
				}
			}
			if(a != 5 && (counter2 == 2 || counter1== 2)) {
				this.board[b][a] = 'O';
				return -100;
			}
		}
		a = 5;
		counter1 = 0;
		counter2 = 0;
		for(int i =0;i<3;i++) {
			if(board[i][i] == '_') {
				a = i;
			}
			if(board[i][i] == 'O') {
				counter2++;
			}
			if(board[i][i] == 'X') {
				counter1++;
			}
			if(a != 5 && (counter2 == 2 || counter1== 2)) {
				this.board[a][a] = 'O';
				return -100;
			}
		}
		b = 5;
		a = 5;
		counter1 = 0;
		counter2 = 0;
		for(int i =0;i<3;i++) {
			if(board[2-i][i] == '_') {
				a = 2-i;
				b = i;
			}
			if(board[2-i][i] == 'O') {
				counter2++;
			}
			if(board[2-i][i] == 'X') {
				counter1++;
			}
			if(a != 5 && (counter2 == 2 || counter1== 2)) {
				this.board[a][b] = 'O';
				return -100;
			}
		}
		return 0;
	}
	
	
	public int OneToWin_X() {
		int a = 5;
		int b = 5;
		int counter1 = 0;
		int counter2 = 0;
		for(int i =0;i<3;i++) {
			a = 5;
			b = 5;
			counter1 = 0;
			counter2 = 0;
			for(int j=0;j<3;j++) {
				if (board[i][j] == '_'){
					a = i;
					b = j;
				}
				if(board[i][j] == 'X') {
					counter1++;
				}
				if(board[i][j] == 'O') {
					counter2++;
				}
			}
			if(a != 5 && (counter2 == 2 || counter1== 2)) {
				this.board[a][b] = 'X';
				return 100;
			}
		}
		for(int i =0;i<3;i++) {
			a = 5;
			b = 5;
			counter1 = 0;
			counter2 = 0;
			for(int j=0;j<3;j++) {
				if (board[j][i] == '_'){
					a = i;
					b = j;
				}
				if(board[j][i] == 'O') {
					counter2++;
				}
				if(board[j][i] == 'X') {
					counter1++;
				}
			}
			if(a != 5 && (counter2 == 2 || counter1== 2)) {
				this.board[b][a] = 'X';
				return 100;
			}
		}
		a = 5;
		counter1 = 0;
		counter2 = 0;
		for(int i =0;i<3;i++) {
			if(board[i][i] == '_') {
				a = i;
			}
			if(board[i][i] == 'O') {
				counter2++;
			}
			if(board[i][i] == 'X') {
				counter1++;
			}
			if(a != 5 && (counter2 == 2 || counter1== 2)) {
				this.board[a][a] = 'X';
				return 100;
			}
		}
		b = 5;
		a = 5;
		counter1 = 0;
		counter2 = 0;
		for(int i =0;i<3;i++) {
			if(board[2-i][i] == '_') {
				a = 2-i;
				b = i;
			}
			if(board[2-i][i] == 'O') {
				counter2++;
			}
			if(board[2-i][i] == 'X') {
				counter1++;
			}
			if(a != 5 && (counter2 == 2 || counter1== 2)) {
				this.board[a][b] = 'X';
				return 100;
			}
		}
		return 0;
	}
	
	public boolean Equal(Board b) {
		for(int i =0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(this.board[i][j] != b.get(i, j)) {
					return false;
				}
			}
		}
		return true;
	}
}
