package GameOfLife;

public class Node {
	public int row;
	public int column;
	public int liveNeighbours;
	public Node nextNode;
	
	Node(int x, int y) {
		row = x;
		column = y;
		liveNeighbours = 0;
		nextNode = null;
	}
	
	int getRow() {
		return( row );
	}
	
	int getColumn() {
		return( column );
	}
	
	int getNeighbour() {
		return( liveNeighbours );
	}
	
	void incrementNeighbour( ) {
		this.liveNeighbours++;
	}
	
	void decrementNeighbour( ) {
		this.liveNeighbours--;
	}
	
	void printNode() {
		System.out.println(row + "," + column );
	}

	boolean isNeighbour(Node n) {
		if( Math.abs(n.row - this.row) <= 1 ) {
			if( Math.abs(n.column - this.column) <= 1 ) {
				return( true );
			}
		}
		return ( false );
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
