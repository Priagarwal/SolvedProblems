import java.util.Scanner;


public class graph {
	int V;
	int E;
	int root;
	int adjMat[][];
	
	graph(int v, int e) {
		this.root = 0;
		this.V = v;
		this.E = e;
		adjMat = new int[V][V];
		for(int i = 0; i < v; i++) {
			for(int j = 0; j < v; j++)
				adjMat[i][j] = 0;
		}		
	}
	
	void addEdge(int a, int b) {
		adjMat[a][b] = 1;
		adjMat[b][a] = 1;
	}
	
	void printGraph(){
		for(int i = 0; i < this.V; i++) {
			for(int j = 0; j < this.V; j++)
				System.out.print(adjMat[i][j]);
			System.out.println();
		}	
	}
	void constructGraph() {
		Scanner in = new Scanner(System.in);
		int a = 0, b = 0;
		int currentNoOfEdges = 0;
		while(currentNoOfEdges < E) {
			System.out.println("enter the end vertices of edge " + currentNoOfEdges);
			a = in.nextInt();
			b = in.nextInt();
			addEdge(a,b);
			currentNoOfEdges++;
		}
	}
	
	public static void main(String args[]) {
		graph G = new graph(5,5);
		G.constructGraph();
		G.printGraph();
	}
}
