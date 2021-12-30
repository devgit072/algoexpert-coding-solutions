package solutions.hard;

public class QuickSort {
    public static int[] quickSort(int[] array) {
        quickSortUtil(array, 0, array.length-1);
        return array;
    }

    public static void quickSortUtil(int[] array, int start, int end) {
        if(start >= end) {
            return;
        }

        while (true) {
            System.out.println();
            int pivotIndex = (start+end)/2;
            int tempStart = start;
            int tempEnd = end;
            while (tempStart < pivotIndex && array[tempStart] <= array[pivotIndex]) {
                tempStart++;
            }
            while (tempEnd > pivotIndex && array[tempEnd] >= array[pivotIndex]) {
                tempEnd--;
            }
            if(tempStart == pivotIndex && tempEnd == pivotIndex) {
                quickSortUtil(array, start, pivotIndex-1);
                quickSortUtil(array, pivotIndex+1, end);
                return;
            } else {
                int temp = array[tempStart];
                array[tempStart] = array[tempEnd];
                array[tempEnd] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {8,8,8,8,8};//, 1, 0, 2, 9, 5, 6};
        //System.out.println(arr);
        arr = quickSort(arr);
        for(int i : arr) {
            System.out.print(i + "   ");
        }

    }
}
