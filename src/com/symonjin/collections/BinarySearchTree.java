package com.symonjin.collections;

public class BinarySearchTree<K extends Comparable<K>, V> {

    private Node root;

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

        //The node already exist, but needed updating, therefore we
        //return the existing pointer.
        return currentNode;
    }

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

    public void delete(K key){
        //TODO
    }

    public V getMin(){
        Node current = root;
        while(current.right != null){
            current = current.right;
        }
        return current.value;
    }

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

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
