public class adjMatGraph{
	int adjMat[][];
	int numOfVertices;
	adjMatGraph(int n) {
		adjMat = new int[n][n];
		numOfVertices = n;		
	}
	
	boolean addEdge(int i, int j) {
		if(i >= 0 && i <= numOfVertices && j >= 0 && j <= numOfVertices) {
			adjMat[i][j] = 1;
			return true;
		}
		return false;
	}
	
	boolean isEdge(int i, int j) {
		if(i >= 0 && i <= numOfVertices && j >= 0 && j <= numOfVertices) {
			return(adjMat[i][j] == 1);
		}
		return false;
	}
	
	boolean removeEdge(int i, int j) {
		if(i >= 0 && i <= numOfVertices && j >= 0 && j <= numOfVertices) {
			adjMat[i][j] = 0;
			return true;
		}
		return false;
	}
}