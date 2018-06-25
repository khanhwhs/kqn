/**
 * IsBST
 */
public class IsBST {
    public static void main(String[] args) {
        int [] array = { 3, 6, 8, 23, 24, 76, 89 };
        TreeNode treeRoot = createBST(array);

        System.out.println(isBst(treeRoot,Integer.MIN_VALUE, Integer.MAX_VALUE));
        // inorder(treeRoot);
    }

//                 23
//     6                   76
// 3       8           1      89

// left = true && is(6)
//                 left = true && is(3)
//                 right
// right = true && is(76)

    public static boolean isBst(TreeNode root, int min, int max){
        if ( root.getLeft() == null && root.getRight() == null) return true;
        boolean left = (root.getLeft().getData() < root.getData() && root.getLeft().getData() > min)  && isBst(root.getLeft(), min, root.getData());
        boolean right = ( root.getRight().getData() > root.getData() && root.getRight().getData() < max)&& isBst(root.getRight(), root.getData(), max);

        return left && right;
    }

    public static TreeNode createBST(int array[]) {

        return createBST(array, 0, array.length-1);
    }

    private static TreeNode createBST(int[] array, int start, int end) {
        
        if(array == null || array.length == 0 || start > end) {
            return null;
        }
        
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(array[mid]);

        root.setLeft(createBST(array, start, mid-1));
        root.setRight(createBST(array, mid+1, end));

        return root;
    }

    public static void inorder(TreeNode root) {
        if(root == null) {
            return;
        }

        inorder(root.getLeft());
        System.out.print(root.getData() + "  ");
        inorder(root.getRight());
    }
}

class TreeNode {
     
     
    private int data;
    private TreeNode left;
    private TreeNode right;
     
    public int getData() {
        return data;
    }
 
    public void setData(int data) {
        this.data = data;
    }
 
    public TreeNode getLeft() {
        return left;
    }
 
    public void setLeft(TreeNode left) {
        this.left = left;
    }
 
    public TreeNode getRight() {
        return right;
    }
 
    public void setRight(TreeNode right) {
        this.right = right;
    }
 
    public TreeNode(int data) {
        super();
        this.data = data;
    }
 
    
}

