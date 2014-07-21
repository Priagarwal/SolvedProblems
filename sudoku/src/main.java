
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello World");
		int a[][] = { {4,0,9,0,7,0,5,6,2},
						{2,3,0,0,9,0,8,7,4},
						{5,7,0,4,2,0,9,3,0},
						{0,9,0,0,0,2,3,4,0},
						{0,2,0,0,0,0,0,5,7}, 
						{0,0,5,0,0,0,0,2,9},
						{9,0,0,0,0,0,2,0,0},
						{1,0,0,2,0,0,4,8,0},
						{8,0,2,0,0,4,7,0,6}
						};
		game sudoku1 = new game(a);
		sudoku1.printGrid();
		sudoku1.solve();
		sudoku1.printGrid();
		}
	
	}


