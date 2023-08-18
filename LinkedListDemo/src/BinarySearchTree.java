import com.sun.source.tree.Tree;

public class BinarySearchTree {

    TreeNode root = null;

    // Kick-off method to set the root.
    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            insert(null, root, value);
        }
    }

    // This gets called after root has a value.
    private void insert(TreeNode parent, TreeNode node, int value) {
        if (node == null) {
            // Perform the insert
            if (value < parent.value) {
                parent.left = new TreeNode(value);
            } else {
                parent.right = new TreeNode(value);
            }

        } else {
            if (value < node.value) {
                insert(node, node.left, value);
            } else {
                insert(node, node.right, value);
            }
        }
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(TreeNode node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println(node.value);
            traverseInOrder(node.right);
        }
    }

    public void remove(int value) {
        TreeNode parent = null;
        TreeNode node = root;

        while (true) {
            if (value == node.value) {
                break;
            }
            else if (value < node.value) {
                parent = node;
                node = node.left;
            }
            else {
                parent = node;
                node = node.right;
            }
        }

        // Check for left child
        if (node.left != null) {
            TreeNode parentOfRight = node;
            TreeNode rightMost = node.left;
            while (rightMost.right != null) {
                parentOfRight = rightMost;
                rightMost = rightMost.right;
            }
            // rightMost has the largest value in the left subtree
            node.value = rightMost.value;
            if (parentOfRight.right == rightMost) {
                parentOfRight.right = rightMost.left;
            } else {
                parentOfRight.left = rightMost.left;
            }

        } else {
            // Root node has no left child
            if (parent == null) {
                root = root.right;
            } else {
                if (parent.left == node) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
            }
        }
    }

    private class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}