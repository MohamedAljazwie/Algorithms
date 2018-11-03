/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author M_Aljazwiee
 * @param <T>
 */
public class Tree<T extends Comparable<T>> {

    private TreeNode<T> root;
    private TreeNode<T> currentTreeNode;
    private StringBuffer buffer;
    private boolean firstIterate = true;
    private int size = 0;

    public Tree() {
        buffer = new StringBuffer();
    }

    public int getSize() {
        return size;
    }

    public boolean delete(T value) {
        boolean isDeleted = false;
        if (root == null) {
            throw new RuntimeException("Ther not Foud Tree To Delete");
        } else {
            currentTreeNode = root;
            deleteValue(value);
        }
        return isDeleted;
    }

    private void deleteValue(T value) {
        TreeNode<T> parentNode = currentTreeNode;
        while (currentTreeNode != null) {
            if (compare(value, currentTreeNode.value) == 0) {
                if (currentTreeNode.isLeaf()) {
                    if (compare(parentNode.value, currentTreeNode.value) < 0) {
                        parentNode.rigth = null;
                    } else {
                        parentNode.left = null;
                    }
                    currentTreeNode = null;
                    break;
                } else if (currentTreeNode.hasOneChild()) {
                    if (compare(parentNode.value, currentTreeNode.value) < 0) {
                        parentNode.rigth = currentTreeNode.getchild();
                        currentTreeNode = null;
                        break;
                    } else {
                        parentNode.left = currentTreeNode.getchild();
                        currentTreeNode = null;
                        break;
                    }

                } else if (currentTreeNode.hasTowChild()) {

                }

            } else if (compare(value, currentTreeNode.value) < 0) {
                parentNode = currentTreeNode;
                currentTreeNode = currentTreeNode.left;
            } else if (compare(value, currentTreeNode.value) > 0) {
                parentNode = currentTreeNode;
                currentTreeNode = currentTreeNode.rigth;
            }
        }

    }

    public boolean remove(T value) {
        return remove(root, value);
    }

    private boolean remove(TreeNode<T> node, T value) {

        if (node == null) {
            return false;
        }

        int i = compare(value, node.value);
        switch (i) {
            case 0: {
                if (node.isLeaf()) {
                    int j = compare(currentTreeNode.value, node.value);
                    switch (j) {
                        case -1:
                            currentTreeNode.rigth = null;
                            node = null;
                            return true;
                        case 1:
                            currentTreeNode.left = null;
                            node = null;
                            return true;
                    }

                } else if (node.hasOneChild()) {
                    T nodeValue = node.value;
                    if (node.left != null) {
                        node = node.left;
                    } else if (node.rigth != null) {
                        node = node.rigth;
                    }
                    int j = compare(currentTreeNode.value, nodeValue);
                    switch (j) {
                        case -1:
                            currentTreeNode.rigth = node;
                            node = null;
                            return true;
                        case 1:
                            currentTreeNode.left = node;
                            node = null;
                            return true;
                    }
                } else if (node.hasTowChild()) {
//                 
                    TreeNode newNode = getHigthLeft(node, node.left);
                    node.value = (T) newNode.value;
                    return true;

                }
            }
            case 1: {
                currentTreeNode = node;
                return remove(node.rigth, value);
            }
            case -1: {
                currentTreeNode = node;
                return remove(node.left, value);
            }

        }
        return false;
    }

    private TreeNode getHigthLeft(TreeNode<T> parentNode, TreeNode<T> currentNode) {
        if (currentNode.isLeaf()) {
            int i = compare(parentNode.value, currentNode.value);
            switch (i) {
                case 1:
                    parentNode.left = null;
                    return currentNode;
                case -1:
                    parentNode.rigth = null;
                    return currentNode;
            }
        }
        if (currentNode.rigth != null) {
            return getHigthLeft(currentNode, currentNode.rigth);
        }
        if (currentNode.left != null) {
            int i = compare(parentNode.value, currentNode.left.value);
            switch (i) {
                case 1:
                    parentNode.left = currentNode.left;
                    return currentNode;
                case -1:
                    parentNode.rigth = currentNode.left;
                    return currentNode;
            }

        }
        return currentNode;

    }

    public void insert(T value) {

        root = insert(root, value, null);
    }

    private TreeNode<T> insert(TreeNode<T> node, T value, TreeNode<T> parentNode) {
        if (node == null) {
            node = new TreeNode<>(value, null, null);
            size++;

        } else if (compare(value, node.value) < 0) {
            node.left = insert(node.left, value, node);
        } else if (compare(value, node.value) > 0) {
            node.rigth = insert(node.rigth, value, node);
        }
        node.balanceFactor = balanceFactor(node);
        return balance(node);
    }

