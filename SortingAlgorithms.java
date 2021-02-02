import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

/**
 * SortingAlgorithms
 */
public class SortingAlgorithms {
    public static void main(String[] args) {
        int size;
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        System.out.print("Input Array Size: ");
        size = input.nextInt();
        System.out.println();

        // create array
        int[] arr = new int[size];

        // randomly generate array
        for (int i = 0; i < arr.length; i++)
            arr[i] = 1 + rand.nextInt(100);

        // print b4 sort
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + ", ");
        System.out.println();

        // sort
        // mergeSort(arr, 0, arr.length - 1);
        // HeapSort(arr, arr.length);
        BubbleSort(arr);

        // print sorted array
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + ", ");
        System.out.println();

        input.close();
    }

    public static void mergeSort(int[] arr, int leftHead, int rightTail) {
        if (leftHead >= rightTail)
            return;

        int middle = (leftHead + rightTail) / 2;
        mergeSort(arr, leftHead, middle);
        mergeSort(arr, middle + 1, rightTail);

        merge(arr, leftHead, rightTail);
    }

    public static void merge(int[] arr, int leftHead, int rightTail) {
        int[] temp = new int[arr.length]; // temp array
        int leftTail = (leftHead + rightTail) / 2;
        int rightHead = leftTail + 1;
        int size = rightTail - leftHead + 1;

        int leftP = leftHead; // pointer for right half
        int rightP = rightHead; // pointer for left half
        int ptrTA = leftHead; // pointer for temp array

        while (leftP <= leftTail && rightP <= rightTail) {
            if (arr[leftP] <= arr[rightP])
                temp[ptrTA++] = arr[leftP++];
            else
                temp[ptrTA++] = arr[rightP++];
        }

        System.arraycopy(arr, leftP, temp, ptrTA, leftTail - leftP + 1);
        System.arraycopy(arr, rightP, temp, ptrTA, rightTail - rightP + 1);
        System.arraycopy(temp, leftHead, arr, leftHead, size);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + ", ");
        System.out.println();
    }

    public static void HeapSort(int[] arr, int arrSize) {
        int heapSize = arrSize;
        buildMaxHeap(arr, arrSize);

        for (int i = arrSize; i > 1; i--) {
            // swap first and last
            int temp = arr[heapSize - 1];
            arr[heapSize - 1] = arr[0];
            arr[0] = temp;
            // decrease size since last element is sorted
            heapSize--;
            backToHeap(arr, 0, heapSize);
        }
    }

    public static void buildMaxHeap(int[] arr, int size) {
        for (int i = ((int) Math.floor(size / 2) - 1); i >= 0; i--) {
            backToHeap(arr, i, size);
        }
    }

    public static void backToHeap(int[] arr, int ptr, int size) {
        int max;
        int forRL = ptr + 1;

        int left = (forRL * 2) - 1;
        int right = (forRL * 2 + 1) - 1;

        if (left <= size - 1 && arr[left] > arr[ptr])
            max = left;
        else
            max = ptr;

        if (right <= size - 1 && arr[right] > arr[max])
            max = right;

        if (max != ptr) {
            // swap max and i
            int temp = arr[max];
            arr[max] = arr[ptr];
            arr[ptr] = temp;

            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + ", ");
            System.out.println();

            // heapify a starting at new max
            backToHeap(arr, max, size);
        }
    }

    public static void BubbleSort(int[] arr) {

    }

    public static void QuickSort(int[] arr) {

    }
}