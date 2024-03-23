
public class Exercise2 {
    public static int computeHeight(TreeNode node) {
        if (node == null)
            return 0;
        int leftHeight = computeHeight(node.left);
        int rightHeight = computeHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    public static void printElementAndHeight(TreeNode node) {
        if (node == null)
            return;
        int height = computeHeight(node);
        System.out.println("Element: " + node.val + ", Height: " + height);
        printElementAndHeight(node.left);
        printElementAndHeight(node.right);
    }

    // Test
    public static void main(String[] args) {
        // Constructing a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        printElementAndHeight(root);
    }
}