    private TreeNode<T> balance(TreeNode<T> node) {
        if (balanceFactor(node) < -1) {
            if (balanceFactor(node.rigth) > 0) {
                node.rigth = leftRotate(node.rigth);
            }
            node = rigthRotate(node);
        } else if (balanceFactor(node) > 1) {
                if (balanceFactor(node.left) < 0) {
                    node.left = rigthRotate(node.left);
                }
                node = leftRotate(node);
            
        }

        return node;
    }

    private int balanceFactor(TreeNode<T> node) {
        return node.length(node.left) - node.length(node.rigth);
    }

    public boolean add(T value) {
        boolean isAdd = false;
        TreeNode<T> node = new TreeNode(value, null, null);

        if (root == null) {
            root = node;
            size++;
            isAdd = true;
        } else {
            currentTreeNode = root;
            addValue(value);
            isAdd = true;
        }
        return isAdd;
    }

    private void addValue(T value) {
        while (currentTreeNode != null) {
            if (value == currentTreeNode.value) {
                break;
            } else if (compare(value, currentTreeNode.value) < 0) {
                if (currentTreeNode.left == null) {
                    TreeNode node = new TreeNode(value, null, null);
                    currentTreeNode.left = node;
                    size++;
                    break;
                } else {
                    currentTreeNode = currentTreeNode.left;
                }
            } else if (compare(value, currentTreeNode.value) > 0) {
                if (currentTreeNode.rigth == null) {
                    TreeNode node = new TreeNode(value, null, null);
                    currentTreeNode.rigth = node;
                    size++;
                    break;
                } else {
                    currentTreeNode = currentTreeNode.rigth;
                }
            }
        }
    }

    public T first() {
        T value = null;
        currentTreeNode = root;
        while (currentTreeNode != null) {
            if (currentTreeNode.left == null) {
                value = currentTreeNode.value;
                break;
            } else {
                currentTreeNode = currentTreeNode.left;
            }
        }
        return value;
    }

    public T last() {
        T value = null;
        currentTreeNode = root;
        while (currentTreeNode != null) {
            if (currentTreeNode.rigth == null) {
                value = currentTreeNode.value;
                break;
            } else {
                currentTreeNode = currentTreeNode.rigth;
            }
        }
        return value;
    }

    public T least() {
        currentTreeNode = root;
        return least(root);
    }

    private T least(TreeNode<T> node) {
        if (node == null) {
            return currentTreeNode.value;
        } else {
            currentTreeNode = node;
            return least(node.left);
        }

    }

    public T higth() {
        currentTreeNode = root;
        return higth(root);
    }

    private T higth(TreeNode<T> node) {
        if (node == null) {
            return currentTreeNode.value;
        } else {
            currentTreeNode = node;
            return higth(node.rigth);
        }

    }

    public int length() {
        return root.length(root);
    }

    public void higthPaths() {
        T path[] = (T[]) Array.newInstance(Integer.class, size);

        root.higthPaths(root, path, 0);
    }

    public void paths() {
        T path[] = (T[]) Array.newInstance(Integer.class, 100);
        printPathsRecur(root, path, 0);
    }

    private void printPathsRecur(TreeNode<T> node, T path[], int pathLen) {
        if (node == null) {
            return;
        }
        path[pathLen] = node.value;
        pathLen++;
        if (node.left == null && node.rigth == null) {
            node.printArray(path, pathLen);
        } else {
            printPathsRecur(node.left, path, pathLen);
            printPathsRecur(node.rigth, path, pathLen);
        }
    }

    public boolean search(T value) {
        return search(root, value);
    }

    private boolean search(TreeNode<T> node, T value) {
        if (node == null) {
            return false;
        } else {
            int i = compare(value, node.value);
            switch (i) {
                case 0:
                    return true;
                case 1:
                    return search(node.rigth, value);
                case -1:
                    return search(node.left, value);
            }
        }
        return false;
    }

    public boolean contain(T value) {
        boolean isFound = false;
        currentTreeNode = root;
        while (currentTreeNode != null) {
            if (compare(value, currentTreeNode.value) == 0) {
                isFound = true;
                break;
            } else if (compare(value, currentTreeNode.value) < 0) {
                if (currentTreeNode.left == null) {
                    break;
                } else {
                    currentTreeNode = currentTreeNode.left;
                }
            } else if (compare(value, currentTreeNode.value) > 0) {
                if (currentTreeNode.rigth == null) {
                    break;
                } else {
                    currentTreeNode = currentTreeNode.rigth;
                }
            }
        }
        return isFound;
    }

    private int compare(T t, T y) {
        return t.compareTo(y);
    }

    public void print() {
        buffer = new StringBuffer();
        buffer.append(" [ ");

        root.printInOrder();

        System.out.println("In Order " + buffer.substring(0, buffer.length() - 1) + " ]");
        buffer = new StringBuffer();
        buffer.append(" [ ");

        root.printPostOrder();

        System.out.println(" Post  Order " + buffer.substring(0, buffer.length() - 1) + " ]");
        buffer = new StringBuffer();
        buffer.append(" [ ");

        root.printPreOrder();

        System.out.println(" PRE Order " + buffer.substring(0, buffer.length() - 1) + " ]");
    }

