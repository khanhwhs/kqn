package Code_Questions;

//Java program to calculate width of binary tree

//A binary tree TreeNode
class TreeNode {

 int val;
 TreeNode left, right;

 TreeNode(int item) {
     val = item;
     left = right = null;
 }
}

class BinaryTree {

 static TreeNode root;


 /* Function to get the maximum width of a binary tree*/
 int getMaxWidth(TreeNode TreeNode) {
     int maxWidth = 0;
     int width;
     int h = height(TreeNode);
     int i;

     /* Get width of each level and compare 
      the width with maximum width so far */
     for (i = 1; i <= h; i++) {
         width = getWidth(TreeNode, i);
         System.out.println("Width is:" + width);
         if (width > maxWidth) {
             maxWidth = width;
         }
     }

     return maxWidth;
 }

 /* Get width of a given level */
 int getWidth(TreeNode TreeNode, int level) {

     if (TreeNode == null) {
         return 0;
     }
//     System.out.println(level);
     if (level == 1) {
         return 1;
     } else if (level > 1) {
         return getWidth(TreeNode.left, level - 1)
                 + getWidth(TreeNode.right, level - 1);
     }
     return 0;

 }

 /* UTILITY FUNCTIONS */
 /* Compute the "height" of a tree -- the number of
  nodes along the longest path from the root TreeNode
  down to the farthest leaf TreeNode.*/
 int height(TreeNode TreeNode) {
     if (TreeNode == null) {
         return 0;
     } else {
          
         /* compute the height of each subtree */
         int lHeight = height(TreeNode.left);
         int rHeight = height(TreeNode.right);
          
         /* use the larger one */
         return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);
     }
 }

 public static void main(String args[]) {
     BinaryTree tree = new BinaryTree();
     tree.root = new TreeNode(1);
     tree.root.left = new TreeNode(2);
     tree.root.right = new TreeNode(3);
     tree.root.left.left = new TreeNode(4);
     tree.root.left.right = new TreeNode(5);
     tree.root.right.right = new TreeNode(8);
     tree.root.right.left = new TreeNode(9);
     tree.root.right.right.left = new TreeNode(6);
     tree.root.right.right.right = new TreeNode(7);

//     System.out.println("Maximum width is " + tree.getMaxWidth(root));
//     System.out.println("Height is: " + tree.height(root));
//     System.out.println(hasPathSum(root, 7));
 }
 
 public int isSymmetric(TreeNode a) {
     if ( a == null){
	        return 0;
	    }
	    return Symmetric(a.left, a.right)? 1:0;
	}
	public static boolean Symmetric(TreeNode a, TreeNode b){
	    if (a == null && b ==null)
	    {
	        return true;
	    }
	    if ( a == null || b == null)
	    {
	        return false;
	    }
	    if ( a.val != b.val)
	    {
	        return false;
	    }
	    return Symmetric(a.left, b.right) | Symmetric(b.right, b.left);
	}
}
