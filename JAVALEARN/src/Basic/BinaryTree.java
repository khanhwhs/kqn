package Basic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* Java program to determine if binary tree is 
height balanced or not */
 
/* A binary tree node has data, pointer to left child,
and a pointer to right child */
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

class BinaryTree 
{
 Node root;

 /* Returns true if binary tree with root as root is height-balanced */
 boolean isBalanced(Node node) 
 {
     int lh; /* for height of left subtree */

     int rh; /* for height of right subtree */

     /* If tree is empty then return true */
     if (node == null)
         return true;

     /* Get the height of left and right sub trees */
     lh = height(node.left);
     rh = height(node.right);

     if (Math.abs(lh - rh) <= 1
             && isBalanced(node.left)
             && isBalanced(node.right)) 
         return true;

     /* If we reach here then tree is not height-balanced */
     return false;
 }

 /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
  
 /* returns maximum of two integers */
 int max(int a, int b) 
 {
     return (a >= b) ? a : b;
 }

 /*  The function Compute the "height" of a tree. Height is the
     number of nodes along the longest path from the root node
     down to the farthest leaf node.*/
 int height(Node node) 
 {
     /* base case tree is empty */
     if (node == null)
         return 0;

     /* If tree is not empty then height = 1 + max of left
      height and right heights */
     return 1 + max(height(node.left), height(node.right));
 }
 
 int width(Node node, int level){
	 if ( node == null) return 0;
	 if ( level == 1) return 1;
	 return (width(node.left, level -1 )  + width(node.right, level -1 ));
 }
 int maxWidth(Node node){
	 int maxW = 0;
	 for (int i = 1; i< height(node) ; i++){
		 if ( maxW < width ( node,i)){
			 maxW = width(node,i);
		 }
	 }
	 return maxW;
 }
 //printing tree by level
 public void printTreeByLvl(Node tmpRoot) {

	 LinkedList<Node> currentLevel = new LinkedList<Node>();
	 LinkedList<Node> nextLevel = new LinkedList<Node>();

     currentLevel.add(tmpRoot);

     while (!currentLevel.isEmpty()) {
         Iterator<Node> iter = currentLevel.iterator();
         while (iter.hasNext()) {
             Node currentNode = iter.next();
             if (currentNode.left != null) {
                 nextLevel.add(currentNode.left);
             }
             if (currentNode.right != null) {
                 nextLevel.add(currentNode.right);
             }
             System.out.print(currentNode.data + " ");
         }
         currentLevel = nextLevel;
         System.out.println();
         nextLevel = new LinkedList<Node>();

     }

 }

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
     tree.printTreeByLvl(tree.root);
     if(tree.isBalanced(tree.root))
         System.out.println("Tree is balanced");
     else
         System.out.println("Tree is not balanced");
     
     System.out.println("Width at level 2 is: " + tree.width(tree.root, 3));
//     System.out.println("Max Width is: " + tree.maxWidth(tree.root));
 }
}

