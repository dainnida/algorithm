import java.util.Arrays;

public class InsertSort {
    // 시간복잡도: 최악 O(n^2), 최선 O(n)
    // 공간복잡도: O(1)
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int index = i - 1;
            while (index >= 0 && arr[index] > temp) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {29, 10, 27, 49, 26, 43, 23, 32, 5};
        System.out.println(Arrays.toString(arr));
        InsertSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
