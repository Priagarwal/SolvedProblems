
public class linklist {
	int size = 0;
	node start = null;
	linklist() {
		this.size = 0;
		this.start = null;
	}
	linklist(int a) {
		this.size = 1;
		node n = new node(a);
		this.start = n;
	}
	linklist(node n) {
		size = 1;
		start = n;
	}
	int getSize(){
		return this.size;
	}
	int length() {
		int l = 0;
		node n = this.start;
		while(n != null) {
			l++;
			n = n.getNext();
		}
		return l;
	}
	void addAtBeginning(int data){
		node newNode = new node(data);
		newNode.setNext(start);
		start = newNode;
		this.size++;
	}
	void addAtPosition(int data, int pos) {
		if(pos <= this.getSize()+1) {
			int i = 1;
			node currentNode = start;
			while (i < (pos - 1)) {
				currentNode = currentNode.getNext();
				i++;
			}
			node newNode = new node(data);
			newNode.setNext(currentNode.getNext());
			currentNode.setNext(newNode);
			this.size++;
		}
		else {
			System.out.println("List is not long enough");
		}
	}
	void addAtEnd(int data) {
		if(start != null) {
			addAtPosition(data, this.size+1);
		} else {
			addAtBeginning(data);
		}
	}
	
	void printList() {
		node n = this.start;
		while(n != null) {
			System.out.print(n.getVal()+ "  ");
			n = n.getNext();
		}
		System.out.println();
	}
	
	linklist reverseListRecur(node root) {
		if(root == null) {
			return null;
		} else if(root.next == null) {
			linklist l = new linklist(root);
			return l;
		} else {
			linklist l = new linklist();
			node r = root;
			l = reverseListRecur(root.next);
			l.addAtEnd(r.val);
			return l;			
		} 
	}
	/*
	void reverseListIter(node root) {
		if(root == null || root.next == null) {
			return;
		} else {
			node a = root;
			node b = root.getNext();
			node c = null;
			while(b != null) {
				System.out.println(a.getVal());
				System.out.println(b.getVal());				
				c = b.getNext();
				if(c != null) {
					System.out.println(c.getVal());
					b.setNext(a);
					a = b;
					b = c;
				} else {
					System.out.println("c is null");
					b.setNext(a);
					a.setNext(null);
					this.start = b;
					return;
				}					
				
			}
			this.start = a;
			return;			
		} 
	}
	*/
		
}
