import java.util.Scanner;

public class Prims {
    private static int n, ne = 1,mincost=0;
    private static int[] visited, parent;
    private static int[][] cost;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        n = scanner.nextInt();

        cost = new int[n][n];
        visited = new int[n];
        parent = new int[n];

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = scanner.nextInt();
                if (cost[i][j] == 0) {
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        visited[0] = 1;
        while (ne < n) {
            int min = Integer.MAX_VALUE, a = 0, b = 0, u = 0, v = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i] == 1) {
                    for (int j = 0; j < n; j++) {
                        if (visited[j] == 0 && cost[i][j] < min) {
                            min = cost[i][j];
                            a = u = i;
                            b = v = j;
                        }
                    }
                }
            }

            if (visited[u] == 1 && visited[v] == 0) {
                System.out.printf("\nEdge"+(ne++)+": "+(a+1)+"->"+(b+1)+" cost: "+min);
                mincost+=min;
                visited[b] = 1;
                parent[b] = a;
            }
            cost[a][b] = cost[b][a] = Integer.MAX_VALUE;
        }

        System.out.println("\nMinimum cost = " + mincost);
    }
}
