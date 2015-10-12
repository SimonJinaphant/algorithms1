package com.symonjin.collections;

/**
 * Created by Simon on 2015-10-11.
 */
public class Tree<K, V> {

    public void preOrderTraversal(){
        preOrderTraversal(root);
    }

    protected void preOrderTraversal(Node current){
        if(current == null){
            return;
        }

        System.out.println(current.value);
        preOrderTraversal(current.left);
        preOrderTraversal(current.right);
    }

    public void inOrderTraversal(){
        preOrderTraversal(root);
    }

    protected void inOrderTraversal(Node current){
        if(current == null){
            return;
        }

        preOrderTraversal(current.left);
        System.out.println(current.value);
        preOrderTraversal(current.right);
    }

    public void postOrderTraversal(){
        preOrderTraversal(root);
    }

    protected void postOrderTraversal(Node current){
        if(current == null){
            return;
        }
        preOrderTraversal(current.left);
        preOrderTraversal(current.right);
        System.out.println(current.value);

    }

    private Node root;

    protected class Node{
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
