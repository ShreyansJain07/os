import java.util.*;
class SumOfSubset {
    static void isSubsetSum(int set[], int n, int sum, List<Integer> subset) {
        if (sum == 0) {
            for (int i = subset.size() - 1; i >= 0; i--) {
                System.out.print(subset.get(i) + " ");
            }
            System.out.println();
            return;
        }
        if (n == 0 && sum != 0)
            return;

        if (set[n - 1] > sum) {
            isSubsetSum(set, n - 1, sum, subset);
            return;
        }

        List<Integer> subsetExcludingLast = new ArrayList<>(subset);
        isSubsetSum(set, n - 1, sum, subsetExcludingLast);
        subset.add(set[n - 1]);
        isSubsetSum(set, n - 1, sum - set[n - 1], subset);
        subset.remove(subset.size() - 1);
    }

    public static void main(String args[]) {
        int set[] = { 5,10,12,13,15,18 };
        int sum = 30;
        int n = set.length;
        List<Integer> subset = new ArrayList<>();
        isSubsetSum(set, n, sum, subset);
    }
}
