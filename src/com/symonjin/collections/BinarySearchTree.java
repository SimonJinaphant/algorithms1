package com.symonjin.collections;

public class BinarySearchTree<K extends Comparable<K>, V> extends Tree<K,V>{

    /**
     * Insert a new key-value pair into the binary tree, replacing
     * a previous key-value pair if it already exists
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
     * Retrieve the value from the given key, returning the value
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
     * Return the size of the tree
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


    /**
     * Return the largest key value within the tree,
     * which is the right-most node
     */
    public V getMin(){
        return getMin(root).value;
    }

    private Node getMin(Node node){
        Node current = node;
        while(current.right != null){
            current = current.right;
        }
        return current;
    }

    /**
     * Return the smallest key value within the tree,
     * which is the left-most node
     */
    public V getMax(){
        return getMax(root).value;
    }

    private Node getMax(Node node){
        Node current = node;
        while(current.left != null){
            current = current.left;
        }
        return current;
    }

    /**
     * Delete the smallest node (the bottom-leftmost node)
     * in the tree
     */
    public void deleteMin(){
        root = deleteMin(root);
    }

    /**
     * Goto the bottom-leftmost node and replace the min node's
     * parent left link with the min node's right link to preserve
     * any nodes that are right childs on the min node.
     */
    private Node deleteMin(Node node){
        if(node.left == null){
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    /**
     * Delete the node with the given key
     */
    public void delete(K key){
        if(key == root.key){
            System.err.println("Cannot delete tree's root node");
            return;
        }
        root = delete(root, key);
    }

    /**
     * Delete the given node with the corresponding key,
     * readjusting the tree if required.
     */
    private Node delete(Node node, K key){
        if(node == null){
            return null;
        }

        int result = key.compareTo(node.key);
        if(result < 0){
            //Current node's key is larger, goto the left node
            node.left = delete(node.left, key);
        }else if (result > 0){
            //Current node's key is smaller, goto right node
            node.right = delete(node.right, key);
        }else{
            //Found the node to delete

            //If node has no right child, set parent's link to left
            if(node.right == null) return node.left;
            //If node has no left child, set parent's link to right
            if(node.left == null) return node.right;

            //Node has two child node, need to replace with
            //successor node
            Node temp = node;
            node = getMin(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.count = 1 + size(node.left) + size(node.right);

        return node;
    }


}
