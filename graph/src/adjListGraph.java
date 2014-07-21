import java.util.ArrayList;

public class adjListGraph{
	int vertexCount;
	ArrayList<Integer> vertices;
	linklist[] edges;
	public adjListGraph(int n) {
		this.vertexCount = n;
		vertices = new ArrayList<Integer>();
		edges = new linklist[n];
		for(int i = 0; i < n; i++) {
			vertices.add(i);
			edges[i] = new linklist();
		}
	}
	
	public void addEdge(int src, int dest) {
		int i = vertices.indexOf(src);
		int j = vertices.indexOf(dest);
		edges[i].addAtBeginning(j);
		edges[j].addAtBeginning(i);
	}
}