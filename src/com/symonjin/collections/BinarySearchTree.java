package com.symonjin.collections;

public class BinarySearchTree<K extends Comparable<K>, V> {

    private Node root;

    /**
     * Inserts a key-value pair into the binary tree, replacing
     * the previous value if it already exists, or creating a
     * new node if it does not exist yet.
     */
    public void put(K key, V value){
        root = put(root, key, value);
    }

    private Node put(Node currentNode, K key, V value){
        if(currentNode == null){
            //Create an new node and return a pointer to it
            return new Node(key, value);
        }

        int result = key.compareTo(currentNode.key);
        if(result < 0){
            currentNode.left = put(currentNode.left, key, value);
        }else if (result > 0){
            currentNode.right = put(currentNode.right, key, value);
        }else{
            //Update the node to its new value
            currentNode.value = value;
        }

        //Update the node's count for deletion
        currentNode.count = 1 + size(currentNode.left) + size(currentNode.right);

        //The node already exist, but needed updating, therefore we
        //return the existing pointer to keep the links originally.
        return currentNode;
    }

    /**
     * Retrieves the value from the given key, returning the value
     * or null if the key does not exist.
     */
    public V get(K key){
        Node currentNode = root;

        while(currentNode != null){
            int result = key.compareTo(currentNode.key);

            //In a BST: right side holds larger values
            //left side holds smaller values
            if(result < 0){
                currentNode = currentNode.left;
            }else if (result > 0){
                currentNode = currentNode.right;
            }else{
                return currentNode.value;
            }
        }

        return null;
    }

    /**
     * Returns the size of the tree
     */
    public int size(){
        return size(root);
    }

    private int size(Node currentNode){
        if(currentNode == null){
            return 0;
        }
        return currentNode.count;
    }

    public void delete(K key){
        //TODO
    }

    /**
     * Returns the largest key value within the tree,
     * which is the right-most node
     */
    public V getMin(){
        Node current = root;
        while(current.right != null){
            current = current.right;
        }
        return current.value;
    }

    /**
     * Returns the smallest key value within the tree,
     * which is the left-most node
     */
    public V getMax(){
        Node current = root;
        while(current.left != null){
            current = current.left;
        }
        return current.value;
    }


    private class Node{
        private K key;
        private V value;
        private Node left, right;
        private int count;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
