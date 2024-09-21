package program07;

import java.util.Random;

public class HeapSort{
    public static void heapSort(int[] array) {
        int n = array.length;
        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        // One by one extract an element from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            // Call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }
    // To heapify a subtree rooted with node i
    public static void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child
        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        // If largest is not root
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }
    // Generate an array with random integers
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }
        return array;
    }
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 5000, 10000, 50000, 100000, 200000, 500000};
        for (int size : sizes) {
            int[] array = generateRandomArray(size);
            // Record start time in nanoseconds
            long startTime = System.nanoTime();
            // Sort the array using heap sort
            heapSort(array);
            // Record end time in nanoseconds
            long endTime = System.nanoTime();
            // Calculate and display the time taken in nanoseconds
            long timeTaken = endTime - startTime;
            System.out.println("Size: " + size + ", Time taken: " + timeTaken + " ns");
        }
    }
}
