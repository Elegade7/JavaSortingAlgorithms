import java.util.Random;
import java.util.Scanner;

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
        mergeSort(arr, 0, arr.length - 1);

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

    public static void HeapSort(int[] arr) {

    }

    public static void BubbleSort(int[] arr) {

    }

    public static void QuickSort(int[] arr) {

    }
}