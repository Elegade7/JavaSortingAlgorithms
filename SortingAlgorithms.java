import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

/**
 * SortingAlgorithms
 */
public class SortingAlgorithms {
    test
    public static void main(String[] args) {
        int size;
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        System.out.print("Input Array Size: ");
        size = input.nextInt();
        System.out.println();

        List<Integer> arr = new ArrayList<Integer>(); // array to be sorted

        // randomly generate array
        for (int i = 0; i < size; i++) {
            arr.add(1 + rand.nextInt(100));
        }
        System.out.println(arr);

        // sort
        System.out.println(MergeSort(arr));

        input.close();
    }

    public static List<Integer> MergeSort(List<Integer> arr) {
        List<Integer> arr1 = new ArrayList<Integer>();
        List<Integer> arr2 = new ArrayList<Integer>();

        if (arr.size() == 1)
            return arr;

        arr1 = arr.subList(0, (arr.size() / 2));
        arr2 = arr.subList((arr.size() / 2), arr.size());

        arr1 = MergeSort(arr1);
        arr2 = MergeSort(arr2);

        return merge(arr1, arr2);
    }

    public static List<Integer> merge(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> arr3 = new ArrayList<Integer>();
        ListIterator<Integer> arr1It = arr1.listIterator();
        ListIterator<Integer> arr2It = arr2.listIterator();

        while (arr1It.hasNext() && arr2It.hasNext()) {
            if (arr1.get(arr1It.nextIndex()) < arr2.get(arr2It.nextIndex())) {
                arr3.add(arr1.get(arr1It.nextIndex()));
                arr1It.next();
            } else {
                arr3.add(arr2.get(arr2It.nextIndex()));
                arr2It.next();
            }
        }

        while (arr1It.hasNext()) {
            arr3.add(arr1.get(arr1It.nextIndex()));
            arr1It.next();
        }
        while (arr2It.hasNext()) {
            arr3.add(arr2.get(arr2It.nextIndex()));
            arr2It.next();
        }

        return arr3;
    }

    public static void HeapSort(int[] arr) {

    }

    public static void BubbleSort(int[] arr) {

    }

    public static void QuickSort(int[] arr) {

    }
}