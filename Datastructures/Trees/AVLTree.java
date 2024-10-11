package Datastructures.Trees;

class TreeNode {
    int data, height;
    TreeNode left, right;

    TreeNode(int d) {
        data = d;
        height = 1;
    }
}

public class AVLTree {

    int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    int getBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    TreeNode rightRotate(TreeNode y) {
        System.out.println("Rotate right on node " + y.data);
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    TreeNode leftRotate(TreeNode x) {
        System.out.println("Rotate left on node " + x.data);
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    TreeNode insert(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }

        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }

        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + ", ");
            inOrderTraversal(node.right);
        }
    }

    TreeNode minValueNode(TreeNode node) {
        TreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    TreeNode delete(TreeNode node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            TreeNode temp = minValueNode(node.right);
            node.data = temp.data;
            node.right = delete(node.right, temp.data);
        }

        if (node == null) {
            return node;
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }

        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }

        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        TreeNode root = null;

        int[] letters = { 'C', 'B', 'E', 'A', 'D', 'H', 'G', 'F' };
        for (int letter : letters) {
            root = tree.insert(root, letter);
        }

        System.out.println("In-order Traversal: ");
        tree.inOrderTraversal(root);

        System.out.println("\n\nAfter deleting E:");
        root = tree.delete(root, 'E');
        tree.inOrderTraversal(root);
    }
}

