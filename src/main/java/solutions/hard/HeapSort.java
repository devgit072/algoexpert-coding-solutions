package solutions.hard;

public class HeapSort {
    /**
     * The algorithm for Heapsort is
     * 1) First build the Maxheap. It will take O(n).
     * 2) Next, swap the first element of max heap to the end of the array. Once element is moved to last position, exclude this
     * index from the consideration. That is from next time onwards, consider the array from 0 to n-2 index, because at (n-1) index, the
     * largest element is already present.
     * Repeat this step (0 to n-1), (0 to n-2) and so on.
     */

    public static int[] heapSort(int[] array) {
        buildMaxHeap(array);
        // Array is in max heap. So first element is greatest now. Lets put this first element at last.
        for (int i = 0; i < array.length; i++) {
            int lastElementIndex = array.length - 1 - i;
            int temp = array[0];
            array[0] = array[lastElementIndex];
            array[lastElementIndex] = temp;
            heapify(array, 0, lastElementIndex);
        }
        return array;
    }

    static void buildMaxHeap(int[] arr) {
        for (int i = arr.length-1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    static void heapify(int[] arr, int index, int lastIndex) {
        if (index < 0 || index >= lastIndex) {
            return;
        }
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int biggestNodeIndex = index;
        if (leftChildIndex < lastIndex && arr[index] < arr[leftChildIndex]) {
            biggestNodeIndex = leftChildIndex;
        }
        if (rightChildIndex < lastIndex && arr[biggestNodeIndex] < arr[rightChildIndex]) {
            biggestNodeIndex = rightChildIndex;
        }
        if (index != biggestNodeIndex) {
            int temp = arr[biggestNodeIndex];
            arr[biggestNodeIndex] = arr[index];
            arr[index] = temp;
            heapify(arr, biggestNodeIndex, lastIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 3, 6, 2, 9, 1, 4};
        heapSort(arr);
        for(int i: arr) {
            System.out.print(i + "   ");
        }
    }
}
