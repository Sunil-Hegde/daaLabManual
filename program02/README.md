# 2. Quick Sort
---------

Sort a given set of elements using Quick Sort and determine the time required to sort the elements. Repeat the experiment for different values of `n`, the number of elements in the list to be sorted, and plot a graph of the time taken versus the number of elements. The elements can be read from a file or generated using a random number generator.

## Code
------------

```java
package program2;
import java.util.Random;

public class QuickSort {
    // Quick Sort implementation
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            // Recursively sort elements before and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (array[j] <= pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap array[i + 1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Generate an array with random integers
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000); // Generate random integers between 0 and 9999
        }
        return array;
    }

    public static void main(String[] args) {
        // Define the sizes of arrays to test
        int[] sizes = {100, 1000, 5000, 10000, 50000, 100000, 200000, 500000};
        for (int size : sizes) {
            int[] array = generateRandomArray(size);
            // Record start time in nanoseconds
            long startTime = System.nanoTime();
            // Sort the array using quick sort
            quickSort(array, 0, array.length - 1);
            // Record end time in nanoseconds
            long endTime = System.nanoTime();
            // Calculate and display the time taken in nanoseconds
            long timeTaken = endTime - startTime;
            System.out.println("Size: " + size + ", Time taken: " + timeTaken + " ns");
        }
    }
}

```

## Output
---------

```
sunil@sunil:~daaLabManual/program01$ java QuickSort.java
Size: 100, Time taken: 31928 ns
Size: 1000, Time taken: 390821 ns
Size: 5000, Time taken: 418341 ns
Size: 10000, Time taken: 836881 ns
Size: 50000, Time taken: 5127389 ns
Size: 100000, Time taken: 7445483 ns
Size: 200000, Time taken: 15604122 ns
Size: 500000, Time taken: 50061383 ns
```

### Graph

#### Time complexity for Quick Sort is O(n*logn).

