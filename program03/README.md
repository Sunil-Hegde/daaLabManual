# Binary Search Tree

Write a program to perform insert and delete operations in Binary Search Tree.


```java
class BinarySearchTree {
    // Node class representing a node in the BST
    class Node {
        int key;
        Node left, right;
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    // Root of the BST
    Node root;
    // Constructor
    BinarySearchTree() {
        root = null;
    }
    // Insert a new key in the BST
    void insert(int key) {
        root = insertRec(root, key);
    }
    // A recursive function to insert a new key in the BST
    Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }
        // Otherwise, recur down the tree
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        // Return the unchanged node pointer
        return root;
    }

    // Delete a key from the BST
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }
    // A recursive function to delete a key in the BST
    Node deleteRec(Node root, int key) {
        // Base case: If the tree is empty
        if (root == null) {
            return root;
        }
        // Otherwise, recur down the tree
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node with two children: 
           // Get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }
    // A utility function to find the minimum value node in a given BST
    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }
    // This method calls the in-order traversal of the BST
    void inorder() {
        inorderRec(root);
    }
    // Function to do in-order traversal of the BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
    // Main method
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] nodes = {50, 30, 20, 40, 70, 60, 80};
        // Insert nodes
        for(int node : nodes){
            bst.insert(node);
        }
        // Print the in-order traversal of the BST
        System.out.println("In-order traversal of the given tree:");
        bst.inorder();
        System.out.println();
        // Delete nodes
        int[] deleteNodes = {20, 30, 50};
        for(int node : deleteNodes){
            bst.deleteKey(node);
            System.out.println("In-order traversal after deleting " + node + ": ");
            bst.inorder();
            System.out.println();
        }
    }
}
```

## Output:

```
sunil@sunil:~daaLabManual/program3$ java BinarySearchTree.java
In-order traversal of the given tree:
20 30 40 50 60 70 80 
In-order traversal after deleting 20: 
30 40 50 60 70 80 
In-order traversal after deleting 30: 
40 50 60 70 80 
In-order traversal after deleting 50: 
40 60 70 80
```