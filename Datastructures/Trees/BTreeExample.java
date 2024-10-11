package Datastructures.Trees;

import java.util.ArrayList;

class BTreeNode {
    ArrayList<Integer> keys;
    ArrayList<BTreeNode> children;
    boolean isLeaf;
    int t;

    public BTreeNode(int t, boolean isLeaf) {
        this.t = t;
        this.isLeaf = isLeaf;
        keys = new ArrayList<>();
        children = new ArrayList<>();
    }

    public void insertNonFull(int key) {
        int i = keys.size() - 1;

        if (isLeaf) {
            keys.add(0);
            while (i >= 0 && keys.get(i) > key) {
                keys.set(i + 1, keys.get(i));
                i--;
            }
            keys.set(i + 1, key);
        } else {
            while (i >= 0 && keys.get(i) > key) {
                i--;
            }
            i++;
            BTreeNode child = children.get(i);

            if (child.keys.size() == 2 * t - 1) {
                splitChild(i, child);

                if (keys.get(i) < key) {
                    i++;
                }
            }
            children.get(i).insertNonFull(key);
        }
    }

    public void splitChild(int i, BTreeNode y) {
        BTreeNode z = new BTreeNode(y.t, y.isLeaf);
        for (int j = 0; j < t - 1; j++) {
            z.keys.add(y.keys.remove(t));
        }
        if (!y.isLeaf) {
            for (int j = 0; j < t; j++) {
                z.children.add(y.children.remove(t));
            }
        }
        children.add(i + 1, z);
        keys.add(i, y.keys.remove(t - 1));
    }

    public void traverse() {
        for (int i = 0; i < keys.size(); i++) {
            if (!isLeaf) {
                children.get(i).traverse();
            }
            System.out.print(keys.get(i) + " ");
        }
        if (!isLeaf) {
            children.get(keys.size()).traverse();
        }
    }

    public BTreeNode search(int key) {
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }

        if (i < keys.size() && keys.get(i) == key) {
            return this;
        }

        if (isLeaf) {
            return null;
        }
        return children.get(i).search(key);
    }
}

class BTree {
    BTreeNode root;
    int t;

    public BTree(int t) {
        this.root = null;
        this.t = t;
    }

    public void traverse() {
        if (root != null) {
            root.traverse();
        }
    }

    public BTreeNode search(int key) {
        if (root == null) {
            return null;
        } else {
            return root.search(key);
        }
    }

    public void insert(int key) {
        if (root == null) {
            root = new BTreeNode(t, true);
            root.keys.add(key);
        } else {
            if (root.keys.size() == 2 * t - 1) {
                BTreeNode newRoot = new BTreeNode(t, false);
                newRoot.children.add(root);
                newRoot.splitChild(0, root);
                root = newRoot;
            }
            root.insertNonFull(key);
        }
    }
}

public class BTreeExample {
    public static void main(String[] args) {
        BTree bTree = new BTree(3);  // B-Tree bậc 3

        int[] values = {10, 20, 5, 6, 12, 30, 7, 17};

        for (int value : values) {
            bTree.insert(value);
        }

        System.out.println("Traversal of the constructed B-Tree:");
        bTree.traverse();

        int keyToSearch = 6;
        System.out.println("\n\nSearching for key " + keyToSearch + " in the B-Tree:");
        BTreeNode result = bTree.search(keyToSearch);
        if (result != null) {
            System.out.println("Key " + keyToSearch + " found in the B-Tree.");
        } else {
            System.out.println("Key " + keyToSearch + " not found in the B-Tree.");
        }
    }
}
