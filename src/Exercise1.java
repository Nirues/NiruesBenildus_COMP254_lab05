// Assuming TreeNode class is defined in another class

public class Exercise1 {

    // Preorder Next
    public static TreeNode preorderNext(TreeNode node) {
        if (node.left != null)
            return node.left;
        else if (node.right != null)
            return node.right;
        else {
            while (node.parent != null) {
                if (node == node.parent.left && node.parent.right != null)
                    return node.parent.right;
                node = node.parent;
            }
            return null;
        }
    }

    // Inorder Next
    public static TreeNode inorderNext(TreeNode node) {
        if (node.right != null) {
            node = node.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else {
            while (node.parent != null && node == node.parent.right)
                node = node.parent;
            return node.parent;
        }
    }

    // Postorder Next
    public static TreeNode postorderNext(TreeNode node) {
        if (node.parent != null && node == node.parent.left && node.parent.right != null) {
            node = node.parent.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else {
            while (node.parent != null && node == node.parent.right)
                node = node.parent;
            return node.parent;
        }
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

        // Assigning parent nodes
        root.left.parent = root;
        root.right.parent = root;
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;

        // Test preorderNext
        System.out.println("Preorder traversal:");
        TreeNode current = root;
        while (current != null) {
            System.out.println(current.val);
            current = preorderNext(current);
        }

        // Test inorderNext
        System.out.println("\nInorder traversal:");
        current = root;
        while (current != null) {
            System.out.println(current.val);
            current = inorderNext(current);
        }

        // Test postorderNext
        System.out.println("\nPostorder traversal:");
        current = root;
        while (current != null) {
            System.out.println(current.val);
            current = postorderNext(current);
        }
    }
}
