package com.symonjin;

import com.symonjin.collections.BinaryHeap;
import com.symonjin.collections.BinaryMinHeap;
import com.symonjin.collections.BinarySearchTree;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        tree.put(3, "Three");
        tree.put(1, "One");
        tree.put(4, "Four");
        tree.put(50, "Fifty");
        tree.put(20, "Twenty");
        tree.delete(3);
        tree.inOrderTraversal();


    }
}
