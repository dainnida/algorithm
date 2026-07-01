import java.util.Arrays;

public class SelectionSort {
    // 시간복잡도: 최악 O(n^2), 최선 O(n^2)
    // 공간복잡도: O(1)
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] {29, 10, 27, 49, 26, 43, 23, 32, 5};
        System.out.println(Arrays.toString(arr));
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
