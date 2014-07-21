package knight;
import java.util.*;
public class Knight {
    static Board knightBoard;
	static Square currentSquare; 
	static int nextRank[] = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int nextFile[] = {-1, 1, -2, 2, -2, 2, -1, 1};
	ArrayList<Square> coveredSquares;
	static ArrayList<Square> knightPath;
	
	Knight(Square q) {
		knightBoard = new Board();
		currentSquare = new Square(q.row , q.column);
		coveredSquares = new ArrayList<Square> ();
		knightPath = new ArrayList<Square> ();
		currentSquare.isDone = true;
		knightBoard.board[currentSquare.row][currentSquare.column].isDone = true;
		coveredSquares.add(currentSquare);
	}
	
	Knight(int x, int y) {
		knightBoard = new Board();
		currentSquare = new Square(x, y);
		currentSquare.isDone = true;
		knightBoard.board[currentSquare.row][currentSquare.column].isDone = true;
		coveredSquares.add(currentSquare);
	}
	
	static Square[] possibleMoves(Square current) {
		Square[] possibleMoves = new Square[8]; 
		for (int k = 0; k < 8;k++ ) {
			Square s = new Square( (current.row + nextRank[k]), (current.column + nextFile[k]));
			if(!(knightBoard.board[s.row][s.column].isDone)) {
				possibleMoves[k] = s;
			}
		}
		return(possibleMoves);
	}
	
	void moveTo( Square s) {
		currentSquare = s;
		knightBoard.board[s.row][s.column].isDone = true;
		coveredSquares.add(s);
	}
	
	static int exitCount( Square s) {
		return(possibleMoves(s).length);
	}
	
	static int minimumCount( Square s ) {
		int min = 0;
		Square[] sons = possibleMoves(s);
		for( int i = 0; i < sons.length; i++) {
			if( min > exitCount(sons[i])) {
				min = exitCount(sons[i]);
			}
		}
		return min;
	}
	
	static Square nextMove( Square current) {
		Square[] sons = possibleMoves(current);
		Square next = sons[0];
		for( int i = 0; i < sons.length; i++) {
			if( minimumCount( next ) > minimumCount(sons[i])) {
				next = sons[i];
			}
		}
		return next;
	}
	void coveredSquare() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(knightBoard.board[i][j].isDone){
					coveredSquares.add(knightBoard.board[i][j]);
				}
			}
		}
	}
	
	static void knightsPath() {
		Square current = currentSquare;
		for (int i = 0; i < 64; i++) {
			knightPath.add(current);
			current = nextMove(current);
		}
	}
	
	public static void main(String[] args) {
		Knight k = new Knight(3, 4);
		knightsPath();
		while (knightPath.iterator().hasNext()) {
			System.out.println(knightPath.iterator().next().row + knightPath.iterator().next().column  );
		}
	}

}
