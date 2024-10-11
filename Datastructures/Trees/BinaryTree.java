package Datastructures.Trees;

class TreeNode1 {
    String data;
    TreeNode1 left;
    TreeNode1 right;

    public TreeNode1(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    public static void preOrderTraversal(TreeNode1 node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + ", ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
    public static void inOrderTraversal(TreeNode1 node){
        if (node == null){
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data +", ");
        inOrderTraversal(node.right);
    }

    public static void postOrderTraversal(TreeNode1 node){
        if (node == null ){
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + ", ");
    }


    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1("R");
        TreeNode1 nodeA = new TreeNode1("A");
        TreeNode1 nodeB = new TreeNode1("B");
        TreeNode1 nodeC = new TreeNode1("C");
        TreeNode1 nodeD = new TreeNode1("D");
        TreeNode1 nodeE = new TreeNode1("E");
        TreeNode1 nodeF = new TreeNode1("F");
        TreeNode1 nodeG = new TreeNode1("G");

        root.left = nodeA;
        root.right = nodeB;

        nodeA.left = nodeC;
        nodeA.right = nodeD;

        nodeB.left = nodeE;
        nodeB.right = nodeF;

        nodeF.left = nodeG;

        System.out.print("Pre-order Traversal: ");
        preOrderTraversal(root);
        System.out.print("In-order Traversal: ");
        inOrderTraversal(root);
        System.out.print("Post-order Traversal: ");
        postOrderTraversal(root);
    }
}

