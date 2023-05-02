public class SJF {
    public static void main(String[] args) {
        int[] burst= {3,1,2};
        int[] wait = new int[burst.length];
        int[] turn = new int[burst.length];
        double avgWait=0,avgTurn=0;
        int[] id=new int[burst.length];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        for (int i = 0; i < turn.length-1; i++) {
            for (int j = 0; j < turn.length-i-1; j++) {
                if(burst[j]>burst[j+1]){
                    int temp = burst[j];
                    burst[j]=burst[j+1];
                    burst[j+1]=temp;

                    int temp1 = id[j];
                    id[j]=id[j+1];
                    id[j+1]=temp1;
                }
            }
        }
        for (int i = 1; i < burst.length; i++) {
            wait[i]=burst[i-1]+wait[i-1];
            avgWait+=wait[i];
        }
        for (int i = 0; i < turn.length; i++) {
            turn[i]=burst[i]+wait[i];
            avgTurn+=turn[i];
        }

        for (int i = 0; i < turn.length-1; i++) {
            for (int j = 0; j < turn.length-i-1; j++) {
                if(id[j]>id[j+1]){  // Change the conditional statement to sort in ascending order
                    int temp4 = id[j];
                    id[j]=id[j+1];
                    id[j+1]=temp4;
        
                    int temp = burst[j];
                    burst[j]=burst[j+1];
                    burst[j+1]=temp;
                    
                    int t = turn[j];
                    turn[j]=turn[j+1];
                    turn[j+1]=t;
        
                    int temp3 = wait[j];
                    wait[j]=wait[j+1];
                    wait[j+1]=temp3;
                }
            }
        }

        System.out.println("Process\tburst\tturn\twait");
        for (int i = 0; i < id.length; i++) {
            System.out.println(i+1+"\t"+burst[i]+"\t"+turn[i]+"\t"+wait[i]+"\t"+id[i]);
        }
        System.out.println(avgTurn/burst.length);
        System.out.println(avgWait/burst.length);
    }
}
