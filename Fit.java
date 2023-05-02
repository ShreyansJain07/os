public class Fit {
    public static void worst(int part[], int process[]) {
        for (int i = 0; i < process.length; i++) {
            int index = -1;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < part.length; j++) {
                if (part[j] >= process[i] && part[j] > max) {
                    max = part[j];
                    index = j;
                }
            }
            if (index != -1) {
                System.out.println("process " + process[i] + " is put in " + part[index] + " partition");
                part[index] -= process[i];
            } else {
                System.out.println("process " + process[i] + " must wait");
            }
        }
    }

    public static void best(int part[], int process[]) {
        for (int i = 0; i < process.length; i++) {
            int index = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < part.length; j++) {
                if (part[j] >= process[i] && part[j] < min) {
                    min = part[j];
                    index = j;
                }
            }
            if (index != -1) {
                System.out.println("process " + process[i] + " is put in " + part[index] + " partition");
                part[index] -= process[i];
            } else {
                System.out.println("process " + process[i] + " must wait");
            }
        }
    }
    

    public static void first(int part[], int process[]) {
        for (int i = 0; i < process.length; i++) {
            int f = 0;
            for (int j = 0; j < part.length; j++) {
                if (process[i] < part[j]) {
                    System.out.println("process " + process[i] + " is put in " + part[j] + " partition");
                    part[j] -= process[i];
                    f = 1;
                    break;
                }
            }
            if (f == 0)
                System.out.println("process " + process[i] + " must wait");
        }
    }

    public static void main(String[] args) {
        int part[] = { 100, 500, 200, 300, 600 };
        int process[] = { 212, 417, 112, 426 };
        // first(part,process);
        // System.out.println();
        // best(part, process);
        // System.out.println();
        worst(part, process);
    }
}
