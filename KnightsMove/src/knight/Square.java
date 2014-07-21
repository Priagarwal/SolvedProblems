package knight;

public class Square {
	static int ROWS = 8;
	static int COLUMNS = 8;
	static int SQUARES = 64;
	static int row;
	static int column;
	boolean isDone;
	
	Square() {
		row = 0;
		column = 0;
		isDone = false;
	}
	Square(int x, int y) {
		row = x;
		column = y;
		isDone = false;
	}
	
	boolean isCovered() {
		return (isDone);
	}
	
	void setCovered() {
		isDone = true;
	}
	
	boolean isInBoard() {
		return (true);
	}
	
	
	public static void main(String[] args) {
		

	}

}
