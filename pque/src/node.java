class node {
	private int val;
	private node next;
	node() {
		this.val = 0;
		this.next = null;
	}
	node(int d) {
		this.val = d;
		this.next = null;
	}
	int getVal() {
		return this.val;
	}
	void setVal(int val) {
		this.val = val;
	}
	node getNext() {
		return this.next;
	}
	void setNext(node n) {
		this.next = n;
	}
	
}