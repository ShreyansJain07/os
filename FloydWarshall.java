import java.util.Scanner;

public class FloydWarshall {

    static final int INF = 999;
    static int d[][];
    static int p[][];
    static int g[][];
    static int v;

    public static void readGraph() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the graph:");
        for(int i=0; i<v; i++) {
            for(int j=0; j<v; j++) {
                g[i][j] = scanner.nextInt();
            }
        }
    }

    public static void displayGraph(int g[][]) {
        for(int i=0; i<v; i++) {
            for(int j=0; j<v; j++) {
                System.out.print(g[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void initialization() {
        for(int i=0; i<v; i++) {
            for(int j=0; j<v; j++) {
                if(i == j) {
                    d[i][j] = 0;
                    p[i][j] = -1;
                } else if(g[i][j] == 0) {
                    d[i][j] = INF;
                    p[i][j] = -1;
                } else {
                    d[i][j] = g[i][j];
                    p[i][j] = i;
                }
            }
        }
    }

    public static void floydWarshall() {
        for(int k=0; k<v; k++) {
            for(int i=0; i<v; i++) {
                for(int j=0; j<v; j++) {
                    if(d[i][j] <= d[i][k] + d[k][j]) {
                        continue;
                    } else {
                        d[i][j] = d[i][k] + d[k][j];
                        p[i][j] = p[k][j];
                    }
                }
            }
        }
    }

    public static void printPath(int s, int v) {
        if(v == s) {
            System.out.print(" " + s + " ");
        } else if(p[s][v] == -1) {
            System.out.println("\nNo path exists");
        } else {
            printPath(s, p[s][v]);
            System.out.print("->");
            System.out.print(v);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of vertices: ");
        v = scanner.nextInt();

        g = new int[v][v];
        d = new int[v][v];
        p = new int[v][v];

        readGraph();
        System.out.println("\nGraph is:");
        displayGraph(g);

        initialization();
        System.out.println("\nAfter initialization");
        System.out.println("\nD Matrix");
        displayGraph(d);

        System.out.println("\nP Matrix");
        displayGraph(p);

        floydWarshall();
        System.out.println("\nAfter Floyd-Warshall");
        System.out.println("\nD Matrix");
        displayGraph(d);

        System.out.println("\nP Matrix");
        displayGraph(p);

        System.out.println("\nPrinting Path");
        for(int i=0; i<v; i++) {
            for(int j=0; j<v; j++) {
                if(i == j) {
                    continue;
                }
                System.out.print("Path from " + i + " to " + j + " is ");
                printPath(i, j);
                System.out.println();
            }
        }
    }
}
