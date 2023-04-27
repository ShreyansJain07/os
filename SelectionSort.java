public class SelectionSort {
    static void printArray(int arr[]){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        for (int i = 0; i < arr.length-1; i++) {
            int smallest = i;
            for (int j = i+1; j < arr.length; j++) 
                smallest = arr[j]<arr[smallest]?j:smallest;
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
            printArray(arr);
        }
    }
}
