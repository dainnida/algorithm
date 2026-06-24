import java.util.Arrays;

public class QuickSort {
    // 시간복잡도: 최악 O(n^2) -> 피벗이 항상 가장 작은 값이거나 가장 큰 값일 때
    // 시간복잡도: 최선 O(nlog₂n) -> 항상 반으로 쪼개질 때
    // 공간복잡도: 최악 O(n) 최선 O(logn)
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;

        int pivotIndex = partition(arr, start, end);

        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }
    
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start + 1;
        int right = end;

        // left와 right가 교차할 때까지 왼쪽에는 pivot보다 작은 값, 오른쪽에는 pivot보다 큰 값 두기
        while (left <= right) {
            // pivot보다 큰 값 찾을 때까지 left 이동
            while (left <= end && arr[left] <= pivot)
                left++;
            // pivot보다 작은 값을 찾을 때까지 right 이동
            while (right > start && arr[right] >= pivot)
                right--;
            // 교차하지 않았다면 두 값 교환
            if (left < right)
                swap(arr, left, right);
        }
        // 교차했다면 right와 pivot을 교환
        swap(arr, start, right);

        // pivot 자리 반환(right 자리에 pivot이 들어감)
        return right;
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {29, 10, 27, 49, 26, 43, 23, 32, 5};
        System.out.println(Arrays.toString(arr));
        QuickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
