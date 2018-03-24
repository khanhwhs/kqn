package Basic;
class Node 
{
 int data;
 Node left, right;
 Node(int d) 
 {
     data = d;
     left = right = null;
 }
}
public class WidthTree {
	
	 public static void main(String args[]) 
	 {
	     BinaryTree tree = new BinaryTree();
	     tree.root = new Node(1);
	     tree.root.left = new Node(2);
	     tree.root.right = new Node(3);
	     tree.root.right.right = new Node(9);
	     tree.root.left.left = new Node(4);
	     tree.root.left.right = new Node(5);
	     tree.root.left.left.left = new Node(8);
//	     tree.printTreeByLvl(tree.root);
//	     if(tree.isBalanced(tree.root))
//	         System.out.println("Tree is balanced");
//	     else
//	         System.out.println("Tree is not balanced");
	     System.out.println("Width at level 2 is: " + width(tree.root, 2));
	     
	 }
	 
	 static int width(Node root, int level){
		 if ( root == null) return 0;
		 if ( level == 1) return 1;
		 return (width(root.left, level -1 )  + width(root.right, level -1 ));
	 }

}
