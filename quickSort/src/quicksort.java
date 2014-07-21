
public class quicksort{

	int a[];
	int n;
	public static void quickSort(int a[], int l, int r) {
		if (l < r) {
			int pos = partition(a, l, r);
			if(pos > l)
			quickSort(a, l, pos-1);
			if(pos < r)
			quickSort(a, pos+1, r);
		}
	}
	
	public static void swap(int a[], int i, int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t; 
    }
	
	public static int partition(int a[], int l, int r) {
		int pivot = a[l];
		int left = l;
		int right = r;
		while ( left < right ) {
			while (a[left] <= pivot && left < r) {
				left++;
			}
			while (a[right] >= pivot && right > l) {
				right--;
			}
			if(left < right) {
				swap (a, left, right);
			}			
		}
		swap(a, l, right);
		return right;
	}
	
	public static void main(String[] args) {
		int []a1={4,1,3,2,16,9,10,14,8,7};
       
         quickSort(a1, 0, a1.length-1);
        for(int i=0;i<a1.length;i++){
            System.out.print(a1[i] + " ");
        }
        
        //System.out.print(partition(a1, 0, 4));
    }
	
	
}