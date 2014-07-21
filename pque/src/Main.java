class Main {
private node start;
Main() {
	start = null;
}
Main(int data) {
	node n = new node(data);	
	start = n;
}
Main(node n) {
	start = n;
}

public void setStart( node s) {
	this.start= s;
}
public node getStart() {
	return this.start;
}

public int numOfNodes() {
	node x = this.start;
	int count = 0;
	while( x != null) {
		count++;
		x = x.getNext();
	}
	return count;
}
//inserting into a ll pq where value is priority
public void add(int data) {
	node n = new node(data);
	if(this.start != null) {
		node x = start;
		if (data > x.getVal() ) {
				start = n;
				n.setNext(x);
				return;
			}
		node y = x.getNext();
		if (y != null) {
			
			while(data <= y.getVal() && y != null) {
				x = y;
				y = y.getNext();
			}
			if (y == null)
				x.setNext(n);
			else {
				x.setNext(n);
				n.setNext(y);
			}		
		}
		else if (y == null) {
			x.setNext(n);
		}
	}
	else {
		this.start = n;
	}	
}

public int extractMax() {
	if (start != null) {
		node n = this .start;
		start = start.getNext();
		return n.getVal();
	}	
	return -1;
}

public void printQueue() {
	if(this.start != null) {
		node x = start;
		while(x != null) {
				System.out.print(x.getVal() + " ");
				x = x.getNext();
		}
	}
}

public static void main(String args[]) {
	Main pq = new Main();
	pq.add(3);
	pq.add(1);
	pq.add(10);
	pq.printQueue();
	int max = pq.extractMax();
	System.out.println("Max is " + max);
	pq.printQueue();
	pq.add(2);
	max = pq.extractMax();
	System.out.println("Max is " + max);
	pq.printQueue();
}
}


