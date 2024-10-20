public class BST {

    int prev = -1;

    public int isValidBST(TreeNode root) {
        if (root == null) {
            return 1;
        }

        if (isValidBST(root.left) == 0) {
            return 0;
        }

        if (root.val < prev) {
            return 0;
        }

        prev = root.val;

        return isValidBST((root.right));
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(6);
        t.left = new TreeNode(9);
        t.right = new TreeNode(4);
        t.right.left = new TreeNode(8);
        t.right.left.right = new TreeNode(3);

        BST sol = new BST();

        System.out.println(sol.isValidBST(t));

    }
}