    public String display() {
        StringBuffer display = new StringBuffer();
        display.append(" [ ");
        displayINOrder(root, display);
        String displayString = display.substring(0, display.length() - 1);
        displayString += " ] ";

        System.out.println("Your Tree Is " + displayString);
        return displayString;
    }

    private void displayINOrder(TreeNode<T> node, StringBuffer buffer) {

        if (node == null) {
            return;
        }
        buffer.append(node.value).append(" ,");
        if (node.left != null) {
            displayINOrder(node.left, buffer);
        }
        if (node.rigth != null) {
            displayINOrder(node.rigth, buffer);
        }

    }

    private TreeNode<T> leftRotate(TreeNode<T> node) {
        TreeNode<T> y = node.left;
        TreeNode<T> T1 = y.rigth;
        node.left = T1;
        y.rigth = node;
        return y;
    }

    private TreeNode<T> rigthRotate(TreeNode<T> node) {
        TreeNode<T> y = node.rigth;
        TreeNode<T> T1 = y.left;
        node.rigth = T1;
        y.left = node;
        return y;
    }

    private class TreeNode<T extends Comparable<T>> {

        private T value;
        private TreeNode<T> left;
        private TreeNode<T> rigth;
        private int balanceFactor;
        private TreeNode<T> parentNode;

        public TreeNode() {
        }

        public TreeNode(T value, TreeNode<T> left, TreeNode<T> rigth) {
            this.value = value;
            this.left = left;
            this.rigth = rigth;
        }

        public TreeNode(T value, TreeNode<T> left, TreeNode<T> rigth, TreeNode<T> parentNode) {
            this.value = value;
            this.left = left;
            this.rigth = rigth;
            this.parentNode = parentNode;
        }

        public boolean isLeaf() {
            return this.left == null && this.rigth == null;
        }

        public void makeLeaf() {
            this.left = null;
            this.rigth = null;
        }

        public boolean hasOneChild() {
            return (!isLeaf()
                    && (this.left != null && this.rigth == null)
                    || (this.rigth != null && this.left == null));
        }

        public boolean hasTowChild() {
            return this.left != null && this.rigth != null;
        }

        public TreeNode getchild() {
            TreeNode child = null;
            if (hasOneChild()) {
                if (this.left != null) {
                    child = this.left;
                } else {
                    child = this.rigth;
                }
            }
            return child;
        }

        private void printInOrder() {

            if (this.left != null) {
                this.left.printInOrder();
            }
            buffer.append(this.value).append(" ,");
            if (this.rigth != null) {
                this.rigth.printInOrder();
            }

        }

        private void printPostOrder() {
            if (this.left != null) {
                this.left.printPostOrder();
            }

            if (this.rigth != null) {
                this.rigth.printPostOrder();
            }

            buffer.append(this.value).append(" ,");

        }

        private void printPreOrder() {
            buffer.append(this.value).append(" ,");
            if (this.left != null) {
                this.left.printPreOrder();
            }

            if (this.rigth != null) {
                this.rigth.printPreOrder();
            }
        }

        private int length(TreeNode<T> node) {
            if (node == null) {
                return 0;
            }
            int left = length(node.left);
            int rigth = length(node.rigth);
            return 1 + Math.max(left, rigth);
        }

        private void higthPaths(TreeNode<T> node, T path[], int pathLen) {
            if (node == null) {
                return;
            }
            path[pathLen] = node.value;
            pathLen++;
            if (node.left == null && node.rigth == null) {
                printArray(path, pathLen);
            } else {
                int left = length(node.left);
                int rigth = length(node.rigth);
                if (rigth > left) {
                    higthPaths(node.rigth, path, pathLen);
                } else if (rigth < left) {
                    higthPaths(node.left, path, pathLen);
                } else {
                    higthPaths(node.rigth, path, pathLen);
                    higthPaths(node.left, path, pathLen);

                }
            }
        }

        /* Utility function that prints out an array on a line. */
        void printArray(T ints[], int len) {
            int i;
            for (i = 0; i < len; i++) {
                System.out.print(ints[i] + " ");
            }
            System.out.println("");
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public TreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<T> left) {
            this.left = left;
        }

        public TreeNode<T> getRigth() {
            return rigth;
        }

        public void setRigth(TreeNode<T> rigth) {
            this.rigth = rigth;
        }

        public int getBalanceFactor() {
            return balanceFactor;
        }

        public void setBalanceFactor(int balanceFactor) {
            this.balanceFactor = balanceFactor;
        }

        public TreeNode<T> getParentNode() {
            return parentNode;
        }

        public void setParentNode(TreeNode<T> parentNode) {
            this.parentNode = parentNode;
        }

    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
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
//        tree.print();
//        tree.remove(20);
//        tree.print();
        System.out.println(tree.length());
//        System.out.println(tree.root.getBalanceFactor());
        tree.higthPaths();
    }

}
