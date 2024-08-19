# 1. Merge Sort
---------

Sort a given set of elements using Merge Sort and determine the time required to sort the elements. Repeat the experiment for different values of `n`, the number of elements in the list to be sorted, and plot a graph of the time taken versus the number of elements. The elements can be read from a file or generated using a random number generator.

## Code
------------

```java
import java.util.Random;

public class MergeSort{

    // Merge Sort implementation
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Sort the first and second halves
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    public static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, middle + 1, R, 0, n2);

        // Merge the temp arrays
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
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

            // Sort the array using merge sort
            mergeSort(array, 0, array.length - 1);

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
sunil@sunil:~daaLabManual/program01$ java MergeSort.java
Size: 100, Time taken: 90745 ns
Size: 1000, Time taken: 853677 ns
Size: 5000, Time taken: 1155572 ns
Size: 10000, Time taken: 1493659 ns
Size: 50000, Time taken: 8477575 ns
Size: 100000, Time taken: 13802170 ns
Size: 200000, Time taken: 37517808 ns
Size: 500000, Time taken: 81148003 ns
```

### Graph

#### Time complexity for Merge Sort is O(n*logn).

