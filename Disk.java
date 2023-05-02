import java.util.Arrays;
import java.util.Vector;

public class Disk {
    public static void sstf(int arr[], int head) {
        Arrays.sort(arr);
        int count = 0, seekTime = 0;
        while (count < arr.length) {
            int min = Integer.MAX_VALUE, index = 0, diff = 0;
            for (int i = 0; i < arr.length; i++) {
                diff = Math.abs(arr[i] - head);
                if (diff < min) {
                    min = diff;
                    index = i;
                }
            }
            seekTime += min;
            head = arr[index];
            arr[index] = Integer.MAX_VALUE;
            count++;
        }
        System.out.println(seekTime);
    }

    public static void scan(int arr[], int head) {
        Arrays.sort(arr);
        System.out.println(Math.abs(arr[arr.length - 1] + head));
        // System.out.println(Math.abs(199-head)+(199-arr[0]));
    }

    public static void fcfs(int arr[], int head) {
        int seekTime = 0;
        for (int i = 0; i < arr.length; i++) {
            seekTime += Math.abs(arr[i] - head);
            head = arr[i];
        }
        System.out.println(seekTime);
    }

    public static void look(int arr[], int head) {
        Arrays.sort(arr);
        System.out.println(Math.abs(arr[arr.length - 1] - head) + Math.abs(arr[arr.length - 1] - arr[0]));
    }

    public static void cscan(int arr[], int head) {
        Arrays.sort(arr);
        Vector<Integer> low = new Vector<>();
        Vector<Integer> high = new Vector<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < head)
                low.add(arr[i]);
            else
                high.add(arr[i]);
        }
        int seekTime = Math.abs(199 - head) + Math.abs(low.get(low.size() - 1) - 0) + 199;
        System.out.println(seekTime);
    }

    public static void clook(int arr[], int head){
        Arrays.sort(arr);
        Vector<Integer> low = new Vector<>();
        Vector<Integer> high = new Vector<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < head)
                low.add(arr[i]);
            else
                high.add(arr[i]);
        }
        int seekTime = Math.abs(high.get(high.size() - 1) - head) + Math.abs(low.get(low.size() - 1) - low.get(0)) + Math.abs(high.get(high.size() - 1)-low.get(0));
        System.out.println(seekTime);
    }

    public static void main(String[] args) {
        int arr[] = { 176, 79, 34, 60,92, 11, 41, 114 };
        int head = 50;
        // fcfs(arr, head);
        // scan(arr, head);
        // sstf(arr, head);
        // look(arr, head);
        // cscan(arr, head);
        clook(arr, head);
    }
}
