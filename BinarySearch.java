import java.util.Arrays;

public class BinarySearch {
    // 시간복잡도: O(logn)
    public static int binarySearch(int[] arr, int value) {
        // 이진 탐색은 정렬된 상태에서만 가능
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end / 2);

        while (start <= end) {
            // 찾음
            if (arr[mid] == value)
                return mid;
            // 찾고자 하는 값이 더 작으면 왼쪽 그룹에서 찾음
            if (arr[mid] > value)
                end = mid - 1;
            // 찾고자 하는 값이 더 크면 오른쪽 그룹에서 찾음
            else
                start = mid + 1;
            // mid 갱신
            mid = (start + end) / 2;
        }
        System.out.println("찾을 수 없습니다.");
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 10, 23, 26, 27, 29, 32, 43, 49};
        System.out.println(Arrays.toString(arr));
        System.out.println("32의 인덱스: " + BinarySearch.binarySearch(arr, 32));
    }
}
