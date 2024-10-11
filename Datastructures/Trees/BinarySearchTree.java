package Datastructures.Trees;

class TreeNode2 {
    int data;
    TreeNode2 left, right;

    TreeNode2(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {

    public static TreeNode2 minValueNode(TreeNode2 node) {
        TreeNode2 current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }


    public static TreeNode2 delete(TreeNode2 root, int data) {
        if (root == null) {
            return null;
        }

        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {

            if (root.left == null) {
                TreeNode2 temp = root.right;
                root = null;
                return temp;
            } else if (root.right == null) {
                TreeNode2 temp = root.left;
                root = null;
                return temp;
            }


            TreeNode2 temp = minValueNode(root.right);
            root.data = temp.data;
            root.right = delete(root.right, temp.data);
        }

        return root;
    }

    public static void main(String[] args) {

        TreeNode2 root = new TreeNode2(50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);


        root = delete(root, 20);

        root = delete(root, 30);

        root = delete(root, 50);

        System.out.println("Root value: " + root.data);
    }

    public static TreeNode2 insert(TreeNode2 node, int data) {
        if (node == null) {
            return new TreeNode2(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }
}
