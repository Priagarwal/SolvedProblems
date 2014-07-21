package GameOfLife;

public class GameOfLife {

	final static int MAXSIZE = 6;
	final static int LIVE = 1;
	final static int DEAD = 0;
	static int currentState[][] = new int[MAXSIZE][];

	GameOfLife(int initialState[][]) {
		for (int i = 0; i < MAXSIZE; i++) {
			for (int j = 0; j < MAXSIZE; j++) {
				currentState[i][j] = initialState[i][j];
			}
		}
	}

	int liveNeighbours(int u, int v) {
		int live = 0;
		int i = 0;
		for (int j = 0; j < MAXSIZE; j++) {
			currentState[0][j] = currentState[MAXSIZE - 2][j];
			currentState[MAXSIZE - 1][j] = currentState[1][j];
		}
		for (i = 0; i < MAXSIZE; i++) {
			currentState[i][0] = currentState[i][MAXSIZE - 2];
			currentState[i][MAXSIZE - 1] = currentState[i][1];
		}
		for ( i = u - 1; i <= u + 1; i++) {
			for ( j = v - 1; j <= v + 1; j++) {
				if (currentState[i][j] == 1) {
					live++;
				}
			}
		}
		if (currentState[u][v] == 1) {
			live--;
		}
		return (live);
	}

	boolean shudLive(int i, int j) {
		if (liveNeighbours(i, j) == 2 || liveNeighbours(i, j) == 3) {
			return true;
		}
		else {
			return false;
		}
	}
	
	boolean shudTurnAlive(int i, int j) {
		if (liveNeighbours(i, j) == 3) {
			return true;
		}
		else {
			return false;
		}
	}
	
	void nextGeneration() {
		for (int i = 1; i < MAXSIZE - 1; i++) {
			for (int j = 1; j < MAXSIZE - 1; j++) {
				if (currentState[i][j] == LIVE) {
					if (shudLive(i, j)) {
						;
					}else {
						currentState[i][j] = DEAD;
					}
				}
				if (currentState[i][j] == DEAD) {
					if (shudTurnAlive(i, j)) {
						currentState[i][j] = LIVE;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int initialState[][] = new int[][] { { 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 1, 1, 0 }, { 0, 0, 0, 1, 0, 0 },
				{ 0, 1, 1, 0, 0, 0 }, { 0, 1, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0 } };

		GameOfLife game = new GameOfLife(initialState);
		for (int i = 0; i < 10; i++) {
			System.out.println(" \n State " + i + "\n");
			for (int j = 0; j < MAXSIZE; j++) {
				for (int k = 0; k < MAXSIZE; k++) {
					if (currentState[j][k] == LIVE) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
				System.out.println("");
			}
			game.nextGeneration();
		}
	}

}
