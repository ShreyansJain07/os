public class InsertionSort {
    static void printArray(int arr[]){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]={5,7,2,9,1,6},j;
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            for (j=i-1 ; j>=0 && current < arr[j]; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = current;
        }
        printArray(arr);
    }
}
