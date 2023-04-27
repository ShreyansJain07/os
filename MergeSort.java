public class MergeSort {
    public static void conquer(int arr[], int start, int end, int mid) {
        int merged[] = new int[end - start + 1];
        int idx1 = start;
        int idx2 = mid + 1;
        int i = 0;
        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] <= arr[idx2])
                merged[i++] = arr[idx1++];
            else
                merged[i++] = arr[idx2++];
        }
        while(idx1<=mid) merged[i++] = arr[idx1++];
        while(idx2<=end) merged[i++] = arr[idx2++];
        for (int j = 0,k=0; j < merged.length; j++,k++) {
            arr[start+j] = merged[k];
        }
    }
    

    public static void divide(int arr[], int start, int end) {
        if (start >= end)
            return;
        int mid = start + (end - start) / 2;
        divide(arr, start, mid);
        divide(arr, mid + 1, end);
        conquer(arr, start, end, mid);
        ;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 9, 3, 5, 2, 8 };
        divide(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
