import java.util.ArrayList;

public class LRU {

    public static void main(String[] args) {
        int capacity = 4;
        int arr[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 };
        ArrayList<Integer> s = new ArrayList<>(capacity);
        int count = 0;
        int page_faults = 0;
        int hits = 0;
        for (int i : arr) {
            System.out.print(i+ "\t\t");
            if (!s.contains(i)) {
                if (s.size() == capacity) {
                    s.remove(0);
                    s.add(capacity - 1, i);
                } else
                    s.add(count, i);
                page_faults++;
                ++count;

            } else {
                s.remove((Object) i);
                s.add(s.size(), i);
                hits++;
            }
            System.out.println(s);
        }
        System.out.println("Page faults: " + page_faults);
        System.out.println("Page fault Ratio: " + ((double) page_faults / arr.length));
        System.out.println("Hits: " + hits);
        System.out.println("Hit Ratio : " + ((double) hits / arr.length));
    }
}
