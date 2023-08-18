public class BinarySearchTree<E extends Comparable> {
    TreeNode root = null;

    public int numberNodes() {
        if (root == null) {
            return 0;
        }
        else {
            return numberNodes(root);
        }
    }

    private int numberNodes(TreeNode node) {
        if (node != null) {
            return 1 + numberNodes(node.left) + numberNodes(node.right);
        }
        else {
            return 0;
        }
    }

    public int numberLeafNodes() {
        if (root == null) {
            return 0;
        }
        else {
            return numberLeafNodes(root);
        }
    }

    private int numberLeafNodes(TreeNode node) {

        if (node.left != null && node.right != null) {
             return numberLeafNodes(node.left) + numberLeafNodes(node.right);
        }
        else if (node.left != null) {
             return numberLeafNodes(node.left);
        }
        else if (node.right != null) {
             return numberLeafNodes(node.right);
        }
        else {
            return 1;
        }

    }

    public int height() {

        if (root == null) {
            return -1;
        }
        else {
            return height(root) - 1;
        }
    }

    private int height(TreeNode node) {

        int leftHeight = 0;
        int rightHeight = 0;

        if (node.left != null) {
            leftHeight = height(node.left);
        }

        if (node.right != null) {
            rightHeight = height(node.right);
        }

        return Math.max(leftHeight, rightHeight) + 1;

    }

    public boolean search(E value) {
        if (root != null) {
            if (value.compareTo(root.value) < 0) {
                return search(root.left, value);
            }
            else if (value.compareTo(root.value) > 0) {
                return search(root.right, value);
            }
            else {
                // value is root.value.
                return true;
            }
        }
        else {
            return false;
        }
    }

    public boolean search(TreeNode node, E value) {
        if (node != null) {
            if (value.compareTo(node.value) < 0) {
                return search(node.left, value);
            }
            else if (value.compareTo(node.value) > 0) {
                return search(node.right, value);
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    public boolean insert(E value) {
        // First thing in the binary tree.
        if (root == null) {
            root = new TreeNode(value);
            return true;
        }
        else {
            return insert(null, root, value);
        }
    }

    private boolean insert(TreeNode parent, TreeNode node, E value) {
        if (node == null) {
            // Insert the value
            if (value.compareTo(parent.value) < 0) {
                parent.left = new TreeNode(value);
            }
            else {
                parent.right = new TreeNode(value);
            }
            return true;

        }
        else {
            if (value.compareTo(node.value) == 0) {
                return false;
            }
            else if (value.compareTo(node.value) < 0) {
                return insert(node, node.left, value);
            }
            else {
                return insert(node, node.right, value);
            }
        }
    }

    public void display(String message) {
        System.out.println(message);
        display(root);
    }

    private void display(TreeNode node) {
        if (node != null) {
            display(node.left);
            System.out.println(node.value);
            display(node.right);
        }
    }

    public boolean remove(E value) {
        TreeNode parent = null;
        TreeNode node = root;

        while (true) {
            if (node == null) {
                return false;
            }
            else if (value == node.value) {
                break;
            }
            else if (value.compareTo(node.value) < 0) {
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
            }
            else {
                if (parent.left == node) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
            }
        }

        return true;
    }

    private class TreeNode {
        E value;
        TreeNode left;
        TreeNode right;

        public TreeNode(E value) { this.value = value; }
    }


}