import java.util.Arrays;

public class MergeSort {
    
    public static void mergeSort(int[] arr, int start, int end) {
        // 원소가 1개 이하로 쪼개지면 끝
        if (start >= end)
            return;

        // 먼저 반으로 자르기
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        // 자른 거 정렬하면서 합치기
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        // 합친 결과를 저장할 임시 배열
        int[] temp = new int[end - start + 1];

        int i = start; // 나뉜 것 중 왼쪽 그룹의 시작 포인터
        int j = mid + 1; // 오른쪽 그룹의 시작 포인터
        int k = 0; // 임시 배열에 저장할 인덱스

        // 1. 두 그룹에 모두 데이터가 남아있음
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        // 2-1. 왼쪽 그룹에만 데이터가 남아있음
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 2-2. 오른쪽 그룹에만 데이터가 남아있음
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        // 원래 배열에 임시 배열 복사
        for (int l = start; l <= end; l++) {
            arr[l] = temp[l - start];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {29, 10, 27, 49, 26, 43, 23, 32, 5};
        System.out.println(Arrays.toString(arr));
        MergeSort.mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
