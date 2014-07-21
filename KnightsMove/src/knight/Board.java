package knight;

public class Board {
	Square[][] board;
	static int ROWS = 8;
	static int COLUMNS = 8;
	static int SQUARES = 64;
	int numCoveredSquares;
	
	Board() {
		Square[][] board = new Square[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Square(i , j);
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
