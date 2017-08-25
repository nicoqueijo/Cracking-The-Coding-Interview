/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

import java.util.Random;

/**
 *
 * @author nicoq
 */
public class InsertionSort {

    public static void main(String[] args) {

        // Initialize a list of 100 Integer objects
        Integer[] list = new Integer[100];
        Random rand = new Random();

        // Generate a random number between 1-100 and store it in each index
        for (int i = 0; i < list.length; i++) {
            list[i] = new Integer(rand.nextInt(100) + 1);
        }

        // Print the list before sort
        System.out.println("One hundred random numbers:");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i].toString() + ", ");
        }

        // Sort the list
        insertionSort(list);

        // Print the list after sort
        System.out.println("\n\nSorted:");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i].toString() + ", ");
        }
    }
    
    // Time complexity:
    // Worst case: O(n^2)
    // Best case: O(n)
    public static void insertionSort(Comparable[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if (list[j].compareTo(list[j - 1]) >= 0) {
                    break;
                } else {
                    Comparable temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                }
            }
        }
    }

}
