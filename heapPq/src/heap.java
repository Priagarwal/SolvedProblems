
public class heap {
	int a[];
	int heapsize;
	int MAX = 10;
	
	heap(int b[]) {
		a = b;
		heapsize = 0;
		MAX = 10;
	}
	
	int parent(int i) {
		return (i-1)/2;
	}
	
	int lc(int i) {
		if (2*i +1 < MAX)
			return 2*i +1;
		return -1;
	}
	int rc(int i) {
		if (2*i +2 < MAX)
			return 2*i +2;
		return -1;
	}
	
	void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	void heapify(int i) {
		if (i < heapsize/2) {
			int largest = i;
			if (a[largest] < a[lc(i)]) 
				largest = lc(i);
			if (a[largest] < a[rc(i)])
				largest = rc(i);
			if (largest != i && largest < MAX) {
				swap(i, largest);
				heapify(largest);
			}
		}
	}
	
	int extractMax() {
		int temp = a[0];
		a[0] = a[heapsize--];
		heapify(0);
		return temp;
	}
	
	void buildheap(int a[], int n) {
		this.heapsize = n;
		for( int i = 0; i<n; i++)
			this.a[i] = a[i];
		for (int i = heapsize/2; i >= 0; i--)
			heapify(i);
	}
	
	void heapsort(int a[], int n) {
		heapsize = n-1;
		while(heapsize > 0) {
			swap(0, heapsize);
			heapsize--;
			heapify(0);
		}		
	}
	
	public static void main(String args[]) {
		int b[] = {1,5, 2, 78, 12}; 
		heap h = new heap(b);
		 h.buildheap(b,b.length);
		 for( int i = 0; i < b.length; i++)
			 System.out.print(b[i] + " ");
		 System.out.println("");
		 h.heapsort(b, b.length);
		 for( int i = 0; i < b.length; i++)
			 System.out.print(b[i] + " ");
			// */
	}
	

}
