public class bst {
	node root;
	int numOfNodes;
	
	public static node createBST(int a[], int n) {
		int i = 0;
		node tree = null;
		for(i = 0; i < n; i++ ) {
			tree = insert(tree, a[i]);
		}
		return tree;
	}
	
	static int max(int a, int b) {
		return(a>b?a:b);
	}
	
	public static int height( node r) {
		if (r != null) {
			return (1 + max(height(r.lc), height(r.rc)));
		}
		return 0;
	}
	public static int depth( node r) {
		return 0;
	}
	
	public static void inorderRec( node r) {
		if(r != null) {
			inorderRec(r.lc);
			System.out.print(r.data + " ");
			inorderRec(r.rc);
		}
	}
	
	private static node insert(node node, int data) { 
	    if (node==null) { 
	      node = new node(data); 
	    } 
	    else { 
	      if (data <= node.data) { 
	        node.lc = insert(node.lc, data); 
	      } 
	      else { 
	        node.rc = insert(node.rc, data); 
	      } 
	    }

	    return(node); // in any case, return the new pointer to the caller 
	  } 
	
	
	public static void main( String args[]) {
		int a[]={4,13,13,2};
		node tree = createBST(a, a.length);
		if(tree == null) {
			System.out.print("its null");
		}
		System.out.println(height(tree));
		inorderRec(tree);	
	}
	
}