package GameOfLife;

class LinkList {
	private Node first;

	// LinkList constructor
	public LinkList() {
		first = null;
	}

	// Returns true if list is empty
	public boolean isEmpty() {
		return first == null;
	}

	// Inserts a new Link at the first of the list
	public void insert(int x, int y) {
		Node node = new Node(x, y);
		if (!isEmpty()) {
			Node currentNode = first;
			while (currentNode != null && currentNode.row <= (node.row + 1) ) {
				if (node.isNeighbour(currentNode)) {
					currentNode.incrementNeighbour();
					node.incrementNeighbour();
				}
				currentNode = currentNode.nextNode;
			}
			node.nextNode = first;
			first = node;
		} else {
			first = node;
		}
	}

	// Deletes the link at the first of the list
	void delete(Node n) {
		Node temp = first;
		while (temp != null) {
			if (n.isNeighbour(temp)) {
				temp.decrementNeighbour();
			}
			temp = temp.nextNode;
		}
		temp = first;
		if (n == first) {
			first = null;
		} else {
			while (temp.nextNode != n) {
				temp = temp.nextNode;
			}
			temp.nextNode = n.nextNode;
		}
	}

	// Prints list data
	public void printList() {
		Node currentNode = first;
		System.out.print("List: ");
		while (currentNode != null) {
			currentNode.printNode();
			currentNode = currentNode.nextNode;
		}
		System.out.println("");
	}

	public void createList(int x[], int y[]) {
		LinkList list = new LinkList();
		for (int i = 0; i < x.length; i++) {
			list.insert( x[i], y[i]);
		}
	}

	public void deadToAlive() {
		if (!isEmpty()) {
			Node currentNode = first;
			int x = 0, y = 0;
			while (currentNode != null) {
				for (x = currentNode.row - 1; x <= currentNode.row + 1; x++) { 
					for (y = currentNode.column - 1; y <= currentNode.column + 1; y++) {
						Node dummyNode = new Node(x,y);
						Node cNode = first;
						while (cNode != null) {
							if (dummyNode.isNeighbour(cNode)) {
								dummyNode.incrementNeighbour();
							}
							cNode = cNode.nextNode;
						}
						if ( dummyNode.getNeighbour() == 3) {
							insert( x, y);
						}
					}
				}
				currentNode = currentNode.nextNode;
			}
			}
	}
			
	
	public void nextGeneration() {
		if (!isEmpty()) {
			deadToAlive();
			Node currentNode = first;
			while (currentNode != null) {
				if (currentNode.getNeighbour() > 3 || currentNode.getNeighbour() <2) {
					delete(currentNode);
				}
				currentNode = currentNode.nextNode;
			}
		}
	}
	
	public void printGrid() {
		final int MAXSIZE = 10;
		char currentState[][] = new char[MAXSIZE][];
		for (int j = 0; j < MAXSIZE; j++) {
			for (int k = 0; k < MAXSIZE; k++) {
				currentState[j][k] = ' ';
			}
		}
		if (!isEmpty()) {
			int x =0, y= 0;
			Node currentNode = first;
			while (currentNode != null) {
				x = currentNode.row;
				y = currentNode.column;
				currentState[x][y] = '*';
				currentNode = currentNode.nextNode;
			}
		}
		for (int j = 0; j < MAXSIZE; j++) {
			for (int k = 0; k < MAXSIZE; k++) {
				System.out.print(currentState[j][k]);
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
