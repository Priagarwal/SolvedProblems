
public class node {
	int val = 0;
	node next = null;
	node() {
		this.val = 0;
		this.next = null;
	}
	node(int data) {
		this.val = data;
		this.next = null;
	}
	node getNext() {
		return this.next;
	}
	void setNext(node a) {
		this.next = a;
	}
	int getVal() {
		return this.val;
	}
	void setVal(int a) {
		this.val = a;
	}
}
