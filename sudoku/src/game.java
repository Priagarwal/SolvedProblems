import java.util.ArrayList;


public class game {
	int[][] grid;
	int[][] solution;
	game(int[][] a) {
		grid = new int[9][9];
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				grid[i][j] = a[i][j];
	}
	
	void printGrid() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(grid[i][j] == 0)
					System.out.print("  ");
				else
					System.out.print(grid[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
				
	}
	
	ArrayList<Integer> getEmpty() {
		ArrayList<Integer> position = new ArrayList<Integer>();
		if(!isComplete(grid)) {
			for(int i = 0; i < 9; i++) 
				for(int j = 0; j < 9; j++)
					if(grid[i][j] == 0) {
						position.add(i);
						position.add(j);
						return position;
					}
		}
		return null;
	}
	boolean isInSubCube(int x, int y, int val) {
		int topX = ((int)(x/3)) * 3;
		int topY = ((int)(y/3)) * 3;
		for(int i = topX; i < topX+3; i++)
			for(int j = topY; j < topY+3; j++) {
				if(grid[i][j] == val)
					return true;
			}
		return false;
	}
	
	boolean isAbsent(int x, int y, int val) {
		for(int i = 0; i < 9; i++)
			if (grid[x][i] == val || grid[i][y] == val || isInSubCube(x,y,val))
				return false;
		return true;
	}
	
	ArrayList<Integer> getPossibleEntry(int i,int j) {
		int a[] = {1,2,3,4,5,6,7,8,9};	
		ArrayList<Integer> possible = new ArrayList<Integer>();
		for(int k = 0; k < 9; k++) {
			if(isAbsent(i,j,a[k]))
				possible.add(a[k]);
		}
		return possible;
	}
	
	boolean solve() {
		if(isComplete(grid))
			return true;
		else {
			ArrayList<Integer> position = getEmpty();
			int x = position.get(0);
			int y = position.get(1);
			int temp[][] = new int[9][9];
			ArrayList<Integer> possibleEntries= getPossibleEntry(x,y);
			for (int a : possibleEntries) {
				grid[x][y] = a;
				for(int i = 0; i < 9; i++)
					for(int j = 0; j < 9; j++)
						temp[i][j] = grid[i][j];
				if(solve()) {
					return true;
				} else {
					for(int i = 0; i < 9; i++)
						for(int j = 0; j < 9; j++)
							grid[i][j] = temp[i][j];
				}
			}
		}
		return true;
		
	}
		
	
	boolean isComplete(int grid[][]) {
		for(int i = 0; i < 9; i++) 
			for(int j = 0; j < 9; j++) 
				if(grid[i][j] == 0) {
					return false;
				}
		return true;
	}
	
}
