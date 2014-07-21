public class arrange {
 
	 static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	static void arrangeList(int A[], int n)
	{
		for(int i=1; i<n; i++)
		{
			if(i%2==1 && A[i] < A[i-1])
				swap(A, i, i -1);
			if(i%2==0 && A[i] > A[i-1])
				swap(A,i, i-1);
		}
		return;
	}
    public static void main(String[] args) {
    	int a[] = {4,3,2,1};
    	for(int i=0; i<a.length; i++)
    	 System.out.print(a[i] + " ");
    	System.out.println("");
    	arrangeList(a,a.length);
    	for(int i=0; i<a.length; i++)
       	 System.out.print(a[i] + " ");
    }
}