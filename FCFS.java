public class FCFS {
    public static void main(String[] args) {
        int[] burst= {10,5,8};
        int[] wait = new int[burst.length];
        int[] turn = new int[burst.length];
        double avgWait=0,avgTurn=0;
        for (int i = 1; i < burst.length; i++) {
            wait[i]=burst[i-1]+wait[i-1];
            avgWait+=wait[i];
        }
        for (int i = 0; i < turn.length; i++) {
            turn[i]=burst[i]+wait[i];
            avgTurn+=turn[i];
        }
        System.out.println(avgTurn/burst.length);
        System.out.println(avgWait/burst.length);
    }
}
