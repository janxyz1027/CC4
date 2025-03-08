package com.mycompany.bst;
import java.util.*;

class BST {
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BST() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = maxValue(root.left);
            root.left = deleteRec(root.left, root.key);
        }
        return root;
    }

    int maxValue(Node root) {
        while (root.right != null)
            root = root.right;
        return root.key;
    }

    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void preorder() {
        preorderRec(root);
        System.out.println();
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() {
        postorderRec(root);
        System.out.println();
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    void printArrayRepresentation() {
        List<Integer> arr = new ArrayList<>();
        buildArray(root, arr);
        System.out.println("1-D Array Representation: " + arr);
    }

    void buildArray(Node root, List<Integer> arr) {
        if (root != null) {
            arr.add(root.key);
            buildArray(root.left, arr);
            buildArray(root.right, arr);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            BST tree = new BST();
            System.out.println("Enter numbers to insert into BST (separated by spaces):");
            String[] inputs = scanner.nextLine().split(" ");
            for (String input : inputs) {
                tree.insert(Integer.parseInt(input));
            }

            tree.printArrayRepresentation();
            System.out.println("Preorder Traversal: ");
            tree.preorder();
            System.out.println("Inorder Traversal: ");
            tree.inorder();
            System.out.println("Postorder Traversal: ");
            tree.postorder();

            System.out.println("Do you want to delete numbers? (yes/no):");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("Enter numbers to delete (separated by spaces):");
                String[] deleteInputs = scanner.nextLine().split(" ");
                for (String input : deleteInputs) {
                    tree.delete(Integer.parseInt(input));
                }

                tree.printArrayRepresentation();
                System.out.println("Preorder Traversal after deletion: ");
                tree.preorder();
                System.out.println("Inorder Traversal after deletion: ");
                tree.inorder();
                System.out.println("Postorder Traversal after deletion: ");
                tree.postorder();
            }

            System.out.println("Try again? (yes/no):");
            if (!scanner.nextLine().equalsIgnoreCase("yes")) {
                break;
            }
        }
        scanner.close();
    }
}
