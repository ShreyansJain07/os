import java.util.ArrayList;

public class Optimal {
    public static int getOptimalIndex(ArrayList<Integer> s, int arr[], int i) {
        int index = -1;
        int farthest = i + 1;
        for (int j = 0; j < s.size(); j++) {
            int k;
            for (k = i + 1; k < arr.length; k++) {
                if (s.get(j) == arr[k]) {
                    if (k > farthest) {
                        farthest = k;
                        index = j;
                    }
                    break;
                }
            }
            if (k == arr.length) {
                return j;
            }
        }
        return (index == -1) ? 0 : index;
    }

    public static void main(String[] args) {
        int capacity = 4;
        int arr[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 };
        ArrayList<Integer> s = new ArrayList<>(capacity);
        int fault = 0;
        int hit = 0;
        for (int i = 0; i < arr.length; i++) {
            if (s.contains(arr[i])) {
                hit++;
            } else {
                if (s.size() < capacity) {
                    s.add(arr[i]);
                } else {
                    int index = getOptimalIndex(s, arr, i);
                    s.set(index, arr[i]);
                }
                fault++;
            }
            System.out.println(s);
        }
        double fault_ratio = (double) fault / arr.length;
        double hit_ratio = (double) hit / arr.length;
        System.out.println("Page faults: " + fault + ", Fault ratio: " + fault_ratio);
        System.out.println("Page hits: " + hit + ", Hit ratio: " + hit_ratio);
    }
}
