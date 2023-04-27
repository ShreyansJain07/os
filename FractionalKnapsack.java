import java.util.Arrays;

class FractionalKnapsack {
    static int fractionalKnapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        double[] vpw = new double[n];
        for (int i = 0; i < n; i++) {
            vpw[i] = (double) values[i] / weights[i];
        }
        for (int i = 0; i < vpw.length - 1; i++) {
            for (int j = 0; j < vpw.length - 1 - i; j++) {
                if (vpw[j] < vpw[j + 1]) {
                    double temp = vpw[j];
                    vpw[j] = vpw[j + 1];
                    vpw[j + 1] = temp;

                    int temp1 = weights[j];
                    weights[j] = weights[j + 1];
                    weights[j + 1] = temp1;

                    int temp2 = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp2;
                }
            }
        }
        double sol[] = new double[n], total = 0.0;
        Arrays.fill(sol, 0);
        int remCap = capacity, i;
        for (i = 0; i < n; i++) {
            if (weights[i] > remCap)
                break;
            sol[i] = 1;
            remCap -= weights[i];
        }
        if (i < n && remCap > 0)
            sol[i] = (double) remCap / weights[i];
        for (int j = 0; j < sol.length; j++) {
            String str=String.format("%.2f",sol[j]);
            System.out.println(str+" "+values[j]);
            total += sol[j] * values[j];
        }
        return (int) total;
    }

    public static void main(String[] args) {
        int[] values = { 30,40,45,77,90};
        int[] weights = {5,10,15,22,25};
        int capacity = 60;
        double totalProfit = fractionalKnapsack(values, weights, capacity);
        System.out.println("Total profit earned: " + totalProfit);
    }
}
