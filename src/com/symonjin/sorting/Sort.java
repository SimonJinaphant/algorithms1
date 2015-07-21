package com.symonjin.sorting;

public class Sort {
    /*
        Goal: Organize an array such that for an element at index p,
        all elements to the left are smaller than p, and elements to
        the right are larger than p. Elements do not have 100% sorted.

        Solution: Partition the array by selecting a pivoting element and
        reorganizing elements relative to that pivot
     */
    public static <T extends Comparable<? super T>> int partition(
            T[] input, int lower, int upper) {

        //Lower bound element is the pivoting element

        //i and j are 'pointers' located at both ends of the array respectively
        int i = lower, j = upper + 1;

        while (i <= j) {
            while (less(input[++i], input[lower])) {
                //Keep moving the pointer right until we reached an element that is
                //larger than the pivoting element
                if (i == upper) break;
            }
            while (less(input[lower], input[--j])) {
                //Keep moving the pointer left until we reached an element that is
                //smaller than the pivoting element
                if (j == lower) break;
            }

            //Stop when pointers cross
            if (i >= j) break;

            //Once both pointers stop moving, swap the elements at both pointers
            swap(input, i, j);
        }

        //Move the pivot into its correct position
        swap(input, lower, j);

        return j;
    }


    protected static <T extends Comparable<? super T>> boolean less(T left, T right) {
        return left.compareTo(right) == -1;
    }

    public static <T extends Comparable<? super T>> void swap(T[] input, int a, int b) {
        T temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

}
