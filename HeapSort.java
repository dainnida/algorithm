import java.util.Arrays;

public class HeapSort {
    // 시간복잡도: O(nlogn)
    // 공간복잡도: O(n)
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 최대 힙 만들기
        for (int i = n / 2 - 1; i >= 0; i--) {
            // 부모가 더 작은 값이면 자식과 교환
            heapify(arr, n, i);
        }

        // 가장 큰 값(루트 노드)를 맨 뒤부터 차례차례 채우기
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i); // 가장 큰 값(루트 노드)와 정해지지 않은 곳 중 맨 뒤와 교환
            heapify(arr, i, 0); // 깨진 힙을 다시 정렬
        }
    }

    // 최대 힙 만들기
    public static void heapify(int[] arr, int n, int parentIdx) {
        int largestIdx = parentIdx;
        int leftChildIdx = parentIdx * 2 + 1;
        int rightChildIdx = parentIdx * 2 + 2;

        // 더 큰 값 찾기
        if (leftChildIdx < n && arr[leftChildIdx] > arr[largestIdx]) {
            largestIdx = leftChildIdx;
        }
        if (rightChildIdx < n && arr[rightChildIdx] > arr[largestIdx]) {
            largestIdx = rightChildIdx;
        }

        // 더 큰 값과 부모와 교환
        if (largestIdx != parentIdx) {
            swap(arr, parentIdx, largestIdx);
            // 깨진 힙을 다시 정렬
            heapify(arr, n, largestIdx);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {29, 10, 27, 49, 26, 43, 23, 32, 5};
        System.out.println(Arrays.toString(arr));
        HeapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}