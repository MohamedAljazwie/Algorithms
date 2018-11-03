/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 *
 * @author MohamedSayed
 */
/*

     *  Java Program to Implement AVL Tree

 */
import java.util.Scanner;

/* Class AVLNode */
class AVLNode {

    AVLNode left, right;

    int data;

    int height;

    /* Constructor */
    public AVLNode() {

        left = null;

        right = null;

        data = 0;

        height = 0;

    }

    /* Constructor */
    public AVLNode(int n) {

        left = null;

        right = null;

        data = n;

        height = 0;

    }

}

/* Class AVLTree */
class AVLTree {

    private AVLNode root;

    /* Constructor */
    public AVLTree() {

        root = null;

    }

    /* Function to check if tree is empty */
    public boolean isEmpty() {

        return root == null;

    }

    /* Make the tree logically empty */
    public void makeEmpty() {

        root = null;

    }

    /* Function to insert data */
    public void insert(int data) {

        root = insert(data, root);

    }

    /* Function to get height of node */
    private int height(AVLNode t) {

        return t == null ? -1 : t.height;

    }

    /* Function to max of left/right node */
    private int max(int lhs, int rhs) {

        return lhs > rhs ? lhs : rhs;

    }

    /* Function to insert data recursively */
    private AVLNode insert(int x, AVLNode t) {

        if (t == null) {
            t = new AVLNode(x);
        } else if (x < t.data) {

            t.left = insert(x, t.left);

            if (height(t.left) - height(t.right) == 2) {
                if (x < t.left.data) {
                    t = rotateWithLeftChild(t);
                } else {
                    t = doubleWithLeftChild(t);
                }
            }

        } else if (x > t.data) {

            t.right = insert(x, t.right);

            if (height(t.right) - height(t.left) == 2) {
                if (x > t.right.data) {
                    t = rotateWithRightChild(t);
                } else {
                    t = doubleWithRightChild(t);
                }
            }

        } // Duplicate; do nothing

        t.height = max(height(t.left), height(t.right)) + 1;

        return t;

    }

    /* Rotate binary tree node with left child */
    private AVLNode rotateWithLeftChild(AVLNode k2) {

        AVLNode k1 = k2.left;

        k2.left = k1.right;

        k1.right = k2;

        k2.height = max(height(k2.left), height(k2.right)) + 1;

        k1.height = max(height(k1.left), k2.height) + 1;

        return k1;

    }

    /* Rotate binary tree node with right child */
    private AVLNode rotateWithRightChild(AVLNode k1) {

        AVLNode k2 = k1.right;

        k1.right = k2.left;

        k2.left = k1;

        k1.height = max(height(k1.left), height(k1.right)) + 1;

        k2.height = max(height(k2.right), k1.height) + 1;

        return k2;

    }

    /**
     *
     * Double rotate binary tree node: first left child
     *
     * with its right child; then node k3 with new left child
     */
    private AVLNode doubleWithLeftChild(AVLNode k3) {

        k3.left = rotateWithRightChild(k3.left);

        return rotateWithLeftChild(k3);

    }

    /**
     *
     * Double rotate binary tree node: first right child
     *
     * with its left child; then node k1 with new right child
     */
    private AVLNode doubleWithRightChild(AVLNode k1) {

        k1.right = rotateWithLeftChild(k1.right);

        return rotateWithRightChild(k1);

    }

    /* Functions to count number of nodes */
    public int countNodes() {

        return countNodes(root);

    }

    private int countNodes(AVLNode r) {

        if (r == null) {
            return 0;
        } else {

            int l = 1;

            l += countNodes(r.left);

            l += countNodes(r.right);

            return l;

        }

    }

    /* Functions to search for an element */
    public boolean search(int val) {

        return search(root, val);

    }

    private boolean search(AVLNode r, int val) {

        boolean found = false;

        while ((r != null) && !found) {

            int rval = r.data;

            if (val < rval) {
                r = r.left;
            } else if (val > rval) {
                r = r.right;
            } else {

                found = true;

                break;

            }

            found = search(r, val);

        }

        return found;

    }

    /* Function for inorder traversal */
    public void inorder() {

        inorder(root);

    }

    private void inorder(AVLNode r) {

        if (r != null) {

            inorder(r.left);

            System.out.print(r.data + " ");

            inorder(r.right);

        }

    }

    /* Function for preorder traversal */
    public void preorder() {

        preorder(root);

    }

    private void preorder(AVLNode r) {

        if (r != null) {

            System.out.print(r.data + " ");

            preorder(r.left);

            preorder(r.right);

        }

    }

    /* Function for postorder traversal */
    public void postorder() {

        postorder(root);

    }

    private void postorder(AVLNode r) {

        if (r != null) {

            postorder(r.left);

            postorder(r.right);

            System.out.print(r.data + " ");

        }

    }

}

/* Class AVL Tree Test */
public class AVLTreeTest {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        /* Creating object of AVLTree */
        AVLTree tree = new AVLTree();

        tree.insert(15);
        tree.insert(10);
        tree.insert(8);
//
        tree.insert(12);
        tree.insert(17);
        tree.insert(9);
        tree.insert(21);
        tree.insert(20);
        tree.insert(19);
        tree.insert(18);

        tree.insert(25);
        tree.insert(11);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);

        tree.insert(7);
        tree.insert(13);
        tree.insert(23);
        tree.insert(22);
        tree.insert(24);

    }

}
