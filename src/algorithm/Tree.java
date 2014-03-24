package algorithm;

public class Tree {
	private static int[] mapIndex = new int[256];
	private Node root;
	void mapToIndices(int[] inorder, int n){
	    int i;  
	    for (i=0; i<n; i++) {  
	        mapIndex[inorder[i]] = i;  
	    }  
	}  
	public static void traverse(Node node){
		if(node.left != null){
			traverse(node.left);
		}
		System.out.print(node.value + " , ");//-------------------->这是中序遍历
		if(node.right != null){
			traverse(node.right);
		}
		//System.out.print(node.value + " , ");//------------------>这是后序遍历
	}
	public Node buildInorderPreorder(int[] pre,int n, int offset){  
	    if (n == 0) {
//System.out.println("----null");
	    	return null; 
	    }
	    
	    int rootVal = pre[0];
	    int i = mapIndex[rootVal] - offset;
//System.out.println("i : " + i);
	    Node root = new Node(rootVal);  
	    
	    int[] pre1 = new int[i];
	    for(int index = 0; index < pre1.length; index ++){
	    	pre1[index] = pre[index + 1];
	    }
	    root.left = buildInorderPreorder(pre1,i,offset);
	    
	    int[] pre2 = new int[pre.length - i - 1];
	    for(int index = 0; index < pre2.length; index ++){
	    	pre2[index] = pre[index + i + 1];
	    }
	    root.right = buildInorderPreorder(pre2,n-i-1, offset+i+1);
	    return root;
	}  


	private class Node{
		Node(int value){
			this.value = value;
			this.left= null;
			this.right = null;
		}
		private int value;
		private Node left;
		private Node right;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree t = new Tree();
		int pre[] = {7, 10, 4, 3, 1, 2, 8, 11};  
	    int in[] = {4, 10, 3, 1, 7, 11, 8, 2};  
	    int n = in.length;  
	    int offset = 0;  
	    t.mapToIndices(in, n);  
	    t.root = t.buildInorderPreorder(pre, n, offset);  
	    Tree.traverse(t.root);  

	}
